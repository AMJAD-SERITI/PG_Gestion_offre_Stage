package org.amjad.pg_gestion_offre_stage.Controller;

import org.amjad.pg_gestion_offre_stage.Entity.Condidat;
import org.amjad.pg_gestion_offre_stage.Service.CondidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/condidat")
public class CondidatController {

    @Autowired
    private CondidatService condidatService;

    @PostMapping("/register")
    public ResponseEntity<String> registerCondidat(@RequestBody Condidat condidat) {
        condidatService.registerCondidat(condidat);
        return ResponseEntity.ok("Condidat with id " + " has been registered");
    }
}
