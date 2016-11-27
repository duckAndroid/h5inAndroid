package com.pythoncat.h5.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.pythoncat.h5.R;
import com.pythoncat.h5.base.BaseActivity;
import com.pythoncat.h5.js.JsObject;
import com.pythoncat.h5.utils.ToastHelper;

import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    private WebView wv;

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
        setContentView(wv);
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
        wv.loadUrl("file:///android_asset/showJsCallJava.html");
        return wv;
    }


}
