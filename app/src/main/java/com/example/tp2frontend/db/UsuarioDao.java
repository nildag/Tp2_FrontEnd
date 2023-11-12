package com.example.tp2frontend.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UsuarioDao {
    @Query("SELECT * FROM usuario")
    List<Usuario> getUsuarios();
    @Query("SELECT * FROM usuario WHERE id IN  (:usuarioIds)")
    List<Usuario> loadAllByIds(int[] usuarioIds);
    @Insert
    void insertUsuario(Usuario usuario);
    @Update
    void updateUsuario(Usuario usuario);
    @Delete
    void deleteUsuario(Usuario usuario);
}
