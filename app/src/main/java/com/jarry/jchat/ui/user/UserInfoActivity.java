package com.jarry.jchat.ui.user;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.jarry.jchat.R;
import com.jarry.jchat.base.BaseActivity;
import com.jarry.jchat.databinding.ActivityLoginVerificationBinding;
import com.jarry.jchat.databinding.ActivityUserInfoBinding;
import com.jarry.jchat.ui.login.LoginContract;
import com.jarry.jchat.ui.login.LoginPresenter;

public class UserInfoActivity extends BaseActivity<ActivityUserInfoBinding, UserInfoPresenter> implements UserInfoContract.View {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = DataBindingUtil.setContentView(this, setLayoutId());
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_user_info;
    }

    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {

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
    protected UserInfoPresenter createPresenter() {
        return null;
    }


}
