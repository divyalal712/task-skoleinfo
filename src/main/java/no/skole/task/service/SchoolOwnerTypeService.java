package no.skole.task.service;

import no.skole.task.converter.EntityToResponseConverter;
import no.skole.task.converter.RequestToEntityConverter;
import no.skole.task.dao.SchoolDetailsEntity;
import no.skole.task.dao.SchoolInfoRepository;
import no.skole.task.exception.SkoleException;
import no.skole.task.model.Entry;
import no.skole.task.model.SchoolResponse;
import no.skole.task.model.common.Self;
import no.skole.task.model.request.SchoolDetailRequest;
import no.skole.task.model.response.SchoolDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchoolOwnerTypeService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private SchoolInfoRepository schoolInfoRepository;

    @Value("${api.school-owner.url}")
    private String apiUrl;



    public void validateSkoleeierTypeAndSave(SchoolDetailRequest request) {

        List<Self> skoleeierTypesRequest = request.getLinks().getSkoleeiertype();
        List<Self> validatedSkoleeierTypes = new ArrayList<>();

        SchoolResponse response = getAllSkoleeierType();

        List<Entry> entries = response.getEmbeddedResponse().getEntries();
        for (Entry entry : entries) {
            List<Self> selfLinks = entry.getLinks().getSelf();
            for (Self obj1 : skoleeierTypesRequest) {
                for (Self obj2 : selfLinks) {
                    if (obj1.getHref().equals(obj2.getHref())) {
                        validatedSkoleeierTypes.add(obj1);
                        break;
                    }
                }
            }
        }

        if (validatedSkoleeierTypes.isEmpty()) {
            throw new SkoleException(HttpStatus.BAD_REQUEST, "Skoleeiertype in the request is not valid");
        }

        SchoolDetailsEntity schoolDetailsEntity = RequestToEntityConverter.convertToEntity(request);
        schoolInfoRepository.save(schoolDetailsEntity);

    }

    public SchoolResponse getAllSkoleeierType(){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> httpEntity = new HttpEntity<>(headers);

        ResponseEntity<SchoolResponse> responseEntity = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                httpEntity,
                SchoolResponse.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();

        } else {
            throw new SkoleException(responseEntity.getStatusCode(), "External API returned an error");
        }
    }

    public List<SchoolDetailsResponse> getSchoolDetailsByPostNummerAndPassiv(String postNummer, Boolean passiv) {

        List<SchoolDetailsEntity> byPostnummerAndPassiv = schoolInfoRepository.findByPostnummerAndPassiv(postNummer, passiv);

        List<SchoolDetailsResponse> responseList = new ArrayList<>();
        for (SchoolDetailsEntity entity :byPostnummerAndPassiv) {
            SchoolDetailsResponse schoolDetailsResponse = EntityToResponseConverter.convertToResponse(entity);
            responseList.add(schoolDetailsResponse);
        }
        return responseList;
    }


    @Transactional
    public void deleteSchoolByOrganisasjonsnummer(String organisasjonsnummer) {
        List<SchoolDetailsEntity> byOrganisasjonsnummer = schoolInfoRepository.findByOrganisasjonsnummer(organisasjonsnummer);
        if (!byOrganisasjonsnummer.isEmpty()){
            schoolInfoRepository.deleteAllByOrganisasjonsnummer(organisasjonsnummer);
        }
        else {
            throw new SkoleException(HttpStatus.NOT_FOUND, "No data found for given organisasjonsnummer: "+organisasjonsnummer);
        }
    }
}
