package org.amjad.pg_gestion_offre_stage.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.amjad.pg_gestion_offre_stage.Enum.Duree;
import org.amjad.pg_gestion_offre_stage.Enum.Status;

@Entity
public class Stagiaire extends User {
    private byte[] cv;
    private boolean validated;
    private Duree duree;
    private String CIN;
    private Status status;
    @ManyToOne
    @JoinColumn(name = "encadrant_id")
    private Encadrant encadrant;

    public Encadrant getEncadrant() {
        return encadrant;
    }

    public void setEncadrant(Encadrant encadrant) {
        this.encadrant = encadrant;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
