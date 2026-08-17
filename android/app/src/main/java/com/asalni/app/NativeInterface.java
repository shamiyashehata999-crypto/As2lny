package com.asalni.app;

import android.app.Activity;
import android.webkit.JavascriptInterface;
import android.widget.Toast;
import com.asalni.app.utils.TokenManager;
import com.asalni.app.api.ApiClient;
import org.json.JSONObject;

public class NativeInterface {
    private Activity activity;
    private TokenManager tokenManager;
    private ApiClient apiClient;

    public NativeInterface(Activity activity, TokenManager tokenManager) {
        this.activity = activity;
        this.tokenManager = tokenManager;
        this.apiClient = new ApiClient(tokenManager);
    }

    @JavascriptInterface
    public void saveToken(String token) {
        tokenManager.saveToken(token);
    }

    @JavascriptInterface
    public String getToken() {
        return tokenManager.getToken();
    }

    @JavascriptInterface
    public void logout() {
        tokenManager.clearToken();
        showToast("تم تسجيل الخروج");
    }

    @JavascriptInterface
    public void showToast(String message) {
        activity.runOnUiThread(() ->
            Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
        );
    }

    @JavascriptInterface
    public String getDeviceInfo() {
        try {
            JSONObject info = new JSONObject();
            info.put("model", android.os.Build.MODEL);
            info.put("manufacturer", android.os.Build.MANUFACTURER);
            info.put("osVersion", android.os.Build.VERSION.RELEASE);
            info.put("appVersion", "4.0.0");
            return info.toString();
        } catch (Exception e) {
            return "{}";
        }
    }
}
