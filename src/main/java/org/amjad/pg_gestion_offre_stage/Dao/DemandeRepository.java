package org.amjad.pg_gestion_offre_stage.Dao;

import org.amjad.pg_gestion_offre_stage.Entity.Demande;
import org.amjad.pg_gestion_offre_stage.Enum.Etat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemandeRepository extends JpaRepository<Demande, Long> {
    List<Demande> findByEtat(Etat etat);
}
