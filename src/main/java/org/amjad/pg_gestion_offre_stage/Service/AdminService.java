package org.amjad.pg_gestion_offre_stage.Service;

import org.amjad.pg_gestion_offre_stage.Dao.AdminRepo;
import org.amjad.pg_gestion_offre_stage.Entity.Admin;
import org.amjad.pg_gestion_offre_stage.Entity.Rh;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final AdminRepo adminRepo;
    private final RhService rhService;

   
    public AdminService(AdminRepo adminRepo, RhService rhService) {
        this.adminRepo = adminRepo;
        this.rhService = rhService;
    }

    public void valifateRh(Long id) {
        Rh rh = rhService.getRhById(id);
        rh.setValidated(true);
        rhService.saveRh(rh);
    }

    public Admin findByEmail(String email) {
        return adminRepo.findByEmail(email).orElseThrow(() -> new UnsupportedOperationException("Unimplemented method 'findByEmail'"));
    }
}
