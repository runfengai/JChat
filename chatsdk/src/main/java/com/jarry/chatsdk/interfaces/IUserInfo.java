package com.jarry.chatsdk.interfaces;

import com.jarry.chatsdk.callbacks.LoginCallBack;

/**
 * @Author jarry
 * created at 2018/7/2 0:33
 */
public interface IUserInfo {
    /**
     * 接入域
     *
     * @param account   账号
     * @param domain    域名
     * @param sessionId sessionId
     * @param addr      服务器地址
     * @param app       资源名
     * @param callback  接入回调
     * @return
     */
    int connect(String account, String domain, String sessionId, String addr, String app, LoginCallBack callback);
}
