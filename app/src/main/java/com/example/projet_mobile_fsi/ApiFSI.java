package com.example.projet_mobile_fsi;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiFSI {
    String BASE_URL = "https://olen-ort.fr/P2025/CABOTESN/Code/API/";
    @FormUrlEncoded
    @POST("Maxime.php")
    Call<Utilisateur> divin(
            @Field("login") String login,
            @Field("mdp") String mdp
    );

}
