package com.pythoncat.h5.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

import com.apkfuns.logutils.LogUtils;
import com.pythoncat.h5.R;
import com.pythoncat.h5.base.BaseActivity;
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
        etName.clearFocus();
    }

    @OnClick(R.id.btn_load_h5)
    public void loadH5(View v) {
        ToastHelper.showShort("load h5.....");
        Intent intent = new Intent(get(), WebActivity.class);
        intent.putExtra("html", "file:///android_asset/showJsCallJava.html");
        startActivity(intent);
    }

    @OnClick(R.id.btn_submit_info)
    public void submitInfo(View v) {
        String info = etName.getText().toString().trim();
        if (TextUtils.isEmpty(info)) {
            ToastHelper.showShort("没有填任何信息.,不能提交信息！");
        } else {
            String url = "javascript:setInfo(" + "'" + info + "'" + ")";
//            javascript:setInfo('发达地区')
            LogUtils.e(url);
            wv.loadUrl(url);
            setContentView(wv);
            closeKeyBoard(etName);
        }

    }

    private void closeKeyBoard(EditText etName) {
        InputMethodManager inputmanger = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputmanger.hideSoftInputFromWindow(etName.getWindowToken(), 0);
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
//        wv.addJavascriptInterface(new JsObject(), "js2android");
        wv.loadUrl("file:///android_asset/info_details.html"); // 换了一个html了。
        return wv;
    }
}
