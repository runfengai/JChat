package com.jarry.chatsdk.enums;

/**
*
*@Author jarry
*created at 2018/7/2 0:01
*/

public interface Actions {
    String ACTION_LOGIN = "action_login";
    String RE_ACTION_LOGIN = "re_action_login";


    String ACTION_LOGIN_SUCCESS = "com.iswsc.smack.loginCommunicationSystem.success";//登录成功
    String ACTION_LOGIN_ERROR = "com.iswsc.smack.loginCommunicationSystem.error";//登录失败


    String ACTION_REGISTER = "action_register";


    String ACTION_LOGOUT = "action_logout";
    String SENDMESSAGE = "sendmessage";
    String ACTION_ONLINE_STATE = "action_set_online_state";//设置在线状态
    String ACTION_SUBSCRIBE = "action_subscribe";//订阅
    /**
     * 消息发送是否成功
     */
    String ACTION_RESULT_SEND_MESSAGE = "action_result_message";
    /**
     * 收发普通消息
     */
    String ACTION_NEW_MESSAGE = "action_new_message";
    /**
     * 接收到视频相关消息
     */
    String ACTION_VIDEO_CALL = "action_video_call";                                               // 通知 消息 视频
    /**
     * 通知类消息
     */
    String ACTION_NOTICE_MESSAGE = "action_notice_message";
    String ACTION_CALL_MESSAGE = "action_call_message"; // 实时 视频 广播

    /**
     * 订阅相关
     */
    String ACTION_BROADCAST_SUBSCRIBE_GETLIST = "action_broadcast_subscribe_getlist";//获取被订阅人列表
    String ACTION_RESULT_SET_PRESENCE = "action_result_set_presence";
    String ACTION_PRESENCE_CHANGE = "action_presence_change";//订阅状态变化
    /**
     * 群组相关action
     */
    String ACTION_GROUP = "action_group";//群组服务
    String ACTION_BROADCAST_GROUP_GETLIST = "action_group_getlist";//获取群组列表
    String ACTION_BROADCAST_CREATE_GROUP = "action_create_group";//创建群组
    String ACTION_BROADCAST_JOIN_GROUP = "action_join_group";//创建群组
    String ACTION_BROADCAST_LEAVE_GROUP = "action_leave_group";//创建群组
    String SENDGROUPMESSAGE = "send_group_message";

    /**
     * 状态相关
     */
    String ACTION_CONNECTION_STATE_CHANGED = "connection_state_changed";
    /**
     * 主动获取连接状态的方法
     */
    String ACTION_GET_STATE = "action_get_state";
}
