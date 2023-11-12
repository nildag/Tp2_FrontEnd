package com.example.tp2frontend.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ReservaDao {

    @Insert
    void insertarReserva(Reserva reserva);

    @Query("SELECT * FROM reserva WHERE fechaReserva BETWEEN :fechaDesde AND :fechaHasta " +
            "AND idMedico = :idMedico AND idPaciente = :idPaciente")
    List<Reserva> obtenerReservasFiltradas(String fechaDesde, String fechaHasta, Integer idMedico, Integer idPaciente);

    @Update
    void actualizarReserva(Reserva reserva);

    @Delete
    void eliminarReserva(Reserva reserva);
}