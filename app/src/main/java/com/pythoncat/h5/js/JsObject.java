package com.pythoncat.h5.js;

import android.content.Intent;
import android.net.Uri;
import android.webkit.JavascriptInterface;

import com.pythoncat.h5.utils.App;
import com.pythoncat.h5.utils.ToastHelper;

/**
 * Created by pythonCat on 2016/11/27 0027.
 *
 * @apiNote js object ---> 允许js 调用 java 代码 的 接口类
 */

public class JsObject {

    @JavascriptInterface
    public void openCamera() {

        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        App.get().startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }

    /**
     * 在js 中定义同名的函数即可- 让js 调用当前函数
     */
    @JavascriptInterface
    public void showToast() {
        ToastHelper.showShort("我是android代码，我被js 调用了.......");
    }

    @JavascriptInterface
    public void openVideo(String url) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.parse(url), "video/*");
        App.get().startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }
}
