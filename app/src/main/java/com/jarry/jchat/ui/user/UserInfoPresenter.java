package com.jarry.jchat.ui.user;

import com.elvishew.xlog.XLog;
import com.jarry.jchat.R;
import com.jarry.jchat.base.BasePresenter;
import com.jarry.jchat.model.ResponseInfo;
import com.jarry.jchat.model.UserInfo;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Jarry on 2018/3/25.
 */

public class UserInfoPresenter extends BasePresenter<UserInfoContract.View> implements UserInfoContract.Presenter {

    public UserInfoPresenter() {
    }

    @Override
    public void loadData(String userId, final UserInfo userInfoModel) {
        new UserInfoModel().getData(userId, new Observer<ResponseInfo<UserInfo>>() {
            @Override
            public void onSubscribe(Disposable d) {
                XLog.d("====onSubscribe=====");
            }

            @Override
            public void onNext(ResponseInfo<UserInfo> userInfoResponseInfo) {
                XLog.d("====onNext=====");

                if (userInfoResponseInfo == null) {
                    getView().showToast(getView().getContext().getString(R.string.error_server));
                    return;
                }
                if (userInfoResponseInfo.isSuccess()) {
                    UserInfo userInfo = userInfoResponseInfo.getData();
                    if (userInfo != null) {
                        //开始渲染界面
                        userInfoModel.setAvatar(userInfo.getAvatar());
                        userInfoModel.setGender(userInfo.getGender());
                        XLog.d("userInfo.getUserName()----->" + userInfo.getUserName());
                        userInfoModel.setUserName(userInfo.getUserName());
                        userInfoModel.setPhone(userInfo.getPhone());
                        userInfoModel.setUserId(userInfo.getUserId());
                    }

                }
            }

            @Override
            public void onError(Throwable e) {
                getView().closeLoading();
                XLog.d("====onError=====", e);
                getView().showToast(getView().getContext().getString(R.string.error_server));
            }

            @Override
            public void onComplete() {
                getView().closeLoading();
            }
        });
    }

    @Override
    public void share(UserInfo userInfo) {

    }

    @Override
    public void shortcut(UserInfo userInfo) {

    }
    /**
     *
     */
//    @Override
//    public void attemptLogin(String loginName, String password) {
//        //获取model
//        new LoginModel().login(loginName, password, new Observer<ResponseInfo<UserInfo>>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//                XLog.d("====onSubscribe=====");
//            }
//
//            @Override
//            public void onNext(ResponseInfo<UserInfo> responseInfo) {
//                XLog.d("====onNext=====");
//                if (responseInfo == null) {
//                    getView().showToast(getView().getContext().getString(R.string.error_server));
//                    return;
//                }
//                if (responseInfo.isSuccess()) {
//                    //登录成功跳转页面
//                    UserInfo userInfoModel = responseInfo.getData();
//                    if (userInfoModel != null) {//保存到sp中
//                        SpUtils.saveString(getView().getContext(), "userInfoModel", SpUtils.obj2String(userInfoModel));
//                        Intent intent = new Intent(getView().getContext(), NavigationDrawerActivity.class);
//                        getView().getContext().startActivity(intent);
//                        ((Activity) getView().getContext()).finish();
//                        //事件通知
//                        EventBus.getDefault().post(new LoginSuccessEvent(LoginSuccessEvent.SUCCESS));
//
//                    } else {
//                        getView().showToast(getView().getContext().getString(R.string.error_null));
//                    }
//                } else {
//                    getView().showToast(responseInfo.getMsg());
//                }
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                XLog.d("====onError=====");
//
//            }
//
//            @Override
//            public void onComplete() {
//                XLog.d("====onComplete=====");
//            }
//        });
//
//
//    }

}
