package org.amjad.pg_gestion_offre_stage.Controller;

import org.amjad.pg_gestion_offre_stage.Entity.Admin;
import org.amjad.pg_gestion_offre_stage.Entity.Encadrant;
import org.amjad.pg_gestion_offre_stage.Entity.Rh;
import org.amjad.pg_gestion_offre_stage.Entity.Stagiaire;
import org.amjad.pg_gestion_offre_stage.Service.AdminService;
import org.amjad.pg_gestion_offre_stage.Service.EncadrantService;
import org.amjad.pg_gestion_offre_stage.Service.RhService;
import org.amjad.pg_gestion_offre_stage.Service.ServiceStagiaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {

    @Autowired
    private ServiceStagiaire serviceStagiaire;
    @Autowired
    private AdminService adminService;
    @Autowired
    private EncadrantService encadrantService;
    @Autowired
    private RhService rhService;

    @PostMapping("/register")
    public ResponseEntity<String> registerAdmin(@RequestBody Admin admin) {
        adminService.registerAdmin(admin);
        return ResponseEntity.ok("Admin created successfully");
    }

    @PostMapping("/add/{role}")
    public ResponseEntity<String> addUser(@PathVariable String role, @RequestParam String email, @RequestParam String password) {
        switch (role.toUpperCase()) {
            case "ENCADRANT":
                if (encadrantService.findByEmail(email).isPresent()) {
                    return ResponseEntity.badRequest().body("Email is already taken");
                }
                Encadrant encadrant = new Encadrant();
                encadrant.setEmail(email);
                encadrant.setPassword(password);
                encadrantService.saveEncadrant(encadrant);
                return ResponseEntity.ok("Encadrant created successfully");
            case "RH":
                if (rhService.findByEmail(email).isPresent()) {
                    return ResponseEntity.badRequest().body("Email is already taken");
                }
                Rh rh = new Rh();
                rh.setEmail(email);
                rh.setPassword(password);
                rhService.saveRh(rh);
                return ResponseEntity.ok("RH created successfully");
            case "STAGIAIRE":
                if (serviceStagiaire.findByEmail(email).isPresent()) {
                    return ResponseEntity.badRequest().body("Email is already taken");
                }
                Stagiaire stagiaire = new Stagiaire();
                stagiaire.setEmail(email);
                stagiaire.setPassword(password);
                serviceStagiaire.addStagiaire(stagiaire);
                return ResponseEntity.ok("Stagiaire created successfully");
            default:
                return ResponseEntity.badRequest().body("Invalid role");
        }
    }

    // Fetch all stagiaire accounts
    @GetMapping("/stagiaires")
    public ResponseEntity<List<Stagiaire>> getAllStagiaires() {
        List<Stagiaire> stagiaires = serviceStagiaire.getAllStagiaire();
        return ResponseEntity.ok(stagiaires);
    }

    // Update stagiaire account
    @PutMapping("/stagiaires/{id}")
    public ResponseEntity<Stagiaire> updateStagiaire(@PathVariable Long id, @RequestBody Stagiaire updatedStagiaire) {
        Stagiaire stagiaire = serviceStagiaire.updateStagiaire(id, updatedStagiaire);
        return ResponseEntity.ok(stagiaire);
    }

    // Delete stagiaire account
    @DeleteMapping("/stagiaires/{id}")
    public ResponseEntity<Void> deleteStagiaire(@PathVariable Long id) {
        serviceStagiaire.deleteStagiaire(id);
        return ResponseEntity.noContent().build();
    }

    // Change status of stagiaire account
    @PutMapping("/stagiaires/{id}/status")
    public ResponseEntity<Stagiaire> changeStagiaireStatus(@PathVariable Long id, @RequestBody Stagiaire updatedStagiaire) {
        Stagiaire stagiaire = serviceStagiaire.changeStagiaireStatus(id, updatedStagiaire);
        return ResponseEntity.ok(stagiaire);
    }

    // Fetch all encadrant accounts
    @GetMapping("/encadrants")
    public ResponseEntity<List<Encadrant>> getAllEncadrants() {
        List<Encadrant> encadrants = encadrantService.getAllEncadrants();
        return ResponseEntity.ok(encadrants);
    }

    // Update encadrant account
    @PutMapping("/encadrants/{id}")
    public ResponseEntity<Encadrant> updateEncadrant(@PathVariable Long id, @RequestBody Encadrant updatedEncadrant) {
        Encadrant encadrant = encadrantService.updateEncadrant(id, updatedEncadrant);
        return ResponseEntity.ok(encadrant);
    }

    // Delete encadrant account
    @DeleteMapping("/encadrants/{id}")
    public ResponseEntity<Void> deleteEncadrant(@PathVariable Long id) {
        encadrantService.deleteEncadrant(id);
        return ResponseEntity.noContent().build();
    }

    // Fetch all RH accounts
    @GetMapping("/rhs")
    public ResponseEntity<List<Rh>> getAllRhs() {
        List<Rh> rhs = rhService.getAllRhs();
        return ResponseEntity.ok(rhs);
    }

    // Update RH account
    @PutMapping("/rhs/{id}")
    public ResponseEntity<Rh> updateRh(@PathVariable Long id, @RequestBody Rh updatedRh) {
        Rh rh = rhService.updateRh(id, updatedRh);
        return ResponseEntity.ok(rh);
    }

    // Delete RH account
    @DeleteMapping("/rhs/{id}")
    public ResponseEntity<Void> deleteRh(@PathVariable Long id) {
        rhService.deleteRh(id);
        return ResponseEntity.noContent().build();
    }
}