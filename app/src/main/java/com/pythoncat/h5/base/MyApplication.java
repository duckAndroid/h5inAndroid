package com.pythoncat.h5.base;

import android.app.Application;

import com.pythoncat.h5.utils.App;


/**
 * Created by pythonCat on 2016/11/25 0025.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        App.set(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        App.set(null);
    }
}
