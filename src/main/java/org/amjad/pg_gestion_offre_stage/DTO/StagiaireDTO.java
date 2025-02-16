package org.amjad.pg_gestion_offre_stage.DTO;

import org.amjad.pg_gestion_offre_stage.Entity.Stagiaire;
import org.amjad.pg_gestion_offre_stage.Enum.Status;

public class StagiaireDTO extends UserDTO {
    private String sujet;
    private Status statut;

    public StagiaireDTO() {
        super();
    }

    public StagiaireDTO(Stagiaire stagiaire) {
        super(stagiaire);
        this.sujet = stagiaire.getSujet();
        this.statut = stagiaire.getStatut();
    }

    // Getters and setters
    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public Status getStatut() {
        return statut;
    }

    public void setStatut(Status statut) {
        this.statut = statut;
    }
}