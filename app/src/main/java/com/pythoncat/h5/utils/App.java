package com.pythoncat.h5.utils;

import android.app.Application;

/**
 * Created by pythonCat on 2016/11/25 0025.
 */

public class App {

    private static Application mApp;

    public static void set(Application ap) {
        mApp = ap;
    }

    public static Application get() {
        return mApp;
    }

    public static String getString(int resId,Object... args) {
        return mApp.getString(resId,args);
    }
    public static String getString(int resId) {
        return mApp.getString(resId);
    }
}
