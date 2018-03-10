package com.jarry.jchat.ui;

import android.app.ActivityOptions;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.eftimoff.androipathview.PathView;
import com.jarry.jchat.App;
import com.jarry.jchat.R;
import com.jarry.jchat.databinding.ActivityWelcomeBinding;
import com.jarry.jchat.model.Welcome;

public class WelcomeActivity extends BaseActivity {
    private ActivityWelcomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_welcome);
        Welcome welcome = new Welcome("JChat");
        binding.setWel(welcome);
        final PathView pathView = (PathView) findViewById(R.id.pathView);

        pathView.getPathAnimator().
                delay(100).
                duration(1000).
                interpolator(new AccelerateDecelerateInterpolator()).
                start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(self, IndexActivity.class));
                finish();
            }
        }, 2000);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        App.exit();
    }
}
