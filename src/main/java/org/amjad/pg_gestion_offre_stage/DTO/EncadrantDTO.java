package org.amjad.pg_gestion_offre_stage.DTO;

import org.amjad.pg_gestion_offre_stage.Entity.Encadrant;

public class EncadrantDTO extends UserDTO{
    private Long id;
    private String email;

    public EncadrantDTO(Encadrant encadrant) {
        super(encadrant);
        this.id = encadrant.getId();
        this.email = encadrant.getEmail();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }
}
