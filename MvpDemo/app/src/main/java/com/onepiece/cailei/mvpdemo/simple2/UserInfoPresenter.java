package com.onepiece.cailei.mvpdemo.simple2;

import com.onepiece.cailei.mvpdemo.simple2.Base.BasePresenter;

public class UserInfoPresenter extends BasePresenter<UserInfoContract.UserInfoView> implements
        UserInfoContract.UserInfoPresenter {
    //p层一定要持有V层和M层的引用

    private UserInfoContract.UserInfoModel model;

    public UserInfoPresenter() {

        model = new UserInfoModel();
    }


    @Override
    public void getUser(String token) {
        getView().onLoading();
        model.getUser(token, new CallBack() {
            @Override
            public void onSuccess() {
                if (getView() != null) {
                    getView().loadSucess();
                }
            }

            @Override
            public void onFailed() {
                if (getView() != null) {
                    getView().loadFailed();
                }

            }
        });
    }
}
