package com.example.tp2frontend.api;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface ReservaService {
    @Headers({
            "Accept: application/json"
    })
    @GET("stock-nutrinatalia/reserva?")
    Call<DatosReserva> obtenerReservasFiltro(@Query(value = "ejemplo" ,encoded = true) String address);


    @Headers({
            "Accept: application/json",
            "Authorization: Bearer d21472b7bdb23496d183a270e9a3516ce03fd7bf26f4e05e6efa94e105d1abc5"
    })
    @POST("users/")
    Call<DatosReserva> agregarReserva(@Body Reserva reserva);


    @Headers({
            "Accept: application/json"
    })
    @GET("stock-nutrinatalia/persona?")
    Call<DatosPaciente> obtenerEmpleados(@Query(value = "ejemplo" ,encoded = true) String address);

}
