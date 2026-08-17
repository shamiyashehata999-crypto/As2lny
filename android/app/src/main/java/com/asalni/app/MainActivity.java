package com.asalni.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import com.asalni.app.utils.TokenManager;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    private TokenManager tokenManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tokenManager = new TokenManager(this);
        webView = findViewById(R.id.webView);
        setupWebView();
        loadApplication();
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void setupWebView() {
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setAllowFileAccess(false);
        settings.setAllowContentAccess(false);
        settings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        settings.setUserAgentString(settings.getUserAgentString() + " AsalniAndroid/4.0");

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                injectToken();
            }
        });

        webView.addJavascriptInterface(new NativeInterface(this, tokenManager), "NativeApp");
    }

    private void injectToken() {
        String token = tokenManager.getToken();
        if (token != null) {
            String js = "javascript:window.localStorage.setItem('token', '" + token + "');";
            webView.evaluateJavascript(js, null);
        }
    }

    private void loadApplication() {
        String apiBase = BuildConfig.API_BASE;
        webView.loadUrl(apiBase);
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
