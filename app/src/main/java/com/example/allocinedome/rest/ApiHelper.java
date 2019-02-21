package com.example.allocinedome.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiHelper {
    private NewsApi newsApi;

    public NewsApi getNewsApi() { return newsApi; }

    private ApiHelper() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://etudiants.openium.fr/pam/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        newsApi = retrofit.create(NewsApi.class);
    }

    private static volatile ApiHelper instance;

    public static synchronized ApiHelper getInstance() {
        if (instance == null) {
            instance = new ApiHelper();
        }
        return instance;
    }

}
