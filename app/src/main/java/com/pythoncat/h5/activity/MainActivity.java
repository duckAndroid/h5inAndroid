package com.pythoncat.h5.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

import com.apkfuns.logutils.LogUtils;
import com.pythoncat.h5.R;
import com.pythoncat.h5.base.BaseActivity;
import com.pythoncat.h5.js.JsObject;
import com.pythoncat.h5.utils.ToastHelper;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    private WebView wv;

    @BindView(R.id.et_self_name)
    EditText etName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindBufferKnife2Self();
        wv = loadWebView();
    }

    @OnClick(R.id.btn_load_h5)
    public void loadH5(View v) {
        ToastHelper.showShort("load h5.....");
        wv.loadUrl("file:///android_asset/showJsCallJava.html");
        setContentView(wv);
    }

    @OnClick(R.id.btn_submit_info)
    public void submitInfo(View v) {
        String info = etName.getText().toString().trim();
        if (TextUtils.isEmpty(info)) {
            ToastHelper.showShort("没有填任何信息.,不能提交信息！");
        } else {
//            wv.loadUrl("file:///android_asset/info_details.html"); // 换了一个html了。
//            setContentView(wv);
            //　todo --> 怎么把数据给js???

            String url = "javascript:setInfo(" + "'" + info + "'" + ")";
//            javascript:setInfo('发达地区')
            LogUtils.e(url);
            wv.loadUrl(url);
            setContentView(wv);
        }

    }

    @NonNull
    private WebView loadWebView() {
        WebView wv = new WebView(this);
        WebSettings webSettings = wv.getSettings();
        webSettings.setUseWideViewPort(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setJavaScriptEnabled(true);
        wv.setNetworkAvailable(true);
        wv.setWebViewClient(new WebViewClient());
//        javascript:js2android.openCamera();
        wv.addJavascriptInterface(new JsObject(), "js2android");
        wv.loadUrl("file:///android_asset/info_details.html"); // 换了一个html了。
        return wv;
    }

    @Override
    public void onBackPressed() {
        if (wv.canGoBack()) {
            wv.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
