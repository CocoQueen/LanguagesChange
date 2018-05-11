package com.coco.languageschange.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Locale;

/**
 * Created by ydx on 18-5-11.
 */

public class Sputils {
    private final String SP_NAME="languages_setting";
    private final String TAG_LANGUAGE="language_select";
    private final String TAG_SYSTEM_LANGUAGE="system_language";

    private static volatile Sputils utils;

    private final SharedPreferences preferences;
    private Locale systemCurrentLocal=Locale.ENGLISH;

    public Sputils(Context context) {
        preferences=context.getSharedPreferences(SP_NAME,Context.MODE_PRIVATE);
    }
    public void saveLanguage(int select){
        SharedPreferences.Editor edit = preferences.edit();
        edit.putInt(TAG_LANGUAGE,select);
        edit.commit();
    }
    public int getSelectLanguage(){
        return preferences.getInt(TAG_LANGUAGE,0);
    }
    public Locale getSystemCurrentLocal(){
        return systemCurrentLocal;
    }
    public void setSystemCurrentLocal(Locale locale){
        systemCurrentLocal=locale;
    }
    public static Sputils getInstance(Context context){
        if (utils==null){
            synchronized (Sputils.class){
                if (utils==null){
                    utils=new Sputils(context);
                }
            }
        }
        return utils;
    }
}
