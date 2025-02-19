package org.amjad.pg_gestion_offre_stage.Dao;

import org.amjad.pg_gestion_offre_stage.Entity.Encadrant;
import org.amjad.pg_gestion_offre_stage.Entity.Stagiaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StagiaireRepo  extends JpaRepository<Stagiaire, Long> {
    Optional<Stagiaire> findByEmail(String email);

    List<Stagiaire> findByEncadrant(Encadrant encadrant);
}
