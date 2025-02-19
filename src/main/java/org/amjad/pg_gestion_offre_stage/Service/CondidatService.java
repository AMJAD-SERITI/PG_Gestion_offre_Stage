package org.amjad.pg_gestion_offre_stage.Service;

import org.amjad.pg_gestion_offre_stage.Dao.CondidatRepo;
import org.amjad.pg_gestion_offre_stage.Entity.Condidat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CondidatService {

    @Autowired
    private CondidatRepo condidatRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public Condidat getCondidatById(Long id) {
        return condidatRepo.findById(id).orElseThrow(() -> new IllegalStateException("Condidat with id " + id + " does not exist"));
    }

    public void registerCondidat(Condidat condidat) {
        String encodedPassword = bCryptPasswordEncoder.encode(condidat.getPassword());
        condidat.setPassword(encodedPassword);
        condidatRepo.save(condidat);
    }

    public Condidat getCondidatByEmail(String email) {
        return condidatRepo.findByEmail(email).orElseThrow(() -> 
        new IllegalStateException("Condidat with email " + email + " does not exist"));
    }

    public List<Condidat> getAllCondidat() {
        return condidatRepo.findAll();
    }

    public Condidat findByEmail(String email) {
        return condidatRepo.findByEmail(email).orElseThrow(() -> new UnsupportedOperationException("Unimplemented method 'findByEmail'"));
    }

    public Condidat getCondidatByEmail(String email) {
        return condidatRepo.findByEmail(email).orElseThrow(() -> 
        new IllegalStateException("Condidat with email " + email + " does not exist"));
    }

    public List<Condidat> getAllCondidat() {
        return condidatRepo.findAll();
    }

    public Condidat findByEmail(String email) {
        return condidatRepo.findByEmail(email).orElseThrow(() -> new UnsupportedOperationException("Unimplemented method 'findByEmail'"));
    }
}
