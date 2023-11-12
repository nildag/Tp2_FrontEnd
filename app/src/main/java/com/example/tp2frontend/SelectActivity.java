package com.example.tp2frontend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tp2frontend.ficha.FiltroFichaActivity;


public class SelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
    }

    public void btnEventoAdministracionPacientes(View v) {
            Intent principalIntent=new Intent(this, FiltroPacienteActivity.class);
            startActivity(principalIntent);
    }

    public void btnEventoReservaTurnos(View v) {
        Intent principalIntent=new Intent(this, FiltroReservaActivity.class);
        Bundle bundle=new Bundle();
        bundle.putString("user",getIntent().getExtras().getString("user"));
        principalIntent.putExtras(bundle);
        startActivity(principalIntent);
    }

    public void btnEventoFichaClinica(View v) {
        Intent principalIntent=new Intent(this, FiltroFichaActivity.class);
        Bundle bundle=new Bundle();
        bundle.putString("user",getIntent().getExtras().getString("user"));
        principalIntent.putExtras(bundle);
        startActivity(principalIntent);
    }
}