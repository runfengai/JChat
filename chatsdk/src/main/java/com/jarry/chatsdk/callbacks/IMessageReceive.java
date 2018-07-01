package com.jarry.chatsdk.callbacks;


import com.jarry.chatsdk.bean.Contact;
import com.jarry.chatsdk.bean.Message;

/**
 * 接收消息
 *
 * @Author jarry
 * created at 2018/7/2 0:44
 */

public interface IMessageReceive {

    /**
     * 接收消息,统一消息
     *
     * @param from 发送者Id
     * @param app  资源名
     * @param msg  消息内容
     * @param type 单聊或群聊
     */
    void onReceive(Contact from, String app, String type, Message msg);
}
