package com.modori.smartclassna.Retrofit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitClient {

    private static Retrofit instanceAuth;

    //Register, Login
    public static Retrofit getInstanceAuth() {
        if (instanceAuth == null)
            instanceAuth = new Retrofit.Builder()
                    .baseUrl("http://10.0.100.28:3000/auth/")
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        return instanceAuth;
    }



}