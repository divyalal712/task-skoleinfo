package no.vigo.school.vigotask.dao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import no.vigo.school.vigotask.model.common.Self;

import java.util.List;

@Getter
@Setter
@Entity
public class LinkEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "link_entity_id")
    private List<SelfEntity> self;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "link_entity_id")
    private List<SelfEntity> skoleeiertype;
}
