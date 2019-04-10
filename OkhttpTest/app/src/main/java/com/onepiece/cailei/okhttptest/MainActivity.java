package com.onepiece.cailei.okhttptest;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;

import com.onepiece.cailei.Annotation.ViewById;
import com.onepiece.cailei.navigationbar.Navigationbar;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    @ViewById(R.id.parent)
    ViewGroup parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Navigationbar navigationbar = new Navigationbar.Builder(this,R.layout.tool_bar,parent ).create();

        AlertDialog dialog = new AlertDialog.Builder(this).setTitle("我是海贼王").show();

        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder().build();


        Call call = okHttpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                Log.e("TAG", result);
            }
        });
    }
}
