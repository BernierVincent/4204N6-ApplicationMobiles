package com.example.finalepratiquehttp.http;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class retrofitUtil {
    private static Service instance;

    public  static  Service get(){
        if(instance == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .baseUrl("https://4n6.azurewebsites.net")
                    .build();
            instance = retrofit.create(Service.class);
            return instance;
        }
        else {
            return  instance;
        }


    }
}
