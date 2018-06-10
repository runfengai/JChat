package com.jarry.chatsdk;

import com.jarry.chatsdk.interfaces.ConnectCallBack;
import com.jarry.chatsdk.utils.ErrorMap;
import com.jarry.chatsdk.utils.LogUtils;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
import org.jxmpp.stringprep.XmppStringprepException;

import java.io.IOException;

/**
 * xmpp连接工具类
 * Created by Jarry on 2018/5/30.
 */

public class XmppConn {

    private static XmppConn instance = new XmppConn();

    private XmppConn() {
    }

    public static XmppConn getInstance() {
        return instance;
    }

    private XMPPTCPConnection connection;

    /**
     * 连接并登陆鉴权
     *
     * @param userName
     * @param password
     */
    public void connect(String userName, String password, ConnectCallBack connectCallBack) {
        LogUtils.d("====connect=====    userName=" + userName + "  password=" + password);
        try {
            connection = getConnection();
            if (connection == null) {
                connectCallBack.onFail(ErrorMap.CODE_LOGIN_NET_WORK, ErrorMap.getErrStr(ErrorMap.CODE_LOGIN_NET_WORK));
            }
            connection.connect();//连接
            connection.login(userName, password);//登陆
            //状态更新
            Presence presence = new Presence(Presence.Type.available);
            presence.setStatus("online");
            connection.sendStanza(presence);
            connectCallBack.onSuccess();
        } catch (Exception e) {
            String err = e.getMessage();
            connectCallBack.onFail(ErrorMap.CODE_CONN, err);

        }
    }


    public XMPPTCPConnection getConnection() {
        XMPPTCPConnectionConfiguration.Builder builder = XMPPTCPConnectionConfiguration.builder();
        try {
            builder.setXmppDomain(XmppConfig.SERVER_DOMAIN_NAME);
            builder.setHost(XmppConfig.SERVER_IP);
            builder.setPort(XmppConfig.SERVER_PORT);
            builder.setResource(XmppConfig.SERVER_RESOURCE);//资源
            builder.setCompressionEnabled(false);//是否启用流压缩技术，如果启用TLS建立之后触发

            builder.setDebuggerEnabled(BuildConfig.DEBUG);
            builder.setSendPresence(true);
            builder.setSecurityMode(ConnectionConfiguration.SecurityMode.disabled);//是否启用TLS
            XMPPTCPConnection connection = new XMPPTCPConnection(builder.build());
            return connection;
        } catch (XmppStringprepException e) {
            e.printStackTrace();
        }
        return null;
    }
}
