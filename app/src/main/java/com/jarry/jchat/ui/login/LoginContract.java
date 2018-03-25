package com.jarry.jchat.ui.login;

import com.jarry.jchat.base.BaseView;
import com.jarry.jchat.model.UserInfo;

/**
 * 契约类
 * Created by Jarry on 2018/3/25.
 */

public class LoginContract {
    interface View extends BaseView {
        void loginSuccess(UserInfo userInfo);
    }

    interface Presenter {
        void attemptLogin(String loginName, String password);
    }
}
