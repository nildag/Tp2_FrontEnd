package com.example.tp2frontend.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Paciente {
    @PrimaryKey
    public int idPersona;
    @ColumnInfo(name = "nombre")
    public String nombre;
    @ColumnInfo(name = "apellido")
    public String apellido;
    @ColumnInfo(name = "telefono")
    public String telefono;
    @ColumnInfo(name = "email")
    public String email;
    @ColumnInfo(name = "ruc")
    public String ruc;
    @ColumnInfo(name = "cedula")
    public String cedula;
    @ColumnInfo(name = "tipoPersona")
    public String tipoPersona;
    @ColumnInfo(name = "fechaNacimiento")
    public String fechaNacimiento;
    @ColumnInfo(name = "usuarioLogin")
    public String usuarioLogin;
}
