package no.skole.task.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import no.skole.task.model.common.Link;
import no.skole.task.model.common.SystemId;
import no.skole.task.model.request.Gyldighets;

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
