package com.jarry.jchat.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.elvishew.xlog.Logger;
import com.jarry.jchat.R;
import com.jarry.jchat.databinding.ActivityLoginSysBinding;
import com.jarry.jchat.model.Login;

/**
 * 登录
 */
public class LoginSysActivity extends BaseActivity {
    private ActivityLoginSysBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login_sys);
        Login login = new Login();
        binding.setLogin(login);
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
            attamptLogin();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void attamptLogin() {
        Logger logger = new Logger.Builder().build();
        logger.d("=====attamptLogin=====");
        logger.d("=====binding.getLogin()=====" + binding.getLogin().getPhone());
        binding.getLogin().onOkClick(binding.phone);
    }
}
