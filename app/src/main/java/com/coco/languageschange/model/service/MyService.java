package com.coco.languageschange.model.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.coco.languageschange.R;
import com.coco.languageschange.utils.LocalManageUtils;

/**
 * Created by ydx on 18-5-11.
 */

public class MyService extends IntentService{

    public MyService() {
        super("service");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(getApplicationContext(), getString(R.string.service_create), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocalManageUtils.setLocale(base));
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

    }
}
