package com.jarry.jchat.ui.login;

import com.jarry.chatsdk.interfaces.ConnectCallBack;
import com.jarry.jchat.base.BaseModel;
import com.jarry.jchat.base.BaseView;
import com.jarry.jchat.model.ResponseInfo;
import com.jarry.jchat.model.UserInfo;

import io.reactivex.Observer;

/**
 * 契约类
 * Created by Jarry on 2018/3/25.
 */

public class LoginContract {
    interface View extends BaseView {
        void loginSuccess(UserInfo userInfo);
    }

    interface Model extends BaseModel {
        void login(String loginName, String password, Observer<ResponseInfo<UserInfo>> observer);

        void connect(String loginName, String password, ConnectCallBack connectCallBack);
    }

    interface Presenter {
        void attemptLogin(String loginName, String password);
    }
}
