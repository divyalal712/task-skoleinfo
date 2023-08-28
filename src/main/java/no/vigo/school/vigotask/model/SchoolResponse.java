package no.vigo.school.vigotask.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SchoolResponse {
    @JsonProperty("_embedded")
    private EmbeddedResponse embeddedResponse;

}
