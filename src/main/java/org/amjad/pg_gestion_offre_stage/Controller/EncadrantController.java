package org.amjad.pg_gestion_offre_stage.Controller;

import java.util.List;

import org.amjad.pg_gestion_offre_stage.Entity.Condidat;
import org.amjad.pg_gestion_offre_stage.Entity.Stagiaire;
import org.amjad.pg_gestion_offre_stage.Service.EncadrantService;
import org.amjad.pg_gestion_offre_stage.Service.ServiceStagiaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/encadrant")
public class EncadrantController {

    @Autowired
    private  EncadrantService encadrantService;
    @Autowired
    private ServiceStagiaire serviceStagiaire;

    @GetMapping("/getCondidats/{id}")
    public List<Stagiaire> getCondidats(@PathVariable Long id) {
        return encadrantService.getStagiaire(id);
    }

    @PostMapping("/stagiaire/update/{id}")
    public void updateStagiaire(@PathVariable Long id, @RequestBody Stagiaire stagiaire) {
    serviceStagiaire.updateStagiaire(id, stagiaire);
    }
}
