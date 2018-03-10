package com.jarry.jchat.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.jarry.jchat.R;
import com.jarry.jchat.databinding.ActivityLoginSysBinding;
import com.jarry.jchat.databinding.ActivityLoginVerificationBinding;
import com.jarry.jchat.model.Login;
import com.jarry.jchat.model.LoginVerify;

/**
 * 登录验证码
 */
public class LoginVerificationActivity extends BaseActivity {
    private ActivityLoginVerificationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login_verification);
        LoginVerify loginVerify = new LoginVerify();
        binding.setLoginVerify(loginVerify);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.login_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.ok) {
            binding.getLoginVerify().onOkClick(binding.phone);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
