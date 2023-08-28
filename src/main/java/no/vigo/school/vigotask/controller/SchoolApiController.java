package no.vigo.school.vigotask.controller;

import jakarta.validation.Valid;
import no.vigo.school.vigotask.model.SchoolResponse;
import no.vigo.school.vigotask.model.request.SchoolDetailRequest;
import no.vigo.school.vigotask.model.response.SchoolDetailsResponse;
import no.vigo.school.vigotask.service.SchoolOwnerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/school")
public class SchoolApiController {

    @Autowired
    private SchoolOwnerTypeService service;


    @PostMapping("/create")
    public ResponseEntity<String> createSchoolDetails(@RequestBody @Valid SchoolDetailRequest request) {

        service.validateSkoleeierTypeAndSave(request);
        return ResponseEntity.ok("School info created successfully");
    }

    @GetMapping("/{postNummer}/{passiv}")
    public ResponseEntity<List<SchoolDetailsResponse>> getSchoolDetailsByPostnummerAndPassive(
            @PathVariable String postNummer, @PathVariable Boolean passiv) {
        List<SchoolDetailsResponse> response = service.getSchoolDetailsByPostNummerAndPassiv(postNummer, passiv);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/relasjonsdata")
    public ResponseEntity<SchoolResponse> getRelasjonsdata() {
        SchoolResponse response = service.getAllSkoleeierType();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{organisasjonsnummer}")
    public ResponseEntity<String> deleteByOrganisasjonsnummer(@PathVariable String organisasjonsnummer) {
        service.deleteSchoolByOrganisasjonsnummer(organisasjonsnummer);
        return ResponseEntity.ok("School info deleted successfully");
    }

}
