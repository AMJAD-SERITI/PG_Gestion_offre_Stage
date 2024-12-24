package org.amjad.pg_gestion_offre_stage.Controller;

import org.amjad.pg_gestion_offre_stage.Service.CondidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/condidat")
public class CondidatController {

    @Autowired
    private CondidatService condidatService;

    @PostMapping("/validate")
    public ResponseEntity<String> validateCondidat(Long id) {
        condidatService.validateCondidat(id);
        return ResponseEntity.ok("Condidat with id " + id + " has been validated");
    }
}
