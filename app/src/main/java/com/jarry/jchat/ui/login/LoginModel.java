package com.jarry.jchat.ui.login;

import com.jarry.jchat.model.ResponseInfo;
import com.jarry.jchat.model.UserInfo;
import com.jarry.jchat.utils.net.ApiService;
import com.jarry.jchat.utils.net.RetrofitHelper;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Jarry on 2018/4/22.
 */

public class LoginModel implements LoginContract.Model {

    @Override
    public void login(String loginName, String password, Observer<ResponseInfo<UserInfo>> observer) {
        ApiService apiService = RetrofitHelper.getInstance().create();
        apiService.login(loginName, password)
                .subscribeOn(Schedulers.newThread()) // 子线程访问网络
                .observeOn(AndroidSchedulers.mainThread()) // 回调到主线程
                .subscribe(observer);
    }
}
