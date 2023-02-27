package com.example.myapplication.http;
import retrofit2.Retrofit;
public class RetrofitUtil {
    public static Service get(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .build();
        Service service = retrofit.create(Service.class);
        return service;
    }
}
