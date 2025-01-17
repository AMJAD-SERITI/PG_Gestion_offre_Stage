package org.amjad.pg_gestion_offre_stage.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import org.amjad.pg_gestion_offre_stage.Enum.Duree;


@Entity
@Table(name = "condidats")
@AllArgsConstructor
public class Condidat extends User {

    private byte[] cv;
    private boolean validated;
    private Duree duree;
    private String CIN;
    private String description;
    @ManyToOne
    @JoinColumn(name = "encadrant_id")
    private Encadrant encadrant;

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

    public Encadrant getEncadrant() {
        return encadrant;
    }

    public void setEncadrant(Encadrant encadrant) {
        this.encadrant = encadrant;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Condidat(){
        super();
        this.setRole(this.getClass().getSimpleName().toUpperCase());
    }

}
