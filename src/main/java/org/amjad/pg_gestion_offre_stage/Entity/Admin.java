package org.amjad.pg_gestion_offre_stage.Entity;



import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "admins")
public class Admin extends User {
    
    public Admin(){
        super();
        this.setRole(this.getClass().getSimpleName().toUpperCase());
    }
}
