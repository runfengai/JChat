package com.jarry.jchat.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.elvishew.xlog.Logger;
import com.jarry.jchat.R;
import com.jarry.jchat.databinding.ActivityLoginSysBinding;
import com.jarry.jchat.interfaces.LoginSuccessEvent;
import com.jarry.jchat.model.Login;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

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
        logger.d("=====binding.getLogin()=====" + binding.getLogin().getPhone());
        binding.getLogin().onOkClick(binding.phone);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLoginSuccess(LoginSuccessEvent event) {
        if (event.state == LoginSuccessEvent.SUCCESS) {
            finish();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }
}
