package com.coco.languageschange.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import android.util.DisplayMetrics;

import com.coco.languageschange.R;

import java.util.Locale;

/**
 * Created by ydx on 18-5-11.
 */

public class LocalManageUtils {
    private static final String TAG = "LocalManageUtils";

    /**
     * 获取系统的locale
     *
     * @param context 上下文
     * @return locale对象
     */
    public static Locale getSystemLocal(Context context) {
        return Sputils.getInstance(context).getSystemCurrentLocal();
    }

    public static String getSelectLanguage(Context context) {
        switch (Sputils.getInstance(context).getSelectLanguage()) {
            case 0:
                return context.getString(R.string.language_auto);
            case 1:
                return context.getString(R.string.language_cn);
            default:
                return context.getString(R.string.language_en);
        }

    }

    public static void saveSelectLanguage(Context context, int select) {
        Sputils.getInstance(context).saveLanguage(select);
        setAppLanguage(context);
    }

    public static void setAppLanguage(Context context) {
        Resources resources = context.getApplicationContext().getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        Locale locale = getSetLanguageLocale(context);
        configuration.locale = locale;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            LocaleList localeList = new LocaleList(locale);
            LocaleList.setDefault(localeList);
            configuration.setLocales(localeList);
            context.getApplicationContext().createConfigurationContext(configuration);
            Locale.setDefault(locale);
        }
        resources.updateConfiguration(configuration, metrics);
    }

    public static Locale getSetLanguageLocale(Context context) {
        switch (Sputils.getInstance(context).getSelectLanguage()) {
            case 0:
                return getSystemLocal(context);
            case 1:
                return Locale.CHINA;
            default:
                return Locale.ENGLISH;
        }
    }

    public static Context setLocale(Context context) {
        return updateResource(context, getSetLanguageLocale(context));
    }

    private static Context updateResource(Context context, Locale locale) {
        Locale.setDefault(locale);

        Resources resources = context.getResources();
        Configuration configuration = new Configuration(resources.getConfiguration());
        if (Build.VERSION.SDK_INT >= 17) {
            configuration.setLocale(locale);
            context = context.createConfigurationContext(configuration);
        } else {
            configuration.locale = locale;
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        }
        return context;
    }

    public static void saveSysCurLan(Context context) {
        Locale locale;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            locale = LocaleList.getDefault().get(0);
        } else {
            locale = Locale.getDefault();
        }
        Sputils.getInstance(context).setSystemCurrentLocal(locale);
    }

    public static void onConfigChange(Context context) {
        saveSysCurLan(context);
        setLocale(context);
        setAppLanguage(context);
    }
}
