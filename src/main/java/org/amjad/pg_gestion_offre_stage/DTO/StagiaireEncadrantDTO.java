package org.amjad.pg_gestion_offre_stage.DTO;

import org.amjad.pg_gestion_offre_stage.Entity.Encadrant;
import org.amjad.pg_gestion_offre_stage.Entity.Stagiaire;

public class StagiaireEncadrantDTO {
    private Stagiaire stagiaire;
    private Encadrant encadrant;

    public StagiaireEncadrantDTO(Stagiaire stagiaire, Encadrant encadrant) {
        this.stagiaire = stagiaire;
        this.encadrant = encadrant;
    }

    public Stagiaire getStagiaire() {
        return stagiaire;
    }

    public void setStagiaire(Stagiaire stagiaire) {
        this.stagiaire = stagiaire;
    }

    public Encadrant getEncadrant() {
        return encadrant;
    }

    public void setEncadrant(Encadrant encadrant) {
        this.encadrant = encadrant;
    }
}