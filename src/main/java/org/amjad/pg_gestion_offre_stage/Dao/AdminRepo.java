package org.amjad.pg_gestion_offre_stage.Dao;

import java.util.Optional;

import org.amjad.pg_gestion_offre_stage.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {

    Optional<Admin>findByEmail(String email);

}
