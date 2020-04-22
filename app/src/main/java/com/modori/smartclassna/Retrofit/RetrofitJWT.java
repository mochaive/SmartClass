package com.modori.smartclassna.Retrofit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitJWT {


    private static Retrofit instanceJWT;

    //Jwt
    public static Retrofit getInstanceJWT() {
        if (instanceJWT == null)
            instanceJWT = new Retrofit.Builder()
                    .baseUrl("http://10.0.100.28:3000/")
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        return instanceJWT;
    }
}