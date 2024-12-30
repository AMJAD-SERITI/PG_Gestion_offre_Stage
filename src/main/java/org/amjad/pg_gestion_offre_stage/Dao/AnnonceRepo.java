

package org.amjad.pg_gestion_offre_stage.Dao;
import org.amjad.pg_gestion_offre_stage.Entity.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnonceRepo extends JpaRepository<Annonce, Long> {
}
