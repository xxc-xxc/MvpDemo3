package com.xxc.mvpdemo3.mvp.presenter;

import com.xxc.mvpdemo3.bean.BaseObjectBean;
import com.xxc.mvpdemo3.bean.UserBean;
import com.xxc.mvpdemo3.mvp.contract.MainContract;
import com.xxc.mvpdemo3.mvp.model.MainModel;
import com.xxc.mvpdemo3.util.RxScheduler;

import io.reactivex.functions.Consumer;

public class MainPresenter extends BasePresenter<MainContract.IMainView, MainContract.IMainModel> implements MainContract.IMainPresenter {

    public MainPresenter() {
        model = new MainModel();
    }

    @Override
    public void login(String username, String password) {
        // View是否绑定，如果没有绑定，则不执行网络请求
        if (!isViewAttached()) {
            return;
        }
        view.showLoading();
        model.login(username, password)
                .compose(RxScheduler.<BaseObjectBean<UserBean>>flowableIOMain())
                .as(view.<BaseObjectBean<UserBean>>bindAutoDispose())
                .subscribe(new Consumer<BaseObjectBean<UserBean>>() {
                    @Override
                    public void accept(BaseObjectBean<UserBean> userBeanBaseObjectBean) throws Exception {

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }
}
