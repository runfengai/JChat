package com.jarry.jchat.ui.login;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;

import com.jarry.jchat.R;
import com.jarry.jchat.base.BaseActivity;
import com.jarry.jchat.databinding.ActivityLoginVerificationBinding;
import com.jarry.jchat.model.LoginVerify;
import com.jarry.jchat.model.UserInfo;

/**
 * 登录验证码
 */
public class LoginVerificationActivity extends BaseActivity<ActivityLoginVerificationBinding, LoginPresenter> implements LoginContract.View {
//    private UserInfoPresenter loginPresenter;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_login_verification;
    }

    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {
        Intent intent = getIntent();
        LoginVerify loginVerify = new LoginVerify();
        if (intent != null) {
            loginVerify.setPhone(intent.getStringExtra("userName"));
        }
        binding.setLoginVerify(loginVerify);

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = DataBindingUtil.setContentView(this, setLayoutId());
        super.onCreate(savedInstanceState);
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
            //点击登录
            mPresenter.attemptLogin(binding.getLoginVerify().getPhone(), binding.getLoginVerify().getVerification());
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        loginPresenter.detachView();
    }

    @Override
    public void loginSuccess(UserInfo userInfo) {

    }
}
