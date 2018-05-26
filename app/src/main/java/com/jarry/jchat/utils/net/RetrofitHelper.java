package com.jarry.jchat.utils.net;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;


import org.reactivestreams.Subscriber;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 网络请求
 * Created by Jarry on 2018/3/25.
 */

public class RetrofitHelper {
    private static RetrofitHelper instance = new RetrofitHelper();
    private static Retrofit mRetrofit;
    private static final int DeFAULT_TIME = 10;//网络请求超时时间
    private final long RETRY_TIMES = 1;//重订阅次数

    private static ApiService apiService;

    private RetrofitHelper() {
    }

    public static RetrofitHelper getInstance() {
        if (mRetrofit == null) {
            synchronized (RetrofitHelper.class) {
                if (mRetrofit == null) {
                    OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
                    builder.readTimeout(DeFAULT_TIME, TimeUnit.SECONDS);
                    builder.connectTimeout(DeFAULT_TIME, TimeUnit.SECONDS);

                    //拦截器
                    builder.addInterceptor(new BaseInterceptor());
                    builder.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));

                    OkHttpClient okHttpClient = builder.build();
                    mRetrofit = new Retrofit.Builder()
                            .baseUrl(ApiService.BASE_URL)
                            .client(okHttpClient)

                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .build();

                }
            }
        }

        return instance;
    }

    public ApiService getApiService() {
        return apiService == null ? create() : apiService;
    }

    public ApiService create() {
        return apiService = mRetrofit.create(ApiService.class);
    }

    /**
     * get请求
     *
     * @param url
     * @param headers
     * @param parameters
     * @param observer
     */
    public void get(String url, Map headers, Map<String, String> parameters, Observer<ResponseBody> observer) {
        apiService.get(url, parameters)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    /**
     * post请求
     *
     * @param url
     * @param headers
     * @param parameters
     * @param observer
     */
    public void post(String url, Map headers, Map parameters, Observer<ResponseBody> observer) {
        apiService.post(url, parameters)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

}
