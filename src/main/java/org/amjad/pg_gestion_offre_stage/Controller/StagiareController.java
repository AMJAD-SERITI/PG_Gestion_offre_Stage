package org.amjad.pg_gestion_offre_stage.Controller;

import org.amjad.pg_gestion_offre_stage.DTO.StagiaireEncadrantDTO;
import org.amjad.pg_gestion_offre_stage.Entity.Stagiaire;
import org.amjad.pg_gestion_offre_stage.Service.EncadrantService;
import org.amjad.pg_gestion_offre_stage.Service.ServiceStagiaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stagiaire")
public class StagiareController {

    @Autowired
    private ServiceStagiaire stagiareService;

    @Autowired
    private EncadrantService encadrantService;

    @GetMapping("/consulterEncadrant")
    public StagiaireEncadrantDTO consulterEncadrant() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated() || authentication.getName().equals("anonymousUser")) {
            throw new IllegalStateException("User is not authenticated");
        }

        String email = authentication.getName();
        return stagiareService.getStagiaireAndEncadrentString(email);
    }
}
