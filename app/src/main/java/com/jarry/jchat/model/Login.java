package com.jarry.jchat.model;

import android.content.Intent;
import android.databinding.BaseObservable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.jarry.jchat.ui.AccountValidatorUtil;
import com.jarry.jchat.ui.login.LoginVerificationActivity;

/**
 * 登录
 * Created by Jarry on 2018/3/10.
 */

public class Login extends BaseObservable {
    private String country;
    private String phone = "18811730000";

    /**
     * 按钮点击
     *
     * @param view
     */
    public void onOkClick(View view) {
        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(view.getContext(), "手机号不能为空", Toast.LENGTH_LONG).show();
            return;
        }
        if (!AccountValidatorUtil.isMobile(phone)) {
            Toast.makeText(view.getContext(), "手机号格式不正确", Toast.LENGTH_LONG).show();
            return;
        }

        Intent intent = new Intent(view.getContext(), LoginVerificationActivity.class);
        view.getContext().startActivity(intent);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
