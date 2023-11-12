package com.example.tp2frontend.db;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

public class Reserva {
    @PrimaryKey
    private Integer idReserva;

    @ColumnInfo(name = "fechaCadena")
    private String fechaCadena;

    @ColumnInfo(name = "horaInicioCadena")
    private String horaInicioCadena;

    @ColumnInfo(name = "horaFinCadena")
    private String horaFinCadena;

    @ColumnInfo(name = "idEmpleado")//@ForeignKey()(?
    private com.example.tp2frontend.db.Persona idEmpleado;

    @ColumnInfo(name = "idCliente")
    private Persona idCliente;

    @ColumnInfo(name = "flagAsistio")
    private String flagAsistio;

    @ColumnInfo(name = "observacion")
    private String observacion;

    @ColumnInfo(name = "flagEstado")
    private String flagEstado;


}
