package com.jarry.jchat.ui.login;

import com.jarry.chatsdk.XmppConn;
import com.jarry.chatsdk.interfaces.ConnectCallBack;
import com.jarry.jchat.model.ResponseInfo;
import com.jarry.jchat.model.UserInfo;
import com.jarry.jchat.utils.net.ApiService;
import com.jarry.jchat.utils.net.RetrofitHelper;

import java.util.concurrent.Executors;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.internal.operators.observable.ObservableCreate;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Jarry on 2018/4/22.
 */

public class LoginModel implements LoginContract.Model {

    /**
     * 2步操作，1校验用户，2连接openfire
     *
     * @param loginName
     * @param password
     * @param observer
     */
    @Override
    public void login(String loginName, String password, Observer<ResponseInfo<UserInfo>> observer) {
        //校验用户
//        ApiService apiService = RetrofitHelper.getInstance().create();
//        apiService.login(loginName, password)
//                .subscribeOn(Schedulers.newThread()) // 子线程访问网络
//                .observeOn(AndroidSchedulers.mainThread()) // 回调到主线程
//                .subscribe(observer);

    }

    @Override
    public void connect(String loginName, String password, ConnectCallBack connectCallBack) {
        Executors.newScheduledThreadPool(4).execute(() -> {
            //连接
            XmppConn xmppConn = XmppConn.getInstance();
            xmppConn.connect(loginName, password, connectCallBack);
        });
    }

}
