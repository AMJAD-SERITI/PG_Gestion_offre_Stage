package org.amjad.pg_gestion_offre_stage.Enum;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Duree {
    TROIS_MOIS("TroisMois"),
    UNE_MOIS("UneMois"),
    SIX_MOIS("SixMois");

    private final String value;

    Duree(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static Duree fromValue(String value) {
        for (Duree duree : Duree.values()) {
            if (duree.value.equalsIgnoreCase(value)) {
                return duree;
            }
        }
        throw new IllegalArgumentException("Unknown enum value: " + value);
    }
}
