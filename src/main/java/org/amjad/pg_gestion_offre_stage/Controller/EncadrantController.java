package org.amjad.pg_gestion_offre_stage.Controller;

import java.util.List;

import org.amjad.pg_gestion_offre_stage.Entity.Condidat;
import org.amjad.pg_gestion_offre_stage.Service.EncadrantService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/api/encadrant")
public class EncadrantController {


    private final EncadrantService encadrantService;

    public EncadrantController(EncadrantService encadrantService) {
        this.encadrantService = encadrantService;
    }

    @GetMapping("/getCondidats/{id}")
    public List<Condidat> getCondidats(@PathVariable Long id) {
        return encadrantService.getCondidats(id);
    }
    
}
