package com.jarry.chatsdk.bean;

/**
 * Created by zhongdao on 2018/1/15.
 * email:zhongdao@suneee.com
 */

public class Contact extends BaseBean {
    private String account;//联系人账号
    private String roomId;//如果是群聊会有房间号

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "account='" + account + '\'' +
                ", roomId='" + roomId + '\'' +
                '}';
    }
}
