package com.example.tp2frontend.db;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Insert;
import androidx.room.Update;
import androidx.room.Delete;

import java.util.List;

@Dao
public interface PacienteDao {
    @Query("SELECT * FROM paciente")
    List<Paciente> getAll();
    @Query("SELECT * FROM pacient WHERE id IN  (:pacienteIds)")
    List<Paciente> loadAllByIds(int[] pacienteIds);
    @Insert
    void insertPaciente(Paciente paciente);
    @Update
    void updatePaciente(Paciente paciente);
    @Delete
    void deletePaciente(Paciente paciente);
}
