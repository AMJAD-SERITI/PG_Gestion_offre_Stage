package org.amjad.pg_gestion_offre_stage.Dao;

import org.amjad.pg_gestion_offre_stage.Entity.Condidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CondidatRepo extends JpaRepository<Condidat, Long> {
}
