package com.pythoncat.h5.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.pythoncat.h5.R;
import com.pythoncat.h5.base.BaseActivity;
import com.pythoncat.h5.js.JsObject;

import butterknife.BindView;

public class WebActivity extends BaseActivity {

    @BindView(R.id.wv_web_view)
    WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        bindBufferKnife2Self();
        initWebView();
        Intent intent = getIntent();
        String html = intent.getStringExtra("html");
        wv.loadUrl(html);
    }

    @NonNull
    private WebView initWebView() {
        WebSettings webSettings = wv.getSettings();
        webSettings.setUseWideViewPort(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setJavaScriptEnabled(true);
        wv.setNetworkAvailable(true);
        wv.setWebViewClient(new WebViewClient());
//        javascript:js2android.openCamera();
        wv.addJavascriptInterface(new JsObject(), "js2android");
        return wv;
    }
}
