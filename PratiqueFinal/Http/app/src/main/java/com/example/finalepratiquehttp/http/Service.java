package com.example.finalepratiquehttp.http;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Service {
    @GET("/exam2022/motdepasse/{passe}")
    Call<String> getPw(@Path("passe") String passe);

}
