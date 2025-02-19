package org.amjad.pg_gestion_offre_stage.Enum;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Status {
    EN_COUR("EnCour"),
    ANNULER("Annuler"),
    TERMINER("Terminer");

    private final String value;

    Status(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static Status fromValue(String value) {
        for (Status status : Status.values()) {
            if (status.value.equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown enum value: " + value);
    }
}