package com.xxc.mvpdemo3.api;

import com.xxc.mvpdemo3.bean.BaseObjectBean;
import com.xxc.mvpdemo3.bean.UserBean;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {

    /**
     * 登录请求
     * @param username 账号
     * @param password 密码
     * @return
     */
    @FormUrlEncoded
    @POST("user/login")
    Flowable<BaseObjectBean<UserBean>> login(@Field("username") String username, @Field("password") String password);

}
