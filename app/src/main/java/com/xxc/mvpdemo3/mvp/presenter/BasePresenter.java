package com.xxc.mvpdemo3.mvp.presenter;

import com.xxc.mvpdemo3.mvp.contract.IContract;

public class BasePresenter<V extends IContract.IView, M extends IContract.IModel> {

    protected V view;
    protected M model;

    /**
     * 绑定view，一般在初始化中调用该方法
     * @param view
     */
    public void attachView(V view) {
        this.view = view;
    }

    /**
     * 解除绑定view，一般在onDestroy中调用
     */
    public void detachView() {
        this.view = null;
    }

    /**
     * View是否绑定
     * @return
     */
    public boolean isViewAttached() {
        return view != null;
    }

}
