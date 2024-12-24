package org.amjad.pg_gestion_offre_stage.Service;

import jakarta.transaction.Transactional;
import org.amjad.pg_gestion_offre_stage.Dao.ManagerRepo;
import org.amjad.pg_gestion_offre_stage.Entity.Condidat;
import org.amjad.pg_gestion_offre_stage.Entity.Encadrant;
import org.amjad.pg_gestion_offre_stage.Entity.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {

    private final ManagerRepo managerRepo;
    private final CondidatService condidatService;
    private final EncadrantService encadrantService;

    @Autowired
    public ManagerService(ManagerRepo managerRepo, CondidatService condidatService, EncadrantService encadrantService) {
        this.managerRepo = managerRepo;
        this.condidatService = condidatService;
        this.encadrantService = encadrantService;
    }

    public void saveManager(Manager manager) {
        managerRepo.save(manager);
    }

    @Transactional
    public void associateCondidatToEncadrant(Long condidatId, Long encadrantId) {
        Condidat condidat = condidatService.getCondidatById(condidatId);
        Encadrant encadrant = encadrantService.getEncadrantById(encadrantId);
        condidat.setEncadrant(encadrant);
        condidatService.saveCondidat(condidat);
    }
}
