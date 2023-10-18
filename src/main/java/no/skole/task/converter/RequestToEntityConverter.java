package no.skole.task.converter;

import no.skole.task.dao.*;
import no.skole.task.model.common.Self;
import no.skole.task.model.common.SystemId;
import no.skole.task.model.request.Gyldighets;
import no.skole.task.model.request.SchoolDetailRequest;
import java.util.ArrayList;
import java.util.List;

public class RequestToEntityConverter {

    public static SchoolDetailsEntity convertToEntity(SchoolDetailRequest request) {
        SchoolDetailsEntity entity = new SchoolDetailsEntity();

        entity.setNavn(request.getNavn());
        entity.setSystemId(covert(request.getSystemId()));
        entity.setGyldighetsperiode(convert(request.getGyldighetsperiode()));
        entity.setOrganisasjonsnummer(request.getOrganisasjonsnummer());
        entity.setPostnummer(request.getPostnummer());
        entity.setPassiv(request.isPassiv());

        LinkEntity links = new LinkEntity();
        links.setSelf(convertSelfList(request.getLinks().getSelf()));
        links.setSkoleeiertype(convertSelfList(request.getLinks().getSkoleeiertype()));
        entity.setLinks(links);

        return entity;
    }

    private static GyldighetsEntity convert(Gyldighets gyldighetsperiode) {
        GyldighetsEntity entity = new GyldighetsEntity();
        entity.setStart(gyldighetsperiode.getStart());
        entity.setSlutt(gyldighetsperiode.getSlutt());
        return entity;
    }

    private static SystemIdEntity covert(SystemId systemId) {
        SystemIdEntity entity = new SystemIdEntity();
        entity.setIdentifikatorverdi(systemId.getIdentifikatorverdi());
        return entity;
    }

    private static List<SelfEntity> convertSelfList(List<Self> selfList) {
        List<SelfEntity> selfEntities = new ArrayList<>();
        for (Self self : selfList) {
            SelfEntity selfEntity = new SelfEntity();
            selfEntity.setHref(self.getHref());
            selfEntities.add(selfEntity);
        }
        return selfEntities;
    }

}
