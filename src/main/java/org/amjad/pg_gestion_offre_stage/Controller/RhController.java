package org.amjad.pg_gestion_offre_stage.Controller;

import org.amjad.pg_gestion_offre_stage.Entity.Condidat;
import org.amjad.pg_gestion_offre_stage.Entity.Encadrant;
import org.amjad.pg_gestion_offre_stage.Service.CondidatService;
import org.amjad.pg_gestion_offre_stage.Service.RhService;
import org.amjad.pg_gestion_offre_stage.Service.EncadrantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;



@RestController
@RequestMapping("/api/rh")
public class RhController {

    private final RhService rhService;
    private final CondidatService condidatService;
    private final EncadrantService encadrantService;

    
    public RhController(RhService rhService, CondidatService condidatService, EncadrantService encadrantService) {
        this.rhService = rhService;
        this.condidatService = condidatService;
        this.encadrantService = encadrantService;
    }

    @PostMapping("/validateCondidat/{id}")
    public ResponseEntity<String> validateCondidat(@PathVariable Long id) {
        condidatService.validateCondidat(id);
        return ResponseEntity.ok("Condidat with id " + id + " has been validated");
    }

    @PostMapping("/unvalidateCondidat/{id}")
    public ResponseEntity<String> unvalidateCondidat(@PathVariable Long id) {
        condidatService.unvalidateCondidat(id);
        return ResponseEntity.ok("Condidat with id " + id + " has been unvalidated");
    }

    @PostMapping("/addEncadrant")
    public String addEncadrent(@RequestBody Encadrant encadrant) {
        encadrantService.saveEncadrant(encadrant);
        return "Encadrant with id " + encadrant.getId() + " has been added";
    }

    @PostMapping("/validateEncadrant/{id}")
    public String validatedEncadrant(@PathVariable Long id) {
        encadrantService.validateEncadrant(id);
        return "Encadrant with id " + id + " has been validated";
    }

    @PostMapping("/unvalidateEncadrant/{id}")
    public String unvalidateEncadrent(@PathVariable Long id) {
        encadrantService.unvalidateEncadrant(id);
        return "Encadrant with id " + id + " has been unvalidated";
    }

    @GetMapping("/getCondidats")
    public List<Condidat> getCondidats() {
        return condidatService.getAllCondidat();
    }
}
