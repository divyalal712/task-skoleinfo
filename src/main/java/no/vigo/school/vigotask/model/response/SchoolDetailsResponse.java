package no.vigo.school.vigotask.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import no.vigo.school.vigotask.model.common.Link;
import no.vigo.school.vigotask.model.common.SystemId;
import no.vigo.school.vigotask.model.request.Gyldighets;

@Getter
@Setter
public class SchoolDetailsResponse {
    private String navn;
    private SystemId systemId;
    private Gyldighets gyldighetsperiode;
    private String organisasjonsnummer;
    private String postnummer;
    private boolean passiv;
    @JsonProperty("_links")
    private Link links;
}
