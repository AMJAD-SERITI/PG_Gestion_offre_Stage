package org.amjad.pg_gestion_offre_stage.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import java.util.List;

@Entity
@Table(name = "encadrants")
@AllArgsConstructor
public class Encadrant extends User {

    private boolean validated;

    @OneToMany
    @JoinColumn(name = "encadrant_id")
    private List<Stagiaire> stagiaires;

    public List<Stagiaire> getStagiaires() {
        return stagiaires;
    }

    public void setStagiaires(List<Stagiaire> stagiaires) {
        this.stagiaires = stagiaires;
    }

    public Encadrant(){
        super();
        this.setRole(this.getClass().getSimpleName().toUpperCase());
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }
}
