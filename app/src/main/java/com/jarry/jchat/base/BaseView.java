package com.jarry.jchat.base;

import android.content.Context;

/**
 * Created by Jarry on 2018/3/25.
 */

public interface BaseView {

    void showLoading(String msg);

    void closeLoading();

    void showDialog(String msg);

    void showToast(String msg);

    /**
     * 获取上下文
     *
     * @return 上下文
     */
    Context getContext();
}
