package com.example.tp2frontend;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tp2frontend.api.AdapterPaciente;
import com.example.tp2frontend.api.DatosPaciente;
import com.example.tp2frontend.api.Paciente;
import com.example.tp2frontend.api.PacienteUtil;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PacientesActivity extends AppCompatActivity {
    String value;
    private RecyclerView rvPacientes;
    private AdapterPaciente adapterPaciente;
    private FloatingActionButton fabNuevoPaciente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        value = Objects.requireNonNull(getIntent().getExtras()).getString("consulta");
        setContentView(R.layout.activity_paciente);
        rvPacientes=findViewById(R.id.rvListadoPacientes);
        fabNuevoPaciente=findViewById(R.id.fabNuevoPaciente);
        fabNuevoPaciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newPacienteIntent=new Intent(PacientesActivity.this, NewPacienteActivity.class);
                startActivity(newPacienteIntent);
            }
        });
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        rvPacientes.setLayoutManager(layoutManager);
        cargarPacientes();
    }
    public void invocarApi(View v) {
        Call<DatosPaciente> callApi= PacienteUtil.getPacienteService().obtenerPacientes();
        callApi.enqueue(new Callback<DatosPaciente>() {
            @Override
            public void onResponse(Call<DatosPaciente> call, Response<DatosPaciente> response) {
                Paciente[] arrayPacientes=response.body().getData();
                for (int i=0;i<arrayPacientes.length;i++) {
                    Log.e("s","paciente "+i+": "+arrayPacientes[i]);
                }
            }

            @Override
            public void onFailure(Call<DatosPaciente> call, Throwable t) {
                Log.e("s",t.toString());
            }
        });
    }

    public void cargarPacientes() {
        Call<DatosPaciente> callApi= PacienteUtil.getPacienteService().obtenerPacientesFiltro(value);
        callApi.enqueue(new Callback<DatosPaciente>() {
            @Override
            public void onResponse(Call<DatosPaciente> call, Response<DatosPaciente> response) {
                Paciente[] arrayPacientes=response.body().getData();
                adapterPaciente=new AdapterPaciente(arrayPacientes, new AdapterPaciente.ItemClickListener() {
                    @Override
                    public void onItemClick(Paciente paciente) {
                        //ir a la pagina con los datos del paciente cargado y dos botones,
                        // uno modificar y otro eliminar (no se si para el caso de pacientes)
                        showToast(paciente.getNombre());
                    }
                });
                rvPacientes.setAdapter(adapterPaciente);
            }

            @Override
            public void onFailure(Call<DatosPaciente> call, Throwable t) {
                Log.e("s",t.toString());
            }
        });
    }

    public void cargarPacientesDesdeBd(){

    }

    private void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}