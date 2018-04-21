package com.jarry.jchat.utils;

/**
 * Created by Jarry on 2018/4/22.
 */

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jarry on 2018/3/8.
 */

public class SpUtils {
    static final String SP_NAME = "SP_SAVE";

    public static void saveString(Context mActivity, String key,
                                  String value) {
        SharedPreferences sp = mActivity.getSharedPreferences(SP_NAME,
                Context.MODE_PRIVATE);
        sp.edit().putString(key, value).commit();
    }

    public static String getString(Context mActivity, String key,
                                   String defValue) {
        SharedPreferences sp = mActivity.getSharedPreferences(SP_NAME,
                Context.MODE_PRIVATE);
        return sp.getString(key, defValue);
    }

    public static void setBoolean(Activity mActivity, String key,
                                  boolean value) {
        SharedPreferences sp = mActivity.getSharedPreferences(SP_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putBoolean(key, value);
        edit.commit();
    }

    public static boolean isFirst(Activity mActivity) {
        return getBoolean(mActivity, "isfirst", true);
    }

    public static boolean getBoolean(Activity mActivity, String key,
                                     boolean defValue) {
        SharedPreferences sp = mActivity.getSharedPreferences(SP_NAME,
                Context.MODE_PRIVATE);
        return sp.getBoolean(key, defValue);
    }

    public static void saveHeight(Activity mActivity, int height) {
        SharedPreferences sp = mActivity.getSharedPreferences(SP_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putInt("height", height);
        edit.commit();
    }

    public static int getHeight(Activity mActivity) {
        SharedPreferences sp = mActivity.getSharedPreferences(SP_NAME,
                Context.MODE_PRIVATE);
        return sp.getInt("height", 0);
    }

    public static String getMessagePushId(Context mActivity) {
        SharedPreferences sp = mActivity.getSharedPreferences(SP_NAME,
                Context.MODE_PRIVATE);
        return sp.getString("id", "");
    }

    public static void cleanSharedPreferences(Context mActivity, String preferencesName) {
        SharedPreferences settings = mActivity.getSharedPreferences(preferencesName, 0);
        SharedPreferences.Editor editor = settings.edit();
        settings.edit().clear().commit();
    }

    public static String obj2String(Object object) {
        String SceneListString = "";
        try {
            // 实例化一个ByteArrayOutputStream对象，用来装载压缩后的字节文件。
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            // 然后将得到的字符数据装载到ObjectOutputStream
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    byteArrayOutputStream);
            // writeObject 方法负责写入特定类的对象的状态，以便相应的 readObject 方法可以还原它
            objectOutputStream.writeObject(object);
            // 最后，用Base64.encode将字节文件转换成Base64编码保存在String中
            SceneListString = new String(Base64.encode(
                    byteArrayOutputStream.toByteArray(), Base64.DEFAULT));
            // 关闭objectOutputStream
            objectOutputStream.close();
        } catch (Exception e) {

        }
        return SceneListString;
    }

    @SuppressWarnings("unchecked")
    public static Object String2Obj(String SceneListString)
            throws StreamCorruptedException, IOException,
            ClassNotFoundException {
        byte[] mobileBytes = Base64.decode(SceneListString.getBytes(),
                Base64.DEFAULT);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(
                mobileBytes);
        ObjectInputStream objectInputStream = new ObjectInputStream(
                byteArrayInputStream);
        Object SceneList = objectInputStream
                .readObject();
        objectInputStream.close();
        return SceneList;
    }

}

