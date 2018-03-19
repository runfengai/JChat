package com.jarry.jchat.utils;

import rx.Observable;
import retrofit2.Response;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Jarry on 2018/3/19.
 */

public interface NetUrl {
    String BASE_URL = "http://localhost:8088/";


    @POST("login")
    Observable<Response> login(@Query("userName") String userName, @Query("password") String password);

    @POST("register")
    Observable<Response> register(@Query("userName") String userName, @Query("password") String password);

}
