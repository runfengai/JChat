package com.jarry.chatsdk.interfaces.impl;

import com.jarry.chatsdk.callbacks.LoginCallBack;
import com.jarry.chatsdk.interfaces.IUserInfo;
/**
 * Created by BJQT on 2017/11/9.
 * 用户 登录的一些操作
 */

public class UserInfoImpl implements IUserInfo {


    public UserInfoImpl() {
//        IntentFilter filter = new IntentFilter();
//        filter.addAction(Actions.ACTION_REGISTER);
//        filter.addAction(Actions.ACTION_LOGIN_SUCCESS);
//        filter.addAction(Actions.ACTION_LOGIN_ERROR);
//        LocalBroadcastManager.getInstance(JarryClient.getInstance().getContext()).registerReceiver(receiver, filter);
//
//        IntentFilter filter1 = new IntentFilter();
//        filter1.addAction(Actions.ACTION_CONNECTION_STATE_CHANGED);
//        LocalBroadcastManager.getInstance(JarryClient.getInstance().getContext()).registerReceiver(stateReceiver, filter1);
//
//        IntentFilter filter2 = new IntentFilter();
//        filter2.addAction(Actions.ACTION_GET_STATE);
//        LocalBroadcastManager.getInstance(JarryClient.getInstance().getContext()).registerReceiver(connectionStateListener, filter2);
    }

    @Override
    public int connect(String account, String domain, String sessionId, String addr, String app, LoginCallBack callback) {
        return 0;
    }
}
