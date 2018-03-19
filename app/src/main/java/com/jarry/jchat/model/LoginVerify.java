package com.jarry.jchat.model;

import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.jarry.jchat.ui.AccountValidatorUtil;

/**
 * 登录验证码校验
 * Created by Jarry on 2018/3/10.
 */

public class LoginVerify {
    private String verification;
    private String phone;

    /**
     * 按钮点击
     *
     * @param view
     */
    public void onOkClick(View view) {
        if (TextUtils.isEmpty(verification)) {
            Toast.makeText(view.getContext(), "验证码不能为空", Toast.LENGTH_LONG).show();
            return;
        }


//        Intent intent = new Intent(view.getContext(), LoginActivity.class);
//        view.getContext().startActivity(intent);
    }

    public String getVerification() {
        return verification;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setVerification(String verification) {
        this.verification = verification;
    }
}
