package com.onepiece.cailei.mvpdemo.simple2.Base;


import com.onepiece.cailei.mvpdemo.simple2.UserInfoContract;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BasePresenter<V extends BaseView> {


    private WeakReference<V> mViewReference;
    private V mProxyView;

    public void onAttach(V view) {
        this.mViewReference = new WeakReference<V>(view);
        mProxyView = (V) Proxy.newProxyInstance(view.getClass().getClassLoader(), view.getClass()
                .getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (mViewReference == null || mViewReference.get() == null) {
                    return null;
                }
                return method.invoke(mViewReference.get(), args);
            }
        });

    }

    public void onDetach() {
        this.mViewReference.clear();
        this.mProxyView = null;
        this.mViewReference = null;
    }

    public V getView() {
        return this.mProxyView;
    }
}
