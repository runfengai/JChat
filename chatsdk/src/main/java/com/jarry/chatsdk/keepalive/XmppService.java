package com.jarry.chatsdk.keepalive;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.jarry.chatsdk.XmppConn;
import com.jarry.chatsdk.enums.Actions;
import com.jarry.chatsdk.enums.IntentParameters;
import com.jarry.chatsdk.utils.LogUtils;

import org.w3c.dom.Text;

/**
 * 服务，用于处理消息
 * Created by Jarry on 2018/6/11.
 */

public class XmppService extends IntentService {
    private String app;//资源名
    private String username;
    private String password;
    private String addr;//登录地址

    private boolean isLogining = false;

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public XmppService(String name) {
        super(name);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    protected void onHandleIntent(@NonNull Intent intent) {
        String type = intent.getAction();
        if (TextUtils.isEmpty(type)) return;
        switch (type) {
            //登录相关
            case Actions.ACTION_LOGIN:
                username = intent.getStringExtra(IntentParameters.USERNAME);
                password = intent.getStringExtra(IntentParameters.PASSWORD);
                addr = intent.getStringExtra(IntentParameters.ADDR);
                app = intent.getStringExtra(IntentParameters.APP);
                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                    LogUtils.e("====用户名或密码为空====");
                    return;
                }
                if (TextUtils.isEmpty(addr)) {
                    LogUtils.e("====服务器连接地址为空====");
                    return;
                }
                LogUtils.e("XmppService login(): username :" + username + " password :" + password + " addr:" + addr + " app: " + app);
                break;
        }
    }
}
