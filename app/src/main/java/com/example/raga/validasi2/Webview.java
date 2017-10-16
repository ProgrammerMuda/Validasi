package com.example.raga.validasi2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Webview extends AppCompatActivity {
    private WebView Varwebview;
    WebSettings Webset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        Varwebview=(WebView)findViewById(R.id.btnID);
        Webset=Varwebview.getSettings();
        Webset.setJavaScriptEnabled(true);

        Varwebview.setWebViewClient(new WebViewClient());
        Varwebview.loadUrl("https://github.com/codewireframming");

    }
}
