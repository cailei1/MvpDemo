package com.onepiece.cailei.mvpdemo.simple1;

public class UserInfoContract {
    interface UserInfoView {
        //        1.正在加载中
//        2.加载失败
//        3.加载成功
        void onLoading();

        void loadFailed();

        void loadSucess();
    }

    interface UserInfoPresenter {
        void getUser(String token);
    }

    interface UserInfoModel {
        UserInfo getUser(String token,CallBack callBack) ;
    }
}
