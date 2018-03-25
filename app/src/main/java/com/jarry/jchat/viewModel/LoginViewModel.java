package com.jarry.jchat.viewModel;

import android.databinding.ObservableField;

import com.elvishew.xlog.XLog;
import com.jarry.jchat.model.LoginVerify;

import rx.Subscriber;

/**
 * Created by Jarry on 2018/3/19.
 */

public class LoginViewModel {
    public ObservableField<Integer> contentViewVisibility;
    public ObservableField<String> exception;

    private Subscriber<LoginVerify> subscriber;

    public LoginViewModel() {
        initData();
        getMovies();
    }

    private void getMovies() {
        subscriber = new Subscriber<LoginVerify>() {
            @Override
            public void onCompleted() {
                XLog.d("====onCompleted====");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(LoginVerify loginVerify) {

            }
        };
    }

    private void initData() {


    }


}
