package com.jarry.jchat.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by Jarry on 2018/3/25.
 */

public abstract class BaseActivity<DB extends ViewDataBinding, T extends BasePresenter> extends AppCompatActivity implements BaseView {
    protected DB binding;
    protected BaseActivity self;

    protected abstract int setLayoutId();

    protected abstract void initData(@Nullable Bundle savedInstanceState);

    protected abstract void initView();

    protected abstract void setListener();

    protected abstract void loadData();

    private ProgressDialog progressDialog;

    protected T mPresenter;

    protected abstract T createPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (binding == null)
            setContentView(setLayoutId());
        self = this;
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);

        mPresenter = createPresenter();
        if (mPresenter != null)
            mPresenter.attachView(this);


        initData(savedInstanceState);
        initView();
        setListener();
        loadData();
    }

    @Override
    protected void onDestroy() {
        self = null;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
        super.onDestroy();
    }

    @Override
    public void showLoading(String msg) {
        if (progressDialog != null) {
            progressDialog.show();
        }
    }

    @Override
    public void closeLoading() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.hide();
        }
    }

    @Override
    public void showDialog(String msg) {

    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public Context getContext() {
        return this;
    }
}
