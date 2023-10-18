package no.skole.task.model.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Link {
    private List<Self> self;
    private List<Self> skoleeiertype;
}
