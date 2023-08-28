package no.vigo.school.vigotask.converter;

import no.vigo.school.vigotask.dao.GyldighetsEntity;
import no.vigo.school.vigotask.dao.SchoolDetailsEntity;
import no.vigo.school.vigotask.dao.SelfEntity;
import no.vigo.school.vigotask.dao.SystemIdEntity;
import no.vigo.school.vigotask.model.common.Link;
import no.vigo.school.vigotask.model.common.Self;
import no.vigo.school.vigotask.model.common.SystemId;
import no.vigo.school.vigotask.model.request.Gyldighets;
import no.vigo.school.vigotask.model.response.SchoolDetailsResponse;

import java.util.ArrayList;
import java.util.List;

public class EntityToResponseConverter {

    public static SchoolDetailsResponse convertToResponse(SchoolDetailsEntity entity) {
        SchoolDetailsResponse schoolDetailsResponse = new SchoolDetailsResponse();

        schoolDetailsResponse.setNavn(entity.getNavn());
        schoolDetailsResponse.setSystemId(covert(entity.getSystemId()));
        schoolDetailsResponse.setGyldighetsperiode(convert(entity.getGyldighetsperiode()));
        schoolDetailsResponse.setOrganisasjonsnummer(entity.getOrganisasjonsnummer());
        schoolDetailsResponse.setPostnummer(entity.getPostnummer());
        schoolDetailsResponse.setPassiv(entity.isPassiv());

        Link links = new Link();
        links.setSelf(convertSelfList(entity.getLinks().getSelf()));
        links.setSkoleeiertype(convertSelfList(entity.getLinks().getSkoleeiertype()));
        schoolDetailsResponse.setLinks(links);

        return schoolDetailsResponse;
    }

    private static Gyldighets convert(GyldighetsEntity entity) {
        Gyldighets gyldighets = new Gyldighets();
        gyldighets.setStart(entity.getStart());
        gyldighets.setSlutt(entity.getSlutt());
        return gyldighets;
    }

    private static SystemId covert(SystemIdEntity entity) {
        SystemId systemId = new SystemId();
        systemId.setIdentifikatorverdi(entity.getIdentifikatorverdi());
        return systemId;
    }

    private static List<Self> convertSelfList(List<SelfEntity> selfEntities) {
        List<Self> selfList = new ArrayList<>();
        for (SelfEntity entity : selfEntities) {
            Self self = new Self();
            self.setHref(entity.getHref());
            selfList.add(self);
        }
        return selfList;
    }
}
