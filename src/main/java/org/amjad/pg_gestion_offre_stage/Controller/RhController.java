package org.amjad.pg_gestion_offre_stage.Controller;

import org.amjad.pg_gestion_offre_stage.Entity.Condidat;
import org.amjad.pg_gestion_offre_stage.Entity.Demande;
import org.amjad.pg_gestion_offre_stage.Entity.Encadrant;
import org.amjad.pg_gestion_offre_stage.Service.CondidatService;
import org.amjad.pg_gestion_offre_stage.Service.DemandeService;
import org.amjad.pg_gestion_offre_stage.Service.RhService;
import org.amjad.pg_gestion_offre_stage.Service.EncadrantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/rh")
@CrossOrigin(origins = "http://localhost:3000")
public class RhController {

    @Autowired
    private  RhService rhService;
    @Autowired
    private DemandeService demandeService;


    @GetMapping("/demandes")
    public List<Demande> getDemandes() {
        return demandeService.getEnAttentDemandes();
    }

    @GetMapping("/nonValideDemandes")
    public List<Demande> getNonValideDemandes() {
        return demandeService.getNonValideDemandes();
    }

    @GetMapping("/valideDemandes")
    public List<Demande> getValideDemandes() {
        return demandeService.getValideDemandes();
    }

    @PutMapping("/validerDemande")
    public ResponseEntity<String> validerDemande(@RequestParam("id") Long id) {
        try {
            demandeService.validerDemande(id);
            return ResponseEntity.ok("Demande with id " + id + " has been validated");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error validating demand: " + e.getMessage());
        }
    }

    @PutMapping("/nonValiderDemande")
    public ResponseEntity<String> nonValiderDemande(@RequestParam("id") Long id) {
        try {
            demandeService.nonValiderDemande(id);
            return ResponseEntity.ok("Demande with id " + id + " has been non validated");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error non validating demand: " + e.getMessage());
        }
    }
}
