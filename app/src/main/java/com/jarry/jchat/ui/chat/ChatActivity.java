package com.jarry.jchat.ui.chat;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.jarry.jchat.R;
import com.jarry.jchat.base.BaseActivity;
import com.jarry.jchat.databinding.ActivityChatBinding;

public class ChatActivity extends BaseActivity<ActivityChatBinding, ChatPresenter> implements ChatContract.View {

    @Override
    protected int setLayoutId() {
        return R.layout.activity_chat;
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
    protected ChatPresenter createPresenter() {
        return new ChatPresenter();
    }
}
