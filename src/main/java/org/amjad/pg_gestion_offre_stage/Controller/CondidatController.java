package org.amjad.pg_gestion_offre_stage.Controller;

import org.amjad.pg_gestion_offre_stage.Entity.Condidat;
import org.amjad.pg_gestion_offre_stage.Service.CondidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/condidat")
public class CondidatController {

    @Autowired
    private CondidatService condidatService;

    @PostMapping("/register")
    public ResponseEntity<String> registerCondidat(@RequestBody Condidat condidat) {
        condidatService.registerCondidat(condidat);
        return ResponseEntity.ok("Condidat with id " + condidat.getId() + " has been registered");
    }
}