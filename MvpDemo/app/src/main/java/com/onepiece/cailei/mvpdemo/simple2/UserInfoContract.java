package com.onepiece.cailei.mvpdemo.simple2;

import com.onepiece.cailei.mvpdemo.simple2.Base.BasePresenter;
import com.onepiece.cailei.mvpdemo.simple2.Base.BaseView;

public class UserInfoContract {
    public interface UserInfoView extends BaseView{
        //        1.正在加载中
//        2.加载失败
//        3.加载成功
        void onLoading();

        void loadFailed();

        void loadSucess();
    }

    interface UserInfoPresenter{
        void getUser(String token);
    }

    interface UserInfoModel {
        UserInfo getUser(String token, CallBack callBack) ;
    }
}
