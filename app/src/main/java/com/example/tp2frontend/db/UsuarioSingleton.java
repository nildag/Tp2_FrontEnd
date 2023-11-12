package com.example.tp2frontend.db;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.room.Room;

import java.util.List;

/**
 * Esta clase hace uso de la interfaz UsuarioDao e interactúa con la base de datos.
 *
 */
public class UsuarioSingleton {
    @SuppressLint("StaticFieldLeak")
    private static UsuarioSingleton sUsuarioSingleton;

    private final UsuarioSingleton mUsuarioSingleton;

    private UsuarioSingleton(Context context){
        Context appContext = context.getApplicationContext();
        TpDatabase database = Room.databaseBuilder(appContext, TpDatabase.class,"usuario")
                .allowMainThreadQueries().build();
        mUsuarioSingleton = (UsuarioSingleton) database.getUsuarioDao();
    }
    public static UsuarioSingleton get(Context context){
        if(sUsuarioSingleton == null){
            sUsuarioSingleton = new UsuarioSingleton(context);
        }
        return sUsuarioSingleton;
    }

    public List<Usuario> getUsuarios(){
        return mUsuarioSingleton.getUsuarios();
    }
    public Usuario getUsuario(String id){
        return mUsuarioSingleton.getUsuario(id);
    }
    public void insertarUsuario(Usuario usuario){
        mUsuarioSingleton.insertarUsuario(usuario);
    }
    public void updateUsuario(Usuario usuario){
        mUsuarioSingleton.updateUsuario(usuario);
    }
    public void deleteUsuario(Usuario usuario){
        mUsuarioSingleton.deleteUsuario(usuario);
    }

}
