package com.jarry.jchat.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import com.jarry.jchat.R;
import com.jarry.jchat.fragment.IndexFragment;
import com.jarry.jchat.model.IndexFrag;
import com.jarry.jchat.ui.IndexActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jarry on 2018/2/28.
 */

public class IndexPagerAdapter extends FragmentPagerAdapter {
    private IndexActivity mContext;
    private List<IndexFragment> fragmentList = new ArrayList<>();

    public IndexPagerAdapter(IndexActivity activity) {
        super(activity.getSupportFragmentManager());
        mContext = activity;
        fragmentList.add(IndexFragment.newInstance(activity.getString(R.string.index_1_title), activity.getString(R.string.index_1_desc), R.mipmap.index_1));
        fragmentList.add(IndexFragment.newInstance(activity.getString(R.string.index_2_title), activity.getString(R.string.index_2_desc), R.mipmap.index_2));
        fragmentList.add(IndexFragment.newInstance(activity.getString(R.string.index_3_title), activity.getString(R.string.index_3_desc), R.mipmap.index_3));
        fragmentList.add(IndexFragment.newInstance(activity.getString(R.string.index_4_title), activity.getString(R.string.index_4_desc), R.mipmap.index_4));
        fragmentList.add(IndexFragment.newInstance(activity.getString(R.string.index_5_title), activity.getString(R.string.index_5_desc), R.mipmap.index_5));
        fragmentList.add(IndexFragment.newInstance(activity.getString(R.string.index_6_title), activity.getString(R.string.index_6_desc), R.mipmap.index_6));
        fragmentList.add(IndexFragment.newInstance(activity.getString(R.string.index_7_title), activity.getString(R.string.index_7_desc), R.mipmap.index_7));
    }


    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
