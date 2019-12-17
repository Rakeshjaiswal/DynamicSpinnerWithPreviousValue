package com.example.dynamicspinnerwithpreviousvalue.api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

public class Api_Client {
    public static String Basew_URl = "http://scoretest.in/amclasses/apiss/";
    private static Api api_;


    public static Api getInstance() {
        if (api_ == null) {
            OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .writeTimeout(60, TimeUnit.SECONDS)
                    .build();

            Retrofit retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(Basew_URl)
                    .client(okHttpClient)
                    .build();
            Api api_ = retrofit.create(Api.class);
            return api_;

        } else
            return api_;
    }

}


