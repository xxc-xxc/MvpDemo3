package com.xxc.mvpdemo3.mvp.model;

import com.xxc.mvpdemo3.bean.BaseObjectBean;
import com.xxc.mvpdemo3.bean.UserBean;
import com.xxc.mvpdemo3.mvp.contract.MainContract;
import com.xxc.mvpdemo3.net.RetrofitClient;

import io.reactivex.Flowable;

public class MainModel implements MainContract.IMainModel {
    @Override
    public Flowable<BaseObjectBean<UserBean>> login(String username, String password) {
        return RetrofitClient.getInstance().getApi().login(username, password);
    }
}
