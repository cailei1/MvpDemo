package com.onepiece.cailei.mvpdemo.simple2.Base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseMvpActivity<P extends BasePresenter> extends AppCompatActivity
        implements BaseView {
    private P presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        presenter = creatPresenter();
        presenter.onAttach(this);
    }

    protected abstract P creatPresenter();

    protected abstract void initData();

    protected abstract void initView();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDetach();
    }

    public P getPresenter() {
        return this.presenter;
    }
}
