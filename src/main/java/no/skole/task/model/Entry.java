package no.skole.task.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import no.skole.task.model.common.Link;
import no.skole.task.model.common.SystemId;

@Getter
@Setter
@ToString
public class Entry {

    private String kode;
    private String navn;
    private SystemId systemId;
    @JsonProperty("_links")
    private Link links;
}
