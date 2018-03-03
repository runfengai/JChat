package com.jarry.jchat.ui;

import android.databinding.DataBindingUtil;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.jarry.jchat.R;
import com.jarry.jchat.adapter.IndexPagerAdapter;
import com.jarry.jchat.databinding.ActivityIndexBinding;
import com.jarry.jchat.model.Index;

/**
 * 引导页
 */
public class IndexActivity extends AppCompatActivity {
    private ActivityIndexBinding binding;
    private FragmentPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_index);
        Index index = new Index();
        binding.setIndex(index);
        adapter = new IndexPagerAdapter(this);

        binding.viewPager.setAdapter(adapter);
        binding.viewPager.setOffscreenPageLimit(5);
        binding.indexLin.setCount(7);
        binding.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                binding.indexLin.setCurrent(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
