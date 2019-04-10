package com.onepiece.cailei.mvpdemo.simple2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.onepiece.cailei.mvpdemo.R;
import com.onepiece.cailei.mvpdemo.simple2.Base.BaseMvpActivity;

public class MainActivity extends BaseMvpActivity<UserInfoPresenter> implements UserInfoContract.UserInfoView {

    @Override
    protected UserInfoPresenter creatPresenter() {
        return new UserInfoPresenter();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    public void onLoading() {
     getPresenter().getUser("www.vaasffd.sfs");
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
    }
}
