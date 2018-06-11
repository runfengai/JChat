package com.jarry.chatsdk.utils;

import java.util.HashMap;
import java.util.Map;

/**
*
*@Author jarry
*created at 2018/6/12 0:04
*/

public class Constants {
    public static final int LOGIN_PRE_USERNAME_NULL = 10;//用户名为空
    public static final int LOGIN_PRE_USERNAME_TOO_LONG = 11;//用户名过长
    public static final int LOGIN_PRE_USERNAME_IRREGLAR = 12;//用户名包含特殊字符
    public static final int LOGIN_PRE_PASSWORD_NULL = 13;//密码为空


    public static Map<Integer, String> loginMap = new HashMap<>();
    public static final int LOGIN_SUCCESS = 0;//登录成功
    public static final int LOGIN_ERROR = 1;//登录失败
    public static final int LOGIN_ERROR_NOT_AUTHORIZED = 2;//账号或密码错误
    public static final int LOGIN_ERROR_UNKNOWNHOST = 3; //无法连接到服务器: 不可达的主机名或地址
    public static final int LOGIN_ERROR_CONFLICT = 4;//账号已经登录 无法重复登录
    public static final int LOGIN_ERROR_SERVER = 5;//服务器错误
    public static final int LOGIN_ERROR_NETWORK = 6;//网络错误
    public static final int LOGIN_ERROR_LOGINING = 7;//正在登陆
    public static final int LOGIN_ERROR_UNKNOWN = 8;//未知错误


    static {
        loginMap.put(LOGIN_SUCCESS, "登录成功");
        loginMap.put(LOGIN_ERROR_NOT_AUTHORIZED, "账号或密码错误");
        loginMap.put(LOGIN_ERROR_UNKNOWNHOST, "无法连接到服务器: 不可达的主机名或地址.");
        loginMap.put(LOGIN_ERROR_CONFLICT, "账号已经登录 无法重复登录");
        loginMap.put(LOGIN_ERROR_SERVER, "服务器错误");
        loginMap.put(LOGIN_ERROR, "登录失败");
        loginMap.put(LOGIN_ERROR_NETWORK, "网络错误");
        loginMap.put(LOGIN_ERROR_LOGINING, "正在登陆");
        loginMap.put(LOGIN_ERROR_UNKNOWN, "未知错误");

    }

    public static Map<Integer, String> sendMessageMap = new HashMap<>();
    public static final int SEND_MESSAGE_ERROR_CONNECTION = 0;//连接错误
    public static final int SEND_MESSAGE_ERROR_INTERRUPTED = 1;//线程中断
    public static final int SEND_MESSAGE_ERROR_OFFLINE = 2;//用户已离线
    public static final int SEND_MESSAGE_ERROR_NETWORK = 3;//网络错误
    public static final int SEND_MESSAGE_ERROR_UPLOAD = 4;//上传失败
    public static final int SEND_MESSAGE_SUCCESS = 5;//发送成功
    public static final int SEND_MESSAGE_UPLOADING = 6;//发送成功

    static {
        sendMessageMap.put(SEND_MESSAGE_ERROR_CONNECTION, "连接错误");
        sendMessageMap.put(SEND_MESSAGE_ERROR_INTERRUPTED, "线程中断");
        sendMessageMap.put(SEND_MESSAGE_ERROR_OFFLINE, "用户已离线");
        sendMessageMap.put(SEND_MESSAGE_ERROR_NETWORK, "网络错误");
        sendMessageMap.put(SEND_MESSAGE_ERROR_UPLOAD, "上传失败");
    }

    //    消息类型
    public static final int REQUEST_VIDEO_SEND = 1;//发送视频请求
    public static final int REQUEST_VOIP_SEND = 2;//发送单人语音
    public static final int REQUEST_GROUP_VIDEO_SEND = 3;//发送群视频请求


    //处理
    public static final int TYPE_ACCEPT = 2;//接受voip
    public static final int TYPE_REJECT = 3;//拒绝voip
    public static final int TYPE_HANGUP = 4;//挂断voip
    public static final int TYPE_BUSY = 5;//挂断voip

    //用户在线状态
    public static final int STATE_OFFLINE = 0;//离线
    public static final int STATE_ONLINE = 1;//在线
    public static final int STATE_BUSY = 2;//忙碌
    public static final int STATE_LEAVE = 3;//离开
    //    public static final int STATE_OFFLINE = 4;//离线
    public static final int STATE_FREE = 4;//空闲
    public static Map<Integer, String> stateMap = new HashMap<>();

    static {
        stateMap.put(STATE_ONLINE, "在线");
        stateMap.put(STATE_BUSY, "忙碌");
        stateMap.put(STATE_LEAVE, "离开");
        stateMap.put(STATE_OFFLINE, "离线");
        stateMap.put(STATE_FREE, "空闲");
    }

}
