package com.example.super_mall_demo.my.fragment;

import com.angle.mvplib.base.view.BaseSmartFramgent1;
import com.angle.mvplib.data.net.resposne.MvpResponse;
import com.example.super_mall_demo.R;

/**
 * Time: 2020/9/7  17:24
 * Author: Lenovo.pzb
 * Project: Super_Mall_Demo
 */
public class MyFragment extends BaseSmartFramgent1<Object> {
    @Override
    protected void initVeiw() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my;
    }

    @Override
    public void onResult(MvpResponse<Object> data) {

    }
}
