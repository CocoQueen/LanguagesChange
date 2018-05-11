package com.coco.languageschange.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import com.coco.languageschange.utils.LocalManageUtils;

/**
 * Created by ydx on 18-5-11.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LocalManageUtils.setAppLanguage(this);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        LocalManageUtils.onConfigChange(getApplicationContext());
    }

    @Override
    protected void attachBaseContext(Context base) {
        LocalManageUtils.saveSysCurLan(base);
        super.attachBaseContext(LocalManageUtils.setLocale(base));
    }
}
