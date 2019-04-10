package com.onepiece.cailei.mvpdemo.simple3;

import com.onepiece.cailei.mvpdemo.simple3.Base.BaseMvpActivity;
import com.onepiece.cailei.mvpdemo.simple3.inject.InjectPresenter;

//这个地方的泛型方便1对1可以留着
public class MainActivity extends BaseMvpActivity<UserInfoPresenter> implements UserInfoContract.UserInfoView {
    @InjectPresenter
    private UserInfoPresenter userInfoPresenter;
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
