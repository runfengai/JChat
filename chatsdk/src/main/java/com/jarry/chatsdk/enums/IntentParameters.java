package com.jarry.chatsdk.enums;

/**
 * Created by BJQT on 2017/11/9.
 */

public interface IntentParameters {
    String ERROR_CODE = "error_code";
    String ERROR_MSG = "error_msg";

    String USERNAME = "username";
    String PASSWORD = "password";
    String ERRORSTR = "errorstr";
    String LOGOUT_RESULT = "logout_result";
    String FROM = "recriverid";
    String FROM_RESOURCE = "from_resource";
    String MESSAGE = "message";
    String MESSAGEUUID = "messageuuid";
    String SEND_STATE = "send_state";
    String NEWMESSAGE = "newmessage";
    String RECEIVE_MESSAGE = "receive_state";
    String CODE = "code";
    String ONLINE_STATE = "online_state";
    String SUBSCRIBE = "subscribe";
    String SUBSCRIBE_MODE = "subscribe_mode";
    String SUBSCRIBE_CONTACTID = "subscribe_contactid";
    String SUBSCRIBE_LIST = "subscribe_list";
    String GROUP_OPERATE = "group_operate";
    String GROUP_CONTACTLIST = "group_contactlist";
    String GROUP_CREATE_ROOM = "group_create_room";
    String GROUP_ROOM = "group_join_room";
    String GROUP_MESSAGE = "group_message";
    String CALL = "call";
    String DOMAIN = "domain";
    String ADDR = "addr";
    String APP = "app";
    String TO = "to";
    String CHAT_TYPE = "chat_type";
    String PRESENCE_STATE = "presence_state";
    String MESSAGE_ID = "message_id";
    String MESSAGE_TYPE = "message_type";
    String GROUP_ROOM_ID = "group_room_id";


    //状态变化相关
    String CONNECTION_STATE_CHANGE = "connection_state_change";

    String RECONNECTION_FAILED = "reconnection_failed";

    String RECONNECTION_SUCCESSFUL = "reconnection_successful";
    //登陆成功
    String CONNECTION_CONFLICT = "connection_conflict";

    String CONNECTION_CLOSED = "connection_closed";

    //状态相关
    String CONNECTION_STATE = "connection_state";
    int STATE_CONNECTION_SUCCESS = 0;
    int STATE_CONNECTING = 1;
    int STATE_CONNECTION_CLOSED = 2;
}
