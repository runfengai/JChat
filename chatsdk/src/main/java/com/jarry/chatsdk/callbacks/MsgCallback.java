package com.jarry.chatsdk.callbacks;

/**
 * 发送消息的回调
 *
 * @Author jarry
 * created at 2018/7/2 0:47
 */

public interface MsgCallback {
    /**
     * 发送成功
     *
     * @param messageId 消息id
     */
    void onSuccess(String messageId);

    /**
     * 发送失败
     *
     * @param errCode   错误码
     * @param errStr    错误描述
     * @param messageId 消息id
     */
    void onError(int errCode, String errStr, String messageId);

    void onUploading(float progress);
}
