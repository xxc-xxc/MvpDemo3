package com.xxc.mvpdemo3.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.xxc.mvpdemo3.R;
import com.xxc.mvpdemo3.mvp.contract.MainContract;
import com.xxc.mvpdemo3.mvp.presenter.MainPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseMvpActivity<MainPresenter> implements MainContract.IMainView {

    @BindView(R.id.tv)
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void initView() {
        mPresenter = new MainPresenter();
        mPresenter.attachView(this);
    }

    @OnClick(R.id.tv)
    public void onViewClicked() {
        mPresenter.login("xxc", "123");
    }
}
