package com.jarry.jchat.ui.login;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import com.elvishew.xlog.XLog;
import com.jarry.chatsdk.interfaces.ConnectCallBack;
import com.jarry.jchat.R;
import com.jarry.jchat.base.BasePresenter;
import com.jarry.jchat.interfaces.LoginSuccessEvent;
import com.jarry.jchat.model.ResponseInfo;
import com.jarry.jchat.model.UserInfo;
import com.jarry.jchat.ui.NavigationDrawerActivity;
import com.jarry.jchat.utils.SpUtils;
import com.jarry.jchat.utils.net.ApiService;
import com.jarry.jchat.utils.net.RetrofitHelper;

import org.greenrobot.eventbus.EventBus;

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
    UserInfo userInfo;

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
                    //尝试连接openfire服务
                    //登录成功跳转页面
                    userInfo = responseInfo.getData();
                    if (userInfo != null) {//保存到sp中
                        SpUtils.saveString(getView().getContext(), "userInfo", SpUtils.obj2String(userInfo));
                        conn(loginName, password);
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

    private void conn(String loginName, String password) {
        new LoginModel().connect(loginName, password, new ConnectCallBack() {
            @Override
            public void onSuccess() {
                XLog.d("=====onSuccess=====");
                ((Activity) getView().getContext()).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(getView().getContext(), NavigationDrawerActivity.class);
                        getView().getContext().startActivity(intent);
                        ((Activity) getView().getContext()).finish();
                        //事件通知
                        EventBus.getDefault().post(new LoginSuccessEvent(LoginSuccessEvent.SUCCESS));
                    }
                });

            }

            @Override
            public void onFail(int errorCode, String errorStr) {
                XLog.d("=====errorCode=====" + errorCode + " errorStr=" + errorStr);
                ((Activity) getView().getContext()).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        getView().showToast("连接异常：" + errorStr);
                    }
                });

            }
        });
    }
}
