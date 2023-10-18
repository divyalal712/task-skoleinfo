package no.skole.task.model.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class Gyldighets {

    private Long id;
    private String start;
    private String slutt;
}
