package com.example.tp2frontend.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PersonaDao {
    @Insert
    void insert(Persona persona);

    @Update
    void update(Persona persona);

    @Query("SELECT * FROM Persona")
    List<Persona> getPersonas();

    @Query("SELECT * FROM Persona WHERE idPersona = :personaId")
    Persona getPersonaById(int personaId);

    @Query("DELETE FROM Persona WHERE idPersona = :personaId")
    void deletePersonaById(int personaId);
}
