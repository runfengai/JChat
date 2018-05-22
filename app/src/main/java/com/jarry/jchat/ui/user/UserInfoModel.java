package com.jarry.jchat.ui.user;

import com.jarry.jchat.model.ResponseInfo;
import com.jarry.jchat.model.UserInfo;

import io.reactivex.Observer;

/**
 * Created by Jarry on 2018/5/22.
 */

public class UserInfoModel implements UserInfoContract.Model {
    @Override
    public void getData(String userId, Observer<ResponseInfo<UserInfo>> observer) {

    }
}
