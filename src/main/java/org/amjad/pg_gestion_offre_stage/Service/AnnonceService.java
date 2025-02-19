/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package org.amjad.pg_gestion_offre_stage.Service;

import org.amjad.pg_gestion_offre_stage.Dao.AnnonceRepo;
import org.amjad.pg_gestion_offre_stage.Entity.Annonce;
import org.springframework.stereotype.Service;

@Service
public class AnnonceService {

    private final AnnonceRepo announceRepo;

    public AnnonceService(AnnonceRepo announceRepo) {
        this.announceRepo = announceRepo;
    }

    public void addAnnounce(Annonce announce) {
        announceRepo.save(announce);
    }

    public void deleteAnnounce(Long id) {
        announceRepo.deleteById(id);
    }

    public void updateAnnounce(Annonce announce) {
        announceRepo.save(announce);
    }

    public Annonce getAnnounceById(Long id) {
        return announceRepo.findById(id).orElse(null);
    }

    public Iterable<Annonce> getAllAnnounces() {
        return announceRepo.findAll();
    }
    
}
