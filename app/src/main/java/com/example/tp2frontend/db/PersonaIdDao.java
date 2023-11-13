package com.example.tp2frontend.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Delete;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PersonaIdDao {

    @Insert
    void insertPersonaId(PersonaId personaId);

    @Query("SELECT * FROM personaid")
    List<PersonaId> getAllPersonaIds();

    @Query("SELECT * FROM personaid WHERE idPersona = :idPersona")
    PersonaId getPersonaIdById(Integer idPersona);

    @Delete
    void deletePersonaId(PersonaId personaId);

    @Update
    void updatePersonaId(PersonaId personaId);

}
