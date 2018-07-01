package com.jarry.chatsdk.bean;

/**
 *
 */

/**
 * 消息基类
 *
 * @Author jarry
 * created at 2018/7/2 0:47
 */


public abstract class Message extends BaseBean {
    protected String messageId;//消息id

    protected String extension = "";//预留扩展字段

    protected int msgFinalType;//将所有的消息类型在SDK层解析后暴露到组件中，参考MsgFinalType


    //获取extension字段的str
    public String getExtensionStr() {
        return extension;
    }

    public int getMsgFinalType() {
        return msgFinalType;
    }

    public void setMsgFinalType(int msgFinalType) {
        this.msgFinalType = msgFinalType;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }


    public Message() {
//        Context context = JarryClient.getInstance().getContext();
////        String account = (String) SpUtils.get(context, Constants.SP.ACCOUNT, "");
//        String account = SaveUtils.getAccount();
//        String domain = (String) SpUtils.get(JarryClient.getInstance().getContext(), Constants.SP.DOMAIN, "");
//        this.messageId = account + "-" + domain + "-" + System.currentTimeMillis();
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getExtension() {
        return extension;
    }
}
