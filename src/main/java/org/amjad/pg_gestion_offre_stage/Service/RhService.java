package org.amjad.pg_gestion_offre_stage.Service;

import jakarta.transaction.Transactional;
import org.amjad.pg_gestion_offre_stage.Dao.RhRepo;
import org.amjad.pg_gestion_offre_stage.Entity.Condidat;
import org.amjad.pg_gestion_offre_stage.Entity.Encadrant;
import org.amjad.pg_gestion_offre_stage.Entity.Rh;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RhService {

    @Autowired
    private  RhRepo rhRepo;
    @Autowired
    private  CondidatService condidatService;
    @Autowired
    private  EncadrantService encadrantService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public Rh getRhById(Long id) {
        return rhRepo.findById(id).orElseThrow(() -> new IllegalStateException("Rh with id " + id + " does not exist"));
    }

    public void saveRh(Rh rh) {
        if(rhRepo.findByEmail(rh.getEmail()).isPresent()) {
            throw new IllegalStateException("Email already taken");
        }
        String passwordEncoded = bCryptPasswordEncoder.encode(rh.getPassword());
        rh.setPassword(passwordEncoded);
        rhRepo.save(rh);
    }

    public List<Rh> getAllRhs() {
        return rhRepo.findAll();
    }

    public Rh updateRh(Long id, Rh updatedRh) {
        Rh rh = rhRepo.findById(id).orElseThrow(() -> new IllegalStateException("Rh with id " + id + " does not exist"));
        rh.setNom(updatedRh.getNom());
        rh.setPrenom(updatedRh.getPrenom());
        rh.setEmail(updatedRh.getEmail());
        rh.setPassword(updatedRh.getPassword());
        return rhRepo.save(rh);
    }

    public void deleteRh(Long id) {
        rhRepo.deleteById(id);
    }

    public Optional<Rh> findByEmail(String email) {
        return rhRepo.findByEmail(email);
    }
}
