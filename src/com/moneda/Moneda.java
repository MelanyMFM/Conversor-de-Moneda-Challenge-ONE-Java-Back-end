package com.moneda;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class Moneda {

    @SerializedName("base_code")
    String moneda;

    @SerializedName("conversion_rates")
    public JsonObject rates;

    public double rateConv;



    public void setRateConv(String monedaConvertir) {
        this.rateConv = rates.get(monedaConvertir).getAsDouble();
    }


    public double convertir(double cantidad){

        return cantidad * rateConv;
    }

    @Override
    public String toString() {
        return "Moneda{" +
                "rateConv=" + rateConv +
                ", moneda='" + moneda + '\'' +
                '}';
    }
}
