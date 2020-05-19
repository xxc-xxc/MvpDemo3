package com.xxc.mvpdemo3.mvp.contract;

import com.xxc.mvpdemo3.bean.BaseObjectBean;
import com.xxc.mvpdemo3.bean.UserBean;

import io.reactivex.Flowable;

public interface MainContract {

    interface IMainModel extends IContract.IModel {
        Flowable<BaseObjectBean<UserBean>> login(String username, String password);
    }

    interface IMainView extends IContract.IView {
        // 可以追加基类没有的方法
    }

    interface IMainPresenter extends IContract.IPresenter {
        void login(String username, String password);
    }

}
