package com.jarry.jchat.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.jarry.jchat.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 索引
 * Created by Jarry on 2018/3/2.
 */

public class IndexLinearLayout extends LinearLayout {
    private int count;
    private int currentIndex = -1;
    private List<ImageView> imageViews = new ArrayList<>();

    public IndexLinearLayout(Context context) {
        super(context);
    }

    public IndexLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public IndexLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setCount(int count) {
        if (count < 1) return;
        imageViews.clear();
        this.count = count;
        for (int i = 0; i < count; i++) {
            ImageView imageView = new ImageView(getContext());
            LayoutParams layoutParams = new LayoutParams(20, 20);
            layoutParams.setMargins(20, 20, 20, 20);
            imageView.setLayoutParams(layoutParams);
            imageView.setBackground(getContext().getDrawable(i == 0 ? R.drawable.shape_index_green : R.drawable.shape_index_gray));
            addView(imageView);
            imageViews.add(imageView);
        }
        currentIndex = 0;
    }

    public void setCurrent(int index) {
        if (index == currentIndex || count < index || index < 0) return;
        //先把之前的还原
        ImageView oldImg = imageViews.get(currentIndex);
        oldImg.setBackground(getContext().getDrawable(R.drawable.shape_index_gray));
        currentIndex = index;
        ImageView imageView = imageViews.get(index);
        imageView.setBackground(getContext().getDrawable(R.drawable.shape_index_green));
    }

    public int getCurrent() {
        return currentIndex;
    }
}
