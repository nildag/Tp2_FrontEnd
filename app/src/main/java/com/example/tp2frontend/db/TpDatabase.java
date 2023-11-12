package com.example.tp2frontend.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Usuario.class, Persona.class, Paciente.class, Reserva.class}, version = 1)
public abstract class TpDatabase extends RoomDatabase {
    public abstract UsuarioDao getUsuarioDao();
    public abstract PersonaDao getPersonaDao();
    public abstract PacienteDao getPacienteDao();
    public abstract ReservaDao getReservaDao();

}
