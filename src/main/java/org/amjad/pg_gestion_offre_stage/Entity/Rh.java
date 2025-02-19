package org.amjad.pg_gestion_offre_stage.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@Table(name = "rhs")
public class Rh extends User  {
    private boolean validated;

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    public Rh(){
        super();
        this.setRole(this.getClass().getSimpleName().toUpperCase());
    }
}
