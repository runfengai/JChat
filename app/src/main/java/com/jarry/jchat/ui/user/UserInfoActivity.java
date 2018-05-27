package com.jarry.jchat.ui.user;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;

import com.jarry.jchat.R;
import com.jarry.jchat.base.BaseActivity;
import com.jarry.jchat.databinding.ActivityLoginVerificationBinding;
import com.jarry.jchat.databinding.ActivityUserInfoBinding;
import com.jarry.jchat.model.LoginVerify;
import com.jarry.jchat.model.UserInfo;
import com.jarry.jchat.ui.login.LoginContract;
import com.jarry.jchat.ui.login.LoginPresenter;

public class UserInfoActivity extends BaseActivity<ActivityUserInfoBinding, UserInfoPresenter> implements UserInfoContract.View {
    public static final String EXTRA_USER_ID = "extra_user_id";
    UserInfo userInfoModel = new UserInfo();

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
        Intent intent = getIntent();
        if (intent != null) {
            userInfoModel.setUserId(intent.getStringExtra(EXTRA_USER_ID));
        }
        //TODO 假数据
        userInfoModel.setUserId("1234");
        binding.setUserInfo(userInfoModel);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void loadData() {
        String userId = userInfoModel.getUserId();
        if (!TextUtils.isEmpty(userId)) {
            mPresenter.loadData(userId, userInfoModel);
        }
    }

    @Override
    protected UserInfoPresenter createPresenter() {
        return new UserInfoPresenter();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_user_info, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.share) {
            //
//            mPresenter.attemptLogin(binding.getLoginVerify().getPhone(), binding.getLoginVerify().getVerification());
            return true;
        } else if (id == R.id.shortcut) {
            //点击登录
//            mPresenter.attemptLogin(binding.getLoginVerify().getPhone(), binding.getLoginVerify().getVerification());
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
