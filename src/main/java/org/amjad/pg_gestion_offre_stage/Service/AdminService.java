package org.amjad.pg_gestion_offre_stage.Service;

import org.amjad.pg_gestion_offre_stage.Dao.AdminRepo;
import org.amjad.pg_gestion_offre_stage.Entity.Admin;
import org.amjad.pg_gestion_offre_stage.Entity.Rh;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepo adminRepo;
    @Autowired
    private RhService rhService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public void registerAdmin(Admin admin) {
        String passwordEncoded = bCryptPasswordEncoder.encode(admin.getPassword());
        admin.setPassword(passwordEncoded);
        adminRepo.save(admin);
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
