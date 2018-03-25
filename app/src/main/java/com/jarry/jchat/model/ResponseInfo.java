package com.jarry.jchat.model;

/**
 * 接口返回数据
 * Created by Jarry on 2018/3/25.
 */

public class ResponseInfo<T> {
    public static final int SUCCESS_CODE = 0;
    private int code;
    private String msg;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        if (this.code == SUCCESS_CODE) {
            return true;
        } else {
            return false;
        }
    }
}
