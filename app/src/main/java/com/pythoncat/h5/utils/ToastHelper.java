package com.pythoncat.h5.utils;

import android.widget.Toast;

/**
 * Created by pythonCat on 2016/11/25 0025.
 */

public class ToastHelper {

    private static Toast mToast;

    public static void showShort(CharSequence ch) {
        if (mToast == null) {
            mToast = Toast.makeText(App.get(), ch, Toast.LENGTH_SHORT);
        } else {
            cancel();
            mToast = Toast.makeText(App.get(), ch, Toast.LENGTH_SHORT);
        }
        mToast.show();
    }

    public static void cancel() {
        if (mToast != null) {
            mToast.cancel();
        }
    }
}
