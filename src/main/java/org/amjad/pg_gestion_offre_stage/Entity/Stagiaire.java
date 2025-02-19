package org.amjad.pg_gestion_offre_stage.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.amjad.pg_gestion_offre_stage.Enum.Duree;
import org.amjad.pg_gestion_offre_stage.Enum.Status;

@Entity

public class Stagiaire extends User {
    private byte[] cv;
    private boolean validated;
    private Duree duree;
    private String CIN;
    private Status statut;
    private String sujet;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "encadrant_id")
    private Encadrant encadrant;

    public Stagiaire(){
        super();
        this.setRole(this.getClass().getSimpleName().toUpperCase());
    }

    public Status getStatut() {
        return statut;
    }

    public void setStatut(Status statut) {
        this.statut = statut;
    }

    public byte[] getCv() {
        return cv;
    }

    public void setCv(byte[] cv) {
        this.cv = cv;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    public Duree getDuree() {
        return duree;
    }

    public void setDuree(Duree duree) {
        this.duree = duree;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public Encadrant getEncadrant() {
        return encadrant;
    }

    public void setEncadrant(Encadrant encadrant) {
        this.encadrant = encadrant;
    }
}
