package com.jarry.jchat.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.jarry.jchat.BR;

/**
 * Description:
 * User: Jarry
 * Date: 2018-03-04
 * Time: 11:29
 */
public class UserInfo extends BaseObservable {

    private String userId;
    private String userName;
    private String userNameShort;
    private String phone;
    private String password;
    private String avatar;
    private int gender;

    //其他附加属性
    private String state;//在线状态

    public String getUserNameShort() {
        return userNameShort;
    }

    public void setUserNameShort(String userNameShort) {
        this.userNameShort = userNameShort;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Bindable
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
        notifyPropertyChanged(BR.userName);
    }

    @Bindable
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
        notifyPropertyChanged(BR.phone);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}
