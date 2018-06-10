package com.jarry.chatsdk.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 错误码
 * Created by Jarry on 2018/6/10.
 */

public class ErrorMap {
    public static final int CODE_LOGIN_NET_WORK = 1;
    public static final int CODE_CONN = 2;
    public static final int CONNECTION_CLOSED = 3;
    public static final int CONNECTION_CLOSED_ONERROR = 4;

    private static Map<Integer, String> errorMap = new HashMap<>();

    static {
        errorMap.put(CODE_LOGIN_NET_WORK, "网络异常");
        errorMap.put(CONNECTION_CLOSED, "连接关闭");
    }

    public static String getErrStr(int code) {
        return errorMap.get(code);
    }

}
