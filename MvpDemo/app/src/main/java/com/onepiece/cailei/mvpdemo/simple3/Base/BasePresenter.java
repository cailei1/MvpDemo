package com.onepiece.cailei.mvpdemo.simple3.Base;


import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;

public class BasePresenter<V extends BaseView,M extends BaseModel> {

    private M mModel;
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
        //动态创建model
        Type genType=mModel.getClass().getGenericSuperclass();
        Type[] params=((ParameterizedType)genType).getActualTypeArguments();

        try{
            mModel=(M)((Class)params[1]).newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void onDetach() {
        this.mViewReference.clear();
        this.mProxyView = null;
        this.mViewReference = null;
    }

    public V getView() {
        return this.mProxyView;
    }

    public M getmModel(){
        return this.mModel;
    }
}
