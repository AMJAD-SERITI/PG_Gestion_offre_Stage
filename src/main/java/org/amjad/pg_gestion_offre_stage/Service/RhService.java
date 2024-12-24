package org.amjad.pg_gestion_offre_stage.Service;

import jakarta.transaction.Transactional;
import org.amjad.pg_gestion_offre_stage.Dao.RhRepo;
import org.amjad.pg_gestion_offre_stage.Entity.Condidat;
import org.amjad.pg_gestion_offre_stage.Entity.Encadrant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RhService {

    private final RhRepo rhRepo;
    private final CondidatService condidatService;
    private final EncadrantService encadrantService;

    @Autowired
    public RhService(RhRepo rhRepo, CondidatService condidatService, EncadrantService encadrantService) {
        this.rhRepo = rhRepo;
        this.condidatService = condidatService;
        this.encadrantService = encadrantService;
    }

    @Transactional
    public void associateCondidatToEncadrant(Long condidatId, Long encadrantId) {
        Condidat condidat = condidatService.getCondidatById(condidatId);
        Encadrant encadrant = encadrantService.getEncadrantById(encadrantId);
        condidat.setEncadrant(encadrant);
    }
}
