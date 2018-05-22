package com.jarry.jchat.ui.user;

import com.jarry.jchat.base.BasePresenter;

/**
 * 接口完事再回来搞
 * Created by Jarry on 2018/3/25.
 */

public class UserInfoPresenter extends BasePresenter<UserInfoContract.View> implements UserInfoContract.Presenter {
    @Override
    public void loadData(String userId) {

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
//                    UserInfo userInfo = responseInfo.getData();
//                    if (userInfo != null) {//保存到sp中
//                        SpUtils.saveString(getView().getContext(), "userInfo", SpUtils.obj2String(userInfo));
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
