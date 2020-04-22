package com.modori.smartclassna.Retrofit;



import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface INodeJS {

    //public static String email, pw, name, area, school, subject, detailsubject, permission;

    @POST("register")
    @FormUrlEncoded
    Observable<String> registerUser(@Field("email") String email,
                                    @Field("pw") String pw,
                                    @Field("name") String name,
                                    @Field("area") String area,
                                    @Field("school") String school,
                                    @Field("subject") String subject,
                                    @Field("detailsubject") String detailsubject,
                                    @Field("permission") String permission);

    @POST("login")
    @FormUrlEncoded
    Observable<String> loginUser(@Field("email") String email,
                                 @Field("pw") String pw);

    @POST("jwtoken")
    @FormUrlEncoded
    Observable<String> transformJWT(@Field("token") String token);


}