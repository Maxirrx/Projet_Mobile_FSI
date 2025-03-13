package com.example.projet_mobile_fsi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroFitClientUtilisateur {
    private static RetroFitClientUtilisateur instance = null;
    private ApiFSI myApi;
    private RetroFitClientUtilisateur(){

        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiFSI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApi = retrofit.create(ApiFSI.class);
    }

    public static RetroFitClientUtilisateur getInstance(){
        if (instance == null){
            instance = new RetroFitClientUtilisateur();
        }
        return instance;
    }
    public ApiFSI getMyApi(){
        return myApi;
    }

}
