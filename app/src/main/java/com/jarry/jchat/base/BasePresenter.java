package com.jarry.jchat.base;

import java.lang.ref.WeakReference;

/**
 * Created by Jarry on 2018/3/25.
 */

public class BasePresenter<V extends BaseView> {
    private WeakReference<V> mViews;

    public void attachView(V view) {
        mViews = new WeakReference<V>(view);
    }

    public void detachView() {
        if (mViews != null) {
            mViews.clear();
            mViews = null;
        }
    }

    public V getView() {
        return isViewAttached() ? mViews.get() : null;
    }

    public boolean isViewAttached() {
        return mViews != null && mViews.get() != null;
    }
}
