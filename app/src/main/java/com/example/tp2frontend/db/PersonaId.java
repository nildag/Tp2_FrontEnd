package com.example.tp2frontend.db;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class PersonaId {

    @PrimaryKey
    private Integer idPersona;

    // Constructor vacío necesario para Room
    public PersonaId() {}

    // Constructor con parámetros para facilitar la creación de instancias
    public PersonaId(Integer idPersona) {
        this.idPersona = idPersona;
    }

    // Getters y setters aquí...

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }
}

