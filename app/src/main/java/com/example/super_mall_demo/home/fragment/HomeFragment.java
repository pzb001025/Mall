package com.example.super_mall_demo.home.fragment;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.angle.mvplib.base.view.BaseSmartFramgent1;
import com.angle.mvplib.common.Constarct;
import com.angle.mvplib.data.net.request.GetRequset;
import com.angle.mvplib.data.net.resposne.MvpResponse;
import com.angle.mvplib.util.ParamsUtils;
import com.bumptech.glide.Glide;
import com.example.super_mall_demo.R;
import com.example.super_mall_demo.databinding.FragmentHomeBinding;
import com.example.super_mall_demo.home.entity.ContentData;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends BaseSmartFramgent1<ContentData> {

    private FragmentHomeBinding root;

    @Override
    protected void initVeiw() {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void bindingView(View view) {
        super.bindingView(view);
        root = FragmentHomeBinding.bind(view);
        GetRequset<ContentData> requset = new GetRequset<>(Constarct.URL.CONTENT);
        requset.setParams(ParamsUtils.getCommonParams());
        requset.setType(ContentData.class);
        doRequest(requset);
    }

    @Override
    public void onResult(MvpResponse<ContentData> data) {
        if (data.getCode() == 200) {
            List<ContentData.AdvertiseListBean> advertiseList = data.getData().getAdvertiseList();
            List<String> images = new ArrayList<>();
            for (int i = 0; i < advertiseList.size(); i++) {
                images.add(advertiseList.get(i).getPic());
            }
            root.banner.setImages(images).setImageLoader(new ImageLoad()).start();
        }
    }

    class ImageLoad extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    }
}