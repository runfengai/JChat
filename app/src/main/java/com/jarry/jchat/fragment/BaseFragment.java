package com.jarry.jchat.fragment;


import android.app.ProgressDialog;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.jarry.jchat.base.BasePresenter;
import com.jarry.jchat.base.BaseView;

/**
 * Created by Jarry on 2018/2/28.
 */

public class BaseFragment<DB extends ViewDataBinding, T extends BasePresenter> extends Fragment implements BaseView {
    protected DB binding;
    private ProgressDialog progressDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setCancelable(false);
    }

    @Override
    public void showLoading(String msg) {
        if (progressDialog != null) {
            progressDialog.setMessage(msg);
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
        Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
    }

}
