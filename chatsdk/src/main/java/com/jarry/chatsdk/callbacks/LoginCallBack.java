package com.jarry.chatsdk.callbacks;

/**
 * 登录回调
 *
 * @Author jarry
 * created at 2018/7/2 0:47
 */


public interface LoginCallBack {
    /**
     * 登录成功
     */
    void onSuccess();

    /**
     * 登录失败
     *
     * @param errCode 错误码
     * @param errStr  错误描述
     */
    void onError(int errCode, String errStr);
}
