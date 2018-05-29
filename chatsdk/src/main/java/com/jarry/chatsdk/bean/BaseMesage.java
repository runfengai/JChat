package com.jarry.chatsdk.bean;

import java.io.Serializable;

/**
 * 基类消息
 * Created by Jarry on 2018/5/30.
 */

public class BaseMesage implements Serializable {
    public String msgId;//消息id
    //两种类型，区分消息类型
    public int msgType;
    public int subType;
}
