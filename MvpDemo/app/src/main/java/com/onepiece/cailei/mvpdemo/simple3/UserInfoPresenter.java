package com.onepiece.cailei.mvpdemo.simple3;

import com.onepiece.cailei.mvpdemo.simple3.Base.BasePresenter;

public class UserInfoPresenter extends BasePresenter<MainActivity,UserInfoModel> implements
        UserInfoContract.UserInfoPresenter {
    //p层一定要持有V层和M层的引用

//    private UserInfoContract.UserInfoModel model;

    public UserInfoPresenter() {

//        model = new UserInfoModel();
    }


    @Override
    public void getUser(String token) {
        getView().onLoading();
        getmModel().getUser(token, new CallBack() {
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
