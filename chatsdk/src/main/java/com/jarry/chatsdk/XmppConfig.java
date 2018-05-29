package com.jarry.chatsdk;

import org.jivesoftware.smack.tcp.XMPPTCPConnection;

/**
 * xmpp相关的配置文件
 * Created by Jarry on 2018/5/30.
 */

public interface XmppConfig {
    //服务端ip+端口
    String SERVER_IP = "127.0.0.1";
    int SERVER_PORT = 5222;
    String SERVER_DOMAIN_NAME = "jarry.com";


}
