package com.jarry.jchat.ui.chat.fragment;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.elvishew.xlog.XLog;
import com.jarry.jchat.BR;
import com.jarry.jchat.R;
import com.jarry.jchat.databinding.FragmentChatBinding;
import com.jarry.jchat.fragment.BaseFragment;
import com.jarry.jchat.model.ChatInfo;

/**
 * Created by Jarry on 2018/2/28.
 */

public class ChatFragment extends BaseFragment<FragmentChatBinding, ChatFPresenter> {
    private ChatInfo chatInfo;
//    private FragmentChatBinding binding;

    public static ChatFragment newInstance(String title, String description, int imgSrc) {
        Bundle args = new Bundle();
        args.putString("title", title);
        args.putString("description", description);
        args.putInt("imgSrc", imgSrc);
        ChatFragment fragment = new ChatFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        chatInfo = new ChatInfo();
        XLog.d(chatInfo);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_chat, container, false);
        binding.setVariable(BR.indexFrag, chatInfo);
        return binding.getRoot();
    }
}
