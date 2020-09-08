package com.example.super_mall_demo.app;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;

import com.angle.mvplib.manager.MvpManager;
import com.angle.mvplib.util.MvpConfig;
import com.angle.mvplib.util.ParamsUtils;
import com.example.super_mall_demo.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;

import java.util.HashMap;

public class MallApplication extends Application {
    private static MallApplication mallApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        MvpConfig mvpConfig = new MvpConfig(this, new MvpConfig.ParamsGetter() {
            @Override
            public HashMap<String, Object> getParams() {
                return ParamsUtils.getCommonParams();
            }
        });
        MvpManager.init(mvpConfig);
    }

   /* //static 代码段可以防止内存泄露
    static {
//   构造全局的刷新头
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                return (RefreshHeader) LayoutInflater.from(context).inflate(R.layout.layout_refresh_header, null, false);
            }
        });
//   构造全局的foot
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                return (RefreshFooter) LayoutInflater.from(context).inflate(R.layout.layout_refresh_footer, null, false);
            }
        });
    }*/

    public static MallApplication getMallApplication() {
        return mallApplication;
    }
}
