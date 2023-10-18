package no.skole.task.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class EmbeddedResponse {
    @JsonProperty("_entries")
    List<Entry> entries;

}
