package com.modori.smartclassna.Api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

import com.modori.smartclassna.model.WordCloud;

public class ApiClient {

    private static final String BASE_URL = "http://cachi.ga/";
    private static final String BASE_URL2 = "http://10.0.100.28:3000/";

    public static cloudApi getCloud() {
        return RetrofitAPI.getRetrofit(BASE_URL).create(cloudApi.class);
    }

    public static MyProjectApi getMyProjectLists() {
        return RetrofitAPI.getRetrofit(BASE_URL2).create(MyProjectApi.class);
    }


}

