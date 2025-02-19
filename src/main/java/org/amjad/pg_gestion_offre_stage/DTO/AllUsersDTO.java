package org.amjad.pg_gestion_offre_stage.DTO;

import org.amjad.pg_gestion_offre_stage.Entity.Admin;
import org.amjad.pg_gestion_offre_stage.Entity.Condidat;
import org.amjad.pg_gestion_offre_stage.Entity.Encadrant;
import org.amjad.pg_gestion_offre_stage.Entity.Rh;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

import java.util.List;



public class AllUsersDTO {

    private List<Condidat> condidats;
    private List<Encadrant> encadrants;
    private List<Rh> rhs;

    public List<Condidat> getCondidats() {
        return condidats;
    }

    public void setCondidats(List<Condidat> condidats) {
        this.condidats = condidats;
    }

    public List<Encadrant> getEncadrants() {
        return encadrants;
    }

    public void setEncadrants(List<Encadrant> encadrants) {
        this.encadrants = encadrants;
    }

    public List<Rh> getRhs() {
        return rhs;
    }

    public void setRhs(List<Rh> rhs) {
        this.rhs = rhs;
    }
}
