package no.skole.task.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import no.skole.task.model.common.Link;
import no.skole.task.model.common.SystemId;

@Getter
@Setter
@ToString
public class SchoolDetailRequest {

    private String navn;
    private SystemId systemId;
    private Gyldighets gyldighetsperiode;
    private String organisasjonsnummer;
    private String postnummer;
    private boolean passiv;
    @JsonProperty("_links")
    private Link links;

}
