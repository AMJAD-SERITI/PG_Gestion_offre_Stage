package org.amjad.pg_gestion_offre_stage.Controller;

import java.util.List;
import org.amjad.pg_gestion_offre_stage.Entity.Stagiaire;
import org.amjad.pg_gestion_offre_stage.Service.EncadrantService;
import org.amjad.pg_gestion_offre_stage.Service.ServiceStagiaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/encadrant")
@CrossOrigin(origins = "http://localhost:3000")
public class EncadrantController {

    @Autowired
    private EncadrantService encadrantService;
    @Autowired
    private ServiceStagiaire serviceStagiaire;

    @GetMapping("/stagiaire/{id}")
    public List<Stagiaire> getStagiaire(@PathVariable Long id) {
        return encadrantService.getStagiaire(id);
    }

    @GetMapping("/stagiaires")
    public List<Stagiaire> getAllStagiaire() {
        return serviceStagiaire.getAllStagiaire();
    }

    @PutMapping("/stagiaire/update/{id}")
    public ResponseEntity<Stagiaire> updateStagiaire(@PathVariable Long id, @RequestBody Stagiaire stagiaire) {
        if (id == null || stagiaire == null || stagiaire.getStatut() == null) {
            return ResponseEntity.badRequest().body(null);
        }

        Stagiaire updatedStagiaire = serviceStagiaire.updateStagiaire(id, stagiaire);
        return ResponseEntity.ok(updatedStagiaire);
    }
    
}

