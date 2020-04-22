package com.modori.smartclassna.Api;

import com.modori.smartclassna.model.ProjectModel;
import com.modori.smartclassna.model.WordCloud;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface cloudApi {

    @POST("cloud/")
    @FormUrlEncoded
    public Call<WordCloud> getCloud(@Field("title") String title,
                                    @Field("text") String content

    );


}
