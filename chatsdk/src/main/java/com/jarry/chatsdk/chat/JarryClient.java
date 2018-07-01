package com.jarry.chatsdk.chat;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;


import com.jarry.chatsdk.callbacks.IMessageReceive;
import com.jarry.chatsdk.interfaces.IUserInfo;
import com.jarry.chatsdk.interfaces.impl.UserInfoImpl;
import com.jarry.chatsdk.utils.LogUtils;
import com.jarry.chatsdk.utils.NetworkUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * 客户端实例
 *
 * @Author jarry
 * created at 2018/7/2 0:40
 */

public class JarryClient {
    private Context applicationContext;
    //单实例
    private static volatile JarryClient instance = null;
    public static Handler handler = new Handler(Looper.getMainLooper());
    //用户登录、初始化
    private IUserInfo iUserInfo;
    //接收消息
    private Set<IMessageReceive> iMessageReceives = new HashSet<>();

    public static JarryClient getInstance() {
        if (instance == null) {
            synchronized (JarryClient.class) {
                if (instance == null) instance = new JarryClient();
            }
        }
        return instance;
    }

    public void init(Context applicationContext) {
        this.applicationContext = applicationContext.getApplicationContext();
        //用户相关操作
        if (iUserInfo == null) {
            LogUtils.d("创建iUserInfo");
            iUserInfo = new UserInfoImpl();
        }
        NetworkUtils.init(applicationContext);
    }
}
