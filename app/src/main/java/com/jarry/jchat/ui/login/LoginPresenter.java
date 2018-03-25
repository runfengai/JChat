package com.jarry.jchat.ui.login;

import com.jarry.jchat.base.BasePresenter;
import com.jarry.jchat.utils.net.ApiService;
import com.jarry.jchat.utils.net.RetrofitHelper;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

/**
 * Created by Jarry on 2018/3/25.
 */

public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {
    /**
     *
     */
    @Override
    public void attemptLogin(String loginName, String password) {
        ApiService apiService = RetrofitHelper.getInstance().create();
        apiService.login(loginName, password)
                .subscribeOn(Schedulers.newThread()) // 子线程访问网络
                .observeOn(AndroidSchedulers.mainThread()) // 回调到主线程
                .subscribe(new Observer<Response>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Response response) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
