package org.amjad.pg_gestion_offre_stage.Dao;

import org.amjad.pg_gestion_offre_stage.Entity.Stagiaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StagiaireRepo  extends JpaRepository<Stagiaire, Long> {
}
