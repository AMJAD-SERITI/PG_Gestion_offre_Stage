package org.amjad.pg_gestion_offre_stage.Service;

import org.amjad.pg_gestion_offre_stage.Dao.StagiaireRepo;
import org.amjad.pg_gestion_offre_stage.Entity.Stagiaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceStagiaire {
    @Autowired
    private StagiaireRepo stagiaireRepo;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    public Stagiaire addStagiaire(Stagiaire stagiaire) {
        if(stagiaireRepo.findByEmail(stagiaire.getEmail()).isPresent()) {
            throw new IllegalStateException("Email already taken");
        }
        String passwordEncoded = bCryptPasswordEncoder.encode(stagiaire.getPassword());
        stagiaire.setPassword(passwordEncoded);
        return stagiaireRepo.save(stagiaire);
    }

    public void deleteStagiaire(Long id){
        stagiaireRepo.deleteById(id);
    }

    public List<Stagiaire> getAllStagiaire() {
        return stagiaireRepo.findAll();
    }

    public Stagiaire updateStagiaire(Long id, Stagiaire updatedStagiaire) {
        Stagiaire stagiaire = stagiaireRepo.findById(id).orElseThrow(() -> new IllegalStateException("Stagiaire with id " + id + " does not exist"));
        stagiaire.setNom(updatedStagiaire.getNom());
        stagiaire.setPrenom(updatedStagiaire.getPrenom());
        stagiaire.setEmail(updatedStagiaire.getEmail());
        stagiaire.setPassword(updatedStagiaire.getPassword());
        stagiaire.setStatut(updatedStagiaire.getStatut());
        stagiaire.setSujet(updatedStagiaire.getSujet());
        return stagiaireRepo.save(stagiaire);
    }

    public Stagiaire changeStagiaireStatus(Long id, Stagiaire updatedStagiaire) {
        Stagiaire stagiaire = stagiaireRepo.findById(id).orElseThrow(() -> new IllegalStateException("Stagiaire with id " + id + " does not exist"));
        stagiaire.setStatut(updatedStagiaire.getStatut());
        return stagiaireRepo.save(stagiaire);
    }

    public Stagiaire getStagiaireById(Long stagiaireId) {
        return stagiaireRepo.findById(stagiaireId).orElseThrow(() -> new IllegalStateException("Stagiaire with id " + stagiaireId + " does not exist"));
    }

    public Optional<Stagiaire> findByEmail(String email) {
        return stagiaireRepo.findByEmail(email);
    }
}
