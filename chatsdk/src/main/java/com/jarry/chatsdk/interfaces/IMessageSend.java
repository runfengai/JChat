package com.jarry.chatsdk.interfaces;


import com.jarry.chatsdk.bean.Message;
import com.jarry.chatsdk.callbacks.MsgCallback;

/**
 * 发送消息,包含一对一发送，群聊发送（to表示房间id）。
 */
public interface IMessageSend {
    /**
     * 异步发送消息，统一接口
     *
     * @param to          接收者账号/房间id
     * @param type        群聊或单聊 单聊：“chat” 群聊：“groupchat”
     * @param msg         消息内容
     * @param msgCallback 异步回调
     */
    void send(String to, String type, Message msg, MsgCallback msgCallback);
 
}
