package com.example.tp2frontend.db;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.room.Room;

import java.util.List;

/**
 * Esta clase hace uso de las interfaz Dao e interactúa con la base de datos.
 *
 */
public class MyApp {
    @SuppressLint("StaticFieldLeak")
    private static MyApp sMyApp;

    private final AppDatabase mAppDatabase;

    private MyApp(Context context) {
        Context appContext = context.getApplicationContext();
        mAppDatabase = Room.databaseBuilder(appContext, AppDatabase.class, "mi-base-de-datos")
                .allowMainThreadQueries()
                .build();
    }

    public static MyApp get(Context context) {
        if (sMyApp == null) {
            sMyApp = new MyApp(context);
        }
        return sMyApp;
    }

    public List<Usuario> getUsuarios() {
        return mAppDatabase.getUsuarioDao().getUsuarios();
    }

    public Usuario getUsuario(int id) {
        return mAppDatabase.getUsuarioDao().getUsuarios().get(id);
    }

    public void insertarUsuario(Usuario usuario) {
        mAppDatabase.getUsuarioDao().insertUsuario(usuario);
    }

    public void updateUsuario(Usuario usuario) {
        mAppDatabase.getUsuarioDao().updateUsuario(usuario);
    }

    public void deleteUsuario(Usuario usuario) {
        mAppDatabase.getUsuarioDao().deleteUsuario(usuario);
    }
}
