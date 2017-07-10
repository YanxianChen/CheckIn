package edu.application.yancychan.checkin.utils;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by yancychan on 17-7-10.
 */
//与服务器交互工具类
public class HttpUtil {

    public static void sendOkHttpRequest(String address, okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }
}
