package org.amjad.pg_gestion_offre_stage.Controller;

import org.amjad.pg_gestion_offre_stage.DTO.EncadrantDTO;
import org.amjad.pg_gestion_offre_stage.DTO.StagiaireDTO;
import org.amjad.pg_gestion_offre_stage.Entity.Condidat;
import org.amjad.pg_gestion_offre_stage.Entity.Demande;
import org.amjad.pg_gestion_offre_stage.Entity.Encadrant;
import org.amjad.pg_gestion_offre_stage.Entity.Stagiaire;
import org.amjad.pg_gestion_offre_stage.Service.CondidatService;
import org.amjad.pg_gestion_offre_stage.Service.DemandeService;
import org.amjad.pg_gestion_offre_stage.Service.RhService;
import org.amjad.pg_gestion_offre_stage.Service.ServiceStagiaire;
import org.amjad.pg_gestion_offre_stage.Service.EncadrantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/rh")
@CrossOrigin(origins = "http://localhost:3000")
public class RhController {

    @Autowired
    private  RhService rhService;
    @Autowired
    private DemandeService demandeService;
    @Autowired
    private EncadrantService encadrantService;
    @Autowired
    private ServiceStagiaire serviceStagiaire;


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

    @GetMapping("/stagiaires")
    public List<StagiaireDTO> getStagiaires() {
        List<Stagiaire> stagiaires = serviceStagiaire.getAllStagiaire();
        return stagiaires.stream().map(StagiaireDTO::new).collect(Collectors.toList());
    }

    @GetMapping("/encadrants")
    public List<EncadrantDTO> getEncadrants() {
        List<Encadrant> encadrants = encadrantService.getAllEncadrants();
        return encadrants.stream().map(EncadrantDTO::new).collect(Collectors.toList());
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

    @PutMapping("/assignEncadrant")
    public ResponseEntity<String> assignEncadrant(@RequestParam("stagiaireId") Long stagiaireId, @RequestParam("encadrantId") Long encadrantId) {
        try {
            Stagiaire stagiaire = serviceStagiaire.getStagiaireById(stagiaireId);
            Encadrant encadrant = encadrantService.getEncadrantById(encadrantId);
            stagiaire.setEncadrant(encadrant);
            serviceStagiaire.updateStagiaire(stagiaireId, stagiaire);
            return ResponseEntity.ok("Encadrant with id " + encadrantId + " has been assigned to Stagiaire with id " + stagiaireId);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error assigning encadrant: " + e.getMessage());
        }
    }
}
