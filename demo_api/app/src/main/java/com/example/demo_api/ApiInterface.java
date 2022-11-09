package com.example.demo_api;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {
    @Headers({
            "Connection: close"
    })
    @FormUrlEncoded
    @POST("COMP1424CW")
    Call<Cloud> getUserInformation(@Field("jsonpayload") String value);

    @GET("weatherforecast")
    Call<Cloud> test();
}
