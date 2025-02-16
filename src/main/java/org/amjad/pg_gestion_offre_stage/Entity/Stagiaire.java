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
@Getter
@Setter
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
    

    public Status getStatut() {
        return statut;
    }

    public void setStatut(Status statut) {
        this.statut = statut;
    }
}
