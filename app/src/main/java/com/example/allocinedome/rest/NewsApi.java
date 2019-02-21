package com.example.allocinedome.rest;

import com.example.allocinedome.model.Cinema;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface NewsApi {
    @GET("cine.json")
    Call<Cinema> getFile();
}
