package org.amjad.pg_gestion_offre_stage.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;



@Entity
@Table(name = "condidats")
@AllArgsConstructor
public class Condidat extends User {

    private byte[] cv;
    private boolean validated;
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

    public Condidat(){
        super();
        this.setRole(this.getClass().getSimpleName().toUpperCase());
    }

}
