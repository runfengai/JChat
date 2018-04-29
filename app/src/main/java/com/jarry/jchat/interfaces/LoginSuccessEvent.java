package com.jarry.jchat.interfaces;

/**
 * Created by Jarry on 2018/4/22.
 */

public class LoginSuccessEvent {
    public static final int SUCCESS = 1;
    public static final int FAILED = -1;
    public final int state;

    public LoginSuccessEvent(int state) {
        this.state = state;
    }
}
