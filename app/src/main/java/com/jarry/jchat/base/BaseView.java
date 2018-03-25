package com.jarry.jchat.base;

/**
 * Created by Jarry on 2018/3/25.
 */

public interface BaseView {

    void showLoading(String msg);

    void closeLoading();

    void showDialog(String msg);

    void showToast(String msg);

}
