package com.moneda;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {

    String direccion;


    double cantidadConvertir;


    public Moneda moneda;

    public Conversor(String monedaActual, String monedaConvertir, double cantidadConvertir) throws IOException, InterruptedException {
        this.cantidadConvertir = cantidadConvertir;
        this.direccion = "https://v6.exchangerate-api.com/v6/3c20b51d3ce0d46d9622d8dc/latest/"+monedaActual;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        //System.out.println(response.body());


        String json = response.body();
        Gson gson = new Gson();


        this.moneda = gson.fromJson(json, Moneda.class);
        this.moneda.setRateConv(monedaConvertir);


    }


    public double convertir(){
        return moneda.convertir(cantidadConvertir);
    }
}
