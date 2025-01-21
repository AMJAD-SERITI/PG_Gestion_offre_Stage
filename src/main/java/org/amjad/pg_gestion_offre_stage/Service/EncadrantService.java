package org.amjad.pg_gestion_offre_stage.Service;

import java.util.List;

import org.amjad.pg_gestion_offre_stage.DTO.LoginRequest;
import org.amjad.pg_gestion_offre_stage.Dao.EncadrantRepo;
import org.amjad.pg_gestion_offre_stage.Entity.Condidat;
import org.amjad.pg_gestion_offre_stage.Entity.Encadrant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class EncadrantService {

    @Autowired
    private EncadrantRepo encadrantRepo;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Encadrant getEncadrantById(Long encadrantId) {
        return encadrantRepo.findById(encadrantId).orElseThrow(() -> new IllegalStateException("Encadrant with id " + encadrantId + " does not exist"));
    }

    public Encadrant registerEncadrant(Encadrant encadrant) {
        return encadrantRepo.save(encadrant);
    }

    public void saveEncadrant(Encadrant encadrant) {
        String passwordEncoded = bCryptPasswordEncoder.encode(encadrant.getPassword());
        encadrant.setPassword(passwordEncoded);
        encadrantRepo.save(encadrant);
    }

    @Transactional
    public void validateEncadrant(Long id) {
        Encadrant encadrant = encadrantRepo.findById(id).orElseThrow(() -> new IllegalStateException("Encadrant with id " + id + " does not exist"));
        encadrant.setValidated(true);
        encadrantRepo.save(encadrant);
    }

    public void unvalidateEncadrant(Long id) {
        Encadrant encadrant = encadrantRepo.findById(id).orElseThrow(() -> new IllegalStateException("Encadrant with id " + id + " does not exist"));
        encadrant.setValidated(false);
        encadrantRepo.save(encadrant);
    }

    public List<Condidat> getCondidats(Long encadrantId) {
        Encadrant encadrant = encadrantRepo.findById(encadrantId).orElseThrow(() -> new RuntimeException("Encadrant not found"));
        return encadrant.getCondidats();
    }

    public Encadrant findByEmail(String email) {
        return encadrantRepo.findByEmail(email).orElseThrow(() -> new UnsupportedOperationException("Unimplemented method 'findByEmail'"));
    }
}
