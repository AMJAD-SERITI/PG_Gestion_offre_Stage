package org.amjad.pg_gestion_offre_stage.Entity;

import jakarta.persistence.*;



@Entity
@Table(name = "condidats")
public class Condidat extends User {
    public Condidat(){
        super();
        this.setRole(this.getClass().getSimpleName().toUpperCase());
    }

}
