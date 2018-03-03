package com.jarry.jchat.model;

import android.content.Intent;
import android.view.View;

import com.jarry.jchat.App;
import com.jarry.jchat.R;
import com.jarry.jchat.ui.LoginActivity;

/**
 * Created by Jarry on 2018/2/28.
 */

public class Index {
    //开始按钮
    private String btn;

    public void onBtnClick(View view) {
        Intent intent = new Intent(view.getContext(), LoginActivity.class);
        view.getContext().startActivity(intent);
    }

    public Index() {
        btn = App.getInstance().getResources().getString(R.string.index_start);
    }

    public String getBtn() {
        return btn;
    }

    public void setBtn(String btn) {
        this.btn = btn;
    }
}
