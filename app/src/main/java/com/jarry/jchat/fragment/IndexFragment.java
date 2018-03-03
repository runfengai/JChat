package com.jarry.jchat.fragment;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.elvishew.xlog.XLog;
import com.jarry.jchat.BR;
import com.jarry.jchat.R;
import com.jarry.jchat.model.IndexFrag;

/**
 * Created by Jarry on 2018/2/28.
 */

public class IndexFragment extends BaseFragment {
    private IndexFrag indexFrag;

    public static IndexFragment newInstance(String title, String description, int imgSrc) {
        Bundle args = new Bundle();
        args.putString("title", title);
        args.putString("description", description);
        args.putInt("imgSrc", imgSrc);
        IndexFragment fragment = new IndexFragment();
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
        indexFrag =
                new IndexFrag(getArguments().getString("title"), getArguments().getString("description"), getActivity().getDrawable(getArguments().getInt("imgSrc")));
        XLog.d(indexFrag);
        ViewDataBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_index1, container, false);
        binding.setVariable(BR.indexFrag, indexFrag);
        return binding.getRoot();
    }
}
