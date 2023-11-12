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

    // Getters y setters aquí...

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getUsuarioLogin() {
        return usuarioLogin;
    }

    public void setUsuarioLogin(String usuarioLogin) {
        this.usuarioLogin = usuarioLogin;
    }
}
