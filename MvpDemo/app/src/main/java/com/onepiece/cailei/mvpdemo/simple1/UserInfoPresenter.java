package com.onepiece.cailei.mvpdemo.simple1;

public class UserInfoPresenter implements UserInfoContract.UserInfoPresenter {
    //p层一定要持有V层和M层的引用
    private UserInfoContract.UserInfoView view;
    private UserInfoContract.UserInfoModel model;

    public UserInfoPresenter(UserInfoContract.UserInfoView view) {

        model = new UserInfoModel();
    }

    public void onAttach(UserInfoContract.UserInfoView view) {
        this.view = view;
    }


    public void onDetch() {
        this.view = null;
    }

    @Override
    public void getUser(String token) {
        view.onLoading();
        model.getUser(token, new CallBack() {
            @Override
            public void onSuccess() {
                view.loadSucess();
            }

            @Override
            public void onFailed() {
                view.loadFailed();
            }
        });
    }
}
