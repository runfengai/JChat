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
    private static List<Activity> list = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
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
