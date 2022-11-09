package com.example.demo_api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
//    public static Retrofit retrofit;
//    public static final String BASE_URL = "http://localhost:61421/COMP1424CW/";
//    public static Retrofit getRetrofitInstance(){
//        if(retrofit ==null){
//            retrofit = new Retrofit.Builder()
//                    .baseUrl("http://localhost:61421/COMP1424CW/")
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build();
//        }
//        return  retrofit;
//    }

    public static final String BASE_URL = "http://172.16.0.231:8085/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
