package com.example.tp2frontend;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tp2frontend.api.AdapterReserva;
import com.example.tp2frontend.api.DatosReserva;
import com.example.tp2frontend.api.Reserva;
import com.example.tp2frontend.api.ReservaUtil;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ReservasActivity extends AppCompatActivity {
    private RecyclerView rvReservas;
    private AdapterReserva adapterReserva;
    private FloatingActionButton fabNuevaReserva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);
        rvReservas=findViewById(R.id.rvListadoReservas);
        fabNuevaReserva=findViewById(R.id.fabNuevaReserva);
        fabNuevaReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newReservaIntent=new Intent(ReservasActivity.this, NewReservaActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("user",getIntent().getExtras().getString("user"));
                newReservaIntent.putExtras(bundle);
                startActivity(newReservaIntent);
            }
        });
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        rvReservas.setLayoutManager(layoutManager);
        cargarReservas();
    }

    public void cargarReservas() {
        System.out.println("La consulta fue: " + getIntent().getExtras().getString("consulta"));
        Call<DatosReserva> callApi= ReservaUtil.getReservaService().obtenerReservasFiltro(Uri.encode(getIntent().getExtras().getString("consulta")));
        callApi.enqueue(new Callback<DatosReserva>() {
            @Override
            public void onResponse(Call<DatosReserva> call, Response<DatosReserva> response) {
                Reserva[] arrayReservas=response.body().getData();
                adapterReserva=new AdapterReserva(arrayReservas, new AdapterReserva.ItemClickListener() {
                    @Override
                    public void onItemClick(Reserva reserva) {
                        //ir a la pagina con los datos del paciente cargado y dos botones,
                        // uno modificar y otro eliminar (no se si para el caso de pacientes)
                        //showToast(reserva.getIdCliente().getNombre());

                        Intent modificarReservaIntent=new Intent(ReservasActivity.this, ModificarReservaActivity.class);
                        Bundle bundle=new Bundle();
                        bundle.putString("user",getIntent().getExtras().getString("user"));
                        bundle.putString("idReserva",reserva.getIdReserva().toString());
                        bundle.putString("cliente",reserva.getIdCliente().getNombre());
                        bundle.putString("empleado",reserva.getIdEmpleado().getNombre());
                        bundle.putString("fecha",reserva.getFechaCadena());
                        bundle.putString("horaInicio",reserva.getHoraInicioCadena());
                        bundle.putString("horaFin",reserva.getHoraFinCadena());
                        bundle.putString("observacion",reserva.getObservacion());
                        bundle.putString("asistio",reserva.getFlagAsistio());
                        bundle.putString("flagEstado",reserva.getFlagEstado());

                        modificarReservaIntent.putExtras(bundle);
                        startActivity(modificarReservaIntent);
                    }
                });
                rvReservas.setAdapter(adapterReserva);
            }

            @Override
            public void onFailure(Call<DatosReserva> call, Throwable t) {
                Log.e("s",t.toString());
            }
        });
    }

    private void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}