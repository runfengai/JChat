package com.jarry.jchat;

import android.app.Activity;
import android.app.Application;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jarry on 2018/2/25.
 */

public class App extends Application {
    private static App instance = null;
    private static List<Activity> list = new ArrayList<>();

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static void addAct(Activity act) {
        list.add(act);
    }

    public static void removeAct(Activity act) {
        list.remove(act);
    }

    public static void exit() {
        for (Activity act : list) {
            act.finish();
        }
    }
}
