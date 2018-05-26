package com.jarry.jchat.utils.net;

import com.jarry.jchat.model.ResponseInfo;
import com.jarry.jchat.model.UserInfo;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by Jarry on 2018/3/19.
 */

public interface ApiService {
//        public static final String BASE_URL = "http://192.168.10.197:8088/";//local
    public static final String BASE_URL = "http://95.163.207.33:8088/";//net

    /**
     * 普通get请求
     *
     * @param url
     * @param map
     * @return
     */
    @GET("{url}")
    Observable<ResponseBody> get(@Path("url") String url, @QueryMap Map<String, String> map);

    /**
     * post请求
     *
     * @param url
     * @param map
     * @return
     */
    @POST("{url}")
    Observable<ResponseBody> post(@Path("url") String url, @QueryMap Map<String, String> map);


    /**
     * =============================================================================================
     *登录相关
     * ========================START================================================================
     */
    /**
     * @param userName
     * @param password
     * @return
     */
    @POST("/user/login")
    Observable<ResponseInfo<UserInfo>> login(@Query("phone") String userName, @Query("password") String password);

    @POST("/user/register")
    Observable<Response<ResponseBody>> register(@Query("userName") String userName, @Query("password") String password);

    /**
     * =============================================================================================
     * 登录相关
     * ========================END==================================================================
     */
    @POST("/user/info")
    Observable<ResponseInfo<UserInfo>> userInfo(@Query("userId") String userId);

}
