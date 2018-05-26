package com.jarry.jchat.ui.user;

import com.jarry.jchat.model.ResponseInfo;
import com.jarry.jchat.model.UserInfo;
import com.jarry.jchat.utils.net.ApiService;
import com.jarry.jchat.utils.net.RetrofitHelper;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Jarry on 2018/5/22.
 */

public class UserInfoModel implements UserInfoContract.Model {
    @Override
    public void getData(String userId, Observer<ResponseInfo<UserInfo>> observer) {
        ApiService apiService = RetrofitHelper.getInstance().getApiService();
        apiService.userInfo(userId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
