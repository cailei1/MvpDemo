package com.onepiece.cailei.mvpdemo.simple3.Base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.onepiece.cailei.mvpdemo.simple3.inject.InjectPresenter;

import java.lang.reflect.Field;

public abstract class BaseMvpActivity<P extends BasePresenter> extends AppCompatActivity
        implements BaseView {
    private P presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = creatPresenter();
        presenter.onAttach(this);



        Field[] fields=this.getClass().getDeclaredFields();
        for (Field field : fields) {
            if(field!=null){
               InjectPresenter injectPresenter= field.getAnnotation(InjectPresenter.class);
               if(injectPresenter!=null){
                   //创建presenter对象
                   try {
                       Class<? extends BasePresenter> presentClazz = (Class<? extends BasePresenter>) field.getType();
                       BasePresenter basePresenter=presentClazz.newInstance();
                       basePresenter.onAttach(this);
                       field.setAccessible(true);
                       field.set(this,basePresenter);

                   }catch (Exception e){
                       e.printStackTrace();
                   }

               }
            }
        }
        initView();
        initData();
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
