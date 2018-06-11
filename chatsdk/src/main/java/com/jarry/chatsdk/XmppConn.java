package com.jarry.chatsdk;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

import com.jarry.chatsdk.interfaces.ConnectCallBack;
import com.jarry.chatsdk.utils.Constants;
import com.jarry.chatsdk.utils.ErrorMap;
import com.jarry.chatsdk.utils.LogUtils;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.ConnectionListener;
import org.jivesoftware.smack.SASLAuthentication;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.StanzaListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.roster.Roster;
import org.jivesoftware.smack.roster.RosterListener;
import org.jivesoftware.smack.sasl.SASLMechanism;
import org.jivesoftware.smack.sasl.provided.SASLPlainMechanism;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
import org.jxmpp.jid.Jid;
import org.jxmpp.stringprep.XmppStringprepException;

import java.util.Collection;

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
                return;
            }
            connection.connect();//连接
            connection.login(userName, password);//登陆
            //状态更新
            Presence presence = new Presence(Presence.Type.available);
            presence.setStatus("online");
            connection.sendStanza(presence);

        } catch (Exception e) {
            String err = e.getMessage();
            connectCallBack.onFail(ErrorMap.CODE_CONN, err);
            return;
        }
        //连接成功
        connectCallBack.onSuccess();
        setListeners();

    }

    private void setListeners() {
        addConnectionListener(connectionListener);
        connection.addStanzaSendingListener(new StanzaListener() {
            @Override
            public void processStanza(Stanza packet) throws SmackException.NotConnectedException, InterruptedException, SmackException.NotLoggedInException {
                LogUtils.e("xmppservice发送新消息：" + packet.toXML().toString());
            }
        }, new StanzaFilter() {
            @Override
            public boolean accept(Stanza stanza) {
                return true;
            }
        });
        //监听各种消息，以后会扩展自己的消息协议
        connection.addAsyncStanzaListener(new StanzaListener() {
            @Override
            public void processStanza(Stanza packet) throws SmackException.NotConnectedException, InterruptedException, SmackException.NotLoggedInException {
                LogUtils.e("xmppservice接收到新消息：" + packet.toXML().toString());
                //处理message
                if (packet instanceof Message)
                    handleMessage((Message) packet);
                else if (packet instanceof IQ)
                    handleIQ((IQ) packet);
                else if (packet instanceof Presence)
                    handlePresence((Presence) packet);

            }
        }, new StanzaFilter() {
            @Override
            public boolean accept(Stanza stanza) {
                if (stanza instanceof Message) {
                    if (((Message) stanza).getType() == Message.Type.groupchat
                            || ((Message) stanza).getType() == Message.Type.chat
                            || ((Message) stanza).getType() == Message.Type.normal) {
                        return true;
                    }
                } else if (stanza instanceof IQ) {
                    return true;
                } else if (stanza instanceof Presence) {
                    return true;
                }


                return false;
            }
        });
        //打印消息
        connection.addAsyncStanzaListener(new StanzaListener() {
            @Override
            public void processStanza(Stanza packet) throws SmackException.NotConnectedException, InterruptedException, SmackException.NotLoggedInException {
                LogUtils.d("xmppservice接收到所有allMessage：" + packet.toXML().toString());
            }
        }, new StanzaFilter() {
            @Override
            public boolean accept(Stanza stanza) {
                return true;
            }
        });

        //花名册
        Roster roster = Roster.getInstanceFor(connection);
        roster.addRosterListener(new RosterListener() {
            @Override
            public void entriesAdded(Collection<Jid> addresses) {

            }

            @Override
            public void entriesUpdated(Collection<Jid> addresses) {

            }

            @Override
            public void entriesDeleted(Collection<Jid> addresses) {

            }

            @Override
            public void presenceChanged(Presence presence) {
                int state = 0;
                if (presence.getType() == Presence.Type.available) {
                    switch (presence.getMode().ordinal()) {
                        case 0:
                            state = Constants.STATE_FREE;
                            break;
                        case 1:
                            state = Constants.STATE_ONLINE;
                            break;
                        case 2:
                            state = Constants.STATE_LEAVE;
                            break;
//                    case 3:
//                        state = Constants.STATE_OFFLINE;
//                        break;
                        case 4:
                            state = Constants.STATE_BUSY;
                            break;
                        default:
                            state = Constants.STATE_ONLINE;
                    }
                } else if (presence.getType() == Presence.Type.unavailable) {
                    state = Constants.STATE_OFFLINE;
                }
                LogUtils.d("=====presenceChanged=====   state=" + state);
//                LogUtils.e("Presence changed: " + presence.toString());
//                Intent broadcast = new Intent();
//                broadcast.setAction(Actions.ACTION_PRESENCE_CHANGE);
//                broadcast.putExtra(IntentParameters.FROM, presence.getFrom().getLocalpartOrNull().toString());
//                broadcast.putExtra(IntentParameters.PRESENCE_STATE, state);
//                LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(broadcast);

            }
        });


    }

    /**
     * 处理出席消息
     *
     * @param packet
     */
    private void handlePresence(Presence packet) {
    }

    /**
     * 处理IQ消息
     *
     * @param packet
     */
    private void handleIQ(IQ packet) {
    }

    /**
     * 处理消息
     *
     * @param packet
     */
    private void handleMessage(Message packet) {
    }


    public void addConnectionListener(ConnectionListener connectionListener) {
        if (connection != null)
            connection.addConnectionListener(connectionListener);
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
            //auth对应的机制
            SASLAuthentication.registerSASLMechanism(new SASLPlainMechanism());
//            SASLAuthentication.blacklistSASLMechanism(SASLMechanism.PLAIN);
            SASLAuthentication.blacklistSASLMechanism(SASLMechanism.DIGESTMD5);
            SASLAuthentication.blacklistSASLMechanism(SASLMechanism.CRAMMD5);
            SASLAuthentication.blacklistSASLMechanism("SCRAM-SHA-1");
            XMPPTCPConnection connection = new XMPPTCPConnection(builder.build());
            return connection;
        } catch (XmppStringprepException e) {
            LogUtils.e(e.getMessage());
        }
        return null;
    }

    /**
     * SDK默认的连接监听
     */
    private ConnectionListener connectionListener = new ConnectionListener() {
        @Override
        public void connected(XMPPConnection connection) {
            LogUtils.d("===connected===");
        }

        @Override
        public void authenticated(XMPPConnection connection, boolean resumed) {
            LogUtils.d("===authenticated===");

        }

        @Override
        public void connectionClosed() {
        }

        @Override
        public void connectionClosedOnError(Exception e) {

        }

        @Override
        public void reconnectionSuccessful() {

        }

        @Override
        public void reconnectingIn(int seconds) {

        }

        @Override
        public void reconnectionFailed(Exception e) {

        }
    };
}
