package com.onepiece.cailei.mvpdemo.simple2;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class UserInfoModel implements UserInfoContract.UserInfoModel {


    @Override
    public UserInfo getUser(String token, final CallBack callBack) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        Request request = new Request.Builder().url("www.baidu.com").build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callBack.onFailed();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                callBack.onSuccess();
            }
        });

        return null;
    }
}
