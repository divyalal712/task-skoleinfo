package no.vigo.school.vigotask.dao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import no.vigo.school.vigotask.model.common.SystemId;
import no.vigo.school.vigotask.model.request.Gyldighets;

@Getter
@Setter
@Entity
public class SchoolDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String navn;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "system_id_id")
    private SystemIdEntity systemId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "gyldighetsperiode_id")
    private GyldighetsEntity gyldighetsperiode;
    private String organisasjonsnummer;
    private String postnummer;
    private boolean passiv;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "linkEntity_id")
    private LinkEntity links;

}
