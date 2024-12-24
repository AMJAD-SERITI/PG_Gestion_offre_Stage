package org.amjad.pg_gestion_offre_stage.Dao;

import org.amjad.pg_gestion_offre_stage.Entity.Encadrant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncadrantRepo extends JpaRepository<Encadrant, Long> {
}
