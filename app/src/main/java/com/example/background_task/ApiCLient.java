package com.example.background_task;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiCLient {

    private static final String url = "https://gorest.co.in/public/v2/";

    private static Retrofit retrofit;


    public static ApiInterface getApi(){
        if(retrofit ==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(ApiInterface.class);
    }

}
