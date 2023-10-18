package no.skole.task.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchoolInfoRepository  extends JpaRepository<SchoolDetailsEntity, Long> {

    List<SchoolDetailsEntity> findByPostnummerAndPassiv(String postnummer, boolean passiv);
    List<SchoolDetailsEntity> findByOrganisasjonsnummer(String organisasjonsnummer);

    void deleteAllByOrganisasjonsnummer(String organisasjonsnummer);
}
