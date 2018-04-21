package com.jarry.jchat.ui.login;

import android.content.Intent;
import android.util.Log;

import com.elvishew.xlog.XLog;
import com.jarry.jchat.R;
import com.jarry.jchat.base.BasePresenter;
import com.jarry.jchat.model.ResponseInfo;
import com.jarry.jchat.model.UserInfo;
import com.jarry.jchat.ui.NavigationDrawerActivity;
import com.jarry.jchat.utils.SpUtils;
import com.jarry.jchat.utils.net.ApiService;
import com.jarry.jchat.utils.net.RetrofitHelper;

import java.io.IOException;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
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
        //获取model
        new LoginModel().login(loginName, password, new Observer<ResponseInfo<UserInfo>>() {
            @Override
            public void onSubscribe(Disposable d) {
                XLog.d("====onSubscribe=====");
            }

            @Override
            public void onNext(ResponseInfo<UserInfo> responseInfo) {
                XLog.d("====onNext=====");
                if (responseInfo == null) {
                    getView().showToast(getView().getContext().getString(R.string.error_server));
                    return;
                }
                if (responseInfo.isSuccess()) {
                    //登录成功跳转页面
                    UserInfo userInfo = responseInfo.getData();
                    if (userInfo != null) {//保存到sp中
                        SpUtils.saveString(getView().getContext(), "userInfo", SpUtils.obj2String(userInfo));
                        Intent intent = new Intent(getView().getContext(), NavigationDrawerActivity.class);
                        getView().getContext().startActivity(intent);
                    } else {
                        getView().showToast(getView().getContext().getString(R.string.error_null));
                    }
                } else {
                    getView().showToast(responseInfo.getMsg());
                }
            }

            @Override
            public void onError(Throwable e) {
                XLog.d("====onError=====");

            }

            @Override
            public void onComplete() {
                XLog.d("====onComplete=====");
            }
        });


    }
}
