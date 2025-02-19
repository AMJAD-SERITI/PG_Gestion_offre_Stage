package org.amjad.pg_gestion_offre_stage.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.amjad.pg_gestion_offre_stage.Enum.Duree;
import org.amjad.pg_gestion_offre_stage.Enum.Etat;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Demande {
    @Id
    @GeneratedValue()
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    @Lob
    private String cv;
    private String description;
    private Duree duree;
    private String CIN;
    @Enumerated(EnumType.STRING)
    private Etat etat;
}
