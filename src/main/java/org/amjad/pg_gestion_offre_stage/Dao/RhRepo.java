package org.amjad.pg_gestion_offre_stage.Dao;


import java.util.Optional;

import org.amjad.pg_gestion_offre_stage.Entity.Rh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RhRepo extends JpaRepository<Rh, Long> {

    Optional<Rh> findByEmail(String email);

}
