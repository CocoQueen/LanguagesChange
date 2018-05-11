package com.coco.languageschange.base;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.coco.languageschange.utils.LocalManageUtils;

/**
 * Created by ydx on 18-5-11.
 */

public class BaseActivity extends AppCompatActivity{
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocalManageUtils.setLocale(newBase));

    }
}
