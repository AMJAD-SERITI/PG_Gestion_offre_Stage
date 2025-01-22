package org.amjad.pg_gestion_offre_stage.Service;

import java.util.List;

import org.amjad.pg_gestion_offre_stage.DTO.LoginRequest;
import org.amjad.pg_gestion_offre_stage.Dao.EncadrantRepo;
import org.amjad.pg_gestion_offre_stage.Entity.Condidat;
import org.amjad.pg_gestion_offre_stage.Entity.Encadrant;
import org.amjad.pg_gestion_offre_stage.Entity.Stagiaire;
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
    @Autowired
    private ServiceStagiaire serviceStagiaire;

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

    public List<Stagiaire> getStagiaire(Long encadrantId) {
        Encadrant encadrant = encadrantRepo.findById(encadrantId).orElseThrow(() -> new RuntimeException("Encadrant not found"));
        return encadrant.getStagiaires();
    }

    public Encadrant findByEmail(String email) {
        return encadrantRepo.findByEmail(email).orElseThrow(() -> new UnsupportedOperationException("Unimplemented method 'findByEmail'"));
    }

    public List<Encadrant> getAllEncadrants() {
        return encadrantRepo.findAll();
    }

    public Encadrant updateEncadrant(Long id, Encadrant updatedEncadrant) {
        Encadrant encadrant = encadrantRepo.findById(id).orElseThrow(() -> new IllegalStateException("Encadrant with id " + id + " does not exist"));
        encadrant.setNom(updatedEncadrant.getNom());
        encadrant.setPrenom(updatedEncadrant.getPrenom());
        encadrant.setEmail(updatedEncadrant.getEmail());
        encadrant.setPassword(updatedEncadrant.getPassword());
        return encadrantRepo.save(encadrant);
    }

    public void deleteEncadrant(Long id) {
        encadrantRepo.deleteById(id);
    }

}
