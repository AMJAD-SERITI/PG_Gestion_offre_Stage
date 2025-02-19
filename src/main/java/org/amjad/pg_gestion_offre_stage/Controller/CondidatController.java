package org.amjad.pg_gestion_offre_stage.Controller;

import org.amjad.pg_gestion_offre_stage.Entity.Condidat;
import org.amjad.pg_gestion_offre_stage.Service.CondidatService;
import org.amjad.pg_gestion_offre_stage.Service.DemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/condidat")
public class CondidatController {

    @Autowired
    private CondidatService condidatService;

    @Autowired
    private DemandeService demandeService;

    @PostMapping("/register")
    public ResponseEntity<String> registerCondidat(@RequestBody Condidat condidat) {
        condidatService.registerCondidat(condidat);
        return ResponseEntity.ok("Condidat with id " + condidat.getId() + " has been registered");
    }

    @PostMapping("/demand")
    public ResponseEntity<String> makeDemand(
            @RequestParam("nom") String nom,
            @RequestParam("prenom") String prenom,
            @RequestParam("email") String email,
            @RequestParam("CIN") String cin,
            @RequestParam("cv") MultipartFile cv,
            @RequestParam("description") String description,
            @RequestParam("duree") String duree,
            @RequestParam(value = "etat", defaultValue = "enAttente") String etat) {

        if (nom == null || prenom == null || email == null || cin == null || cv == null || description == null || duree == null) {
            return ResponseEntity.badRequest().body("All fields are required");
        }

        try {
            demandeService.createDemande(nom, prenom, email, cin, cv, description, duree, etat);
            return ResponseEntity.ok("Demand for stage has been made successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing demand: " + e.getMessage());
        }
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

    @PutMapping("nonValiderDemande")
    public ResponseEntity<String> nonValiderDemande(@RequestParam("id") Long id) {
        try {
            demandeService.nonValiderDemande(id);
            return ResponseEntity.ok("Demande with id " + id + " has been invalidated");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error invalidating demand: " + e.getMessage());
        }
    }
}