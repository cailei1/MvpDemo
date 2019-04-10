package com.onepiece.cailei.mvpdemo.simple1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.onepiece.cailei.mvpdemo.R;

public class MainActivity extends AppCompatActivity implements UserInfoContract.UserInfoView {
    private UserInfoPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new UserInfoPresenter(this);
        presenter.onAttach(this);
        presenter.getUser("token");
    }

    @Override
    public void onLoading() {

    }

    @Override
    public void loadFailed() {

    }

    @Override
    public void loadSucess() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDetch();
    }
}
