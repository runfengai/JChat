package com.jarry.jchat.utils;

import com.jarry.jchat.model.LoginVerify;

import java.util.concurrent.TimeUnit;

import rx.android.schedulers.AndroidSchedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 *
 */
public class RetrofitHelper {
    private static final int DEFAULT_TIMEOUT = 10;
    private Retrofit retrofit;
    private NetUrl netUrl;
    OkHttpClient.Builder builder;

    /**
     * 获取RetrofitHelper对象的单例
     */
    private static class Singleton {
        private static final RetrofitHelper INSTANCE = new RetrofitHelper();
    }

    public static RetrofitHelper getInstance() {
        return Singleton.INSTANCE;
    }

    private RetrofitHelper() {
        builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(netUrl.BASE_URL)
                .build();
        netUrl = retrofit.create(NetUrl.class);
    }

    public void login(Subscriber<LoginVerify> subscriber, String userName, String pwd) {
        netUrl.login(userName, pwd)
//                .map(new Func1<Response<List<LoginVerify>>, List<LoginVerify>>() {
//                    @Override
//                    public List<LoginVerify> call(Response<List<LoginVerify>> listResponse) {
//                        return listResponse.getSubjects();
//                    }
//                })
//                .flatMap(new Func1<List<LoginVerify>, Observable<LoginVerify>>() {
//                    @Override
//                    public Observable<LoginVerify> call(List<LoginVerify> movies) {
//                        return Observable.from(movies);
//                    }
//                })
                .subscribeOn(Schedulers.newThread())
                .subscribe(subscriber);

    }
//    public void getMovies(Subscriber<LoginVerify> subscriber, int start, int count) {
//        netUrl.getMovies(start, count)

//    }
}
