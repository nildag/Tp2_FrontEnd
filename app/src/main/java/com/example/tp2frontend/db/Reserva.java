package com.example.tp2frontend.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "reserva")
public class Reserva {

    @PrimaryKey(autoGenerate = true)
    private Integer idReserva;

    @ColumnInfo(name = "fechaReserva")
    private String fechaReserva;

    @ColumnInfo(name = "horaReserva")
    private String horaReserva;

    @ColumnInfo(name = "idMedico")
    private Integer idMedico;

    @ColumnInfo(name = "idPaciente")
    private Integer idPaciente;

    @ColumnInfo(name = "estadoReserva")
    private String estadoReserva; // Podría ser "Activa", "Cancelada", etc.

    // Getters y setters aquí...

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getHoraReserva() {
        return horaReserva;
    }

    public void setHoraReserva(String horaReserva) {
        this.horaReserva = horaReserva;
    }

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(String estadoReserva) {
        this.estadoReserva = estadoReserva;
    }
}
