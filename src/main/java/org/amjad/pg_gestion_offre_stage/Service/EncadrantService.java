package org.amjad.pg_gestion_offre_stage.Service;

import org.amjad.pg_gestion_offre_stage.Dao.EncadrantRepo;
import org.amjad.pg_gestion_offre_stage.Entity.Encadrant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EncadrantService {

    private final EncadrantRepo encadrantRepo;

    @Autowired
    public EncadrantService(EncadrantRepo encadrantRepo) {
        this.encadrantRepo = encadrantRepo;
    }

    public Encadrant getEncadrantById(Long encadrantId) {
        return encadrantRepo.findById(encadrantId).orElseThrow(() -> new IllegalStateException("Encadrant with id " + encadrantId + " does not exist"));
    }

    public Encadrant registerEncadrant(Encadrant encadrant) {
        return encadrantRepo.save(encadrant);
    }

}
