package com.example.fuckmylife.http;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class retrofitUtil {
    public static Service get(){
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .baseUrl("https://api.github.com/")
                .build();
        Service service = retrofit.create(Service.class);
        return service;
    }
}
