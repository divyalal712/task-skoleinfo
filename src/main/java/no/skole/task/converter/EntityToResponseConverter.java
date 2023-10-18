package no.skole.task.converter;

import no.skole.task.dao.GyldighetsEntity;
import no.skole.task.dao.SchoolDetailsEntity;
import no.skole.task.dao.SelfEntity;
import no.skole.task.dao.SystemIdEntity;
import no.skole.task.model.common.Link;
import no.skole.task.model.common.Self;
import no.skole.task.model.common.SystemId;
import no.skole.task.model.request.Gyldighets;
import no.skole.task.model.response.SchoolDetailsResponse;

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
