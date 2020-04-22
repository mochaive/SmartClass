package com.modori.smartclassna.Api;

import com.modori.smartclassna.model.ProjectModel;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MyProjectApi {
    @GET("history/myproject/{email}/")
    public Call<ProjectModel> getMyProjectLists(@Path("email") String userEmail);
}
