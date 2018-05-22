package com.jarry.jchat.ui.user;

import com.jarry.jchat.base.BaseModel;
import com.jarry.jchat.base.BasePresenter;
import com.jarry.jchat.base.BaseView;
import com.jarry.jchat.model.ResponseInfo;
import com.jarry.jchat.model.UserInfo;

import io.reactivex.Observer;

/**
 * Created by Jarry on 2018/5/22.
 */

public class UserInfoContract {
    interface View extends BaseView {

    }

    interface Model extends BaseModel {
        void getData(String userId, Observer<ResponseInfo<UserInfo>> observer);
    }

    interface Presenter {
        //
        void loadData(String userId);

    }
}
