package com.example.allocinedome.rest;

import com.example.allocinedome.model.Cinema;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface NewsApi {
   // @GET("cine.json")
    @GET("https://etudiants.openium.fr/pam/cine.json")
    Call<Cinema> getFile();
}
