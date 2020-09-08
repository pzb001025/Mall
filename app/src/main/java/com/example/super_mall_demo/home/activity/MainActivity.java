package com.example.super_mall_demo.home.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.super_mall_demo.R;
import com.example.super_mall_demo.databinding.ActivityMainBinding;
import com.example.super_mall_demo.home.fragment.HomeFragment;
import com.example.super_mall_demo.my.fragment.MyFragment;
import com.example.super_mall_demo.sort.fragment.SortFragment;
import com.example.super_mall_demo.special.fragment.SpecialFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding root;
    private HomeFragment homeFragment;
    private SortFragment sortFragment;
    private SpecialFragment specialFragment;
    private MyFragment myFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        root = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(root.getRoot());

//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Window window = getWindow();
        window.getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#00000000"));
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        ViewGroup contentFrameLayout = (ViewGroup) findViewById(Window.ID_ANDROID_CONTENT);
        View parentView = contentFrameLayout.getChildAt(0);
        if (parentView != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        }

        initView();
    }

    private void initView() {
        root.toolbar.setTitle("");
        setSupportActionBar(root.toolbar);

        initTab();

        //消息题醒
        root.ivWake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "题醒", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initTab() {
        homeFragment = new HomeFragment();
        sortFragment = new SortFragment();
        specialFragment = new SpecialFragment();
        myFragment = new MyFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fl, homeFragment)
                .add(R.id.fl, sortFragment)
                .add(R.id.fl, specialFragment)
                .add(R.id.fl, myFragment).commit();

        getSupportFragmentManager()
                .beginTransaction()
                .show(homeFragment)
                .hide(sortFragment)
                .hide(specialFragment)
                .hide(myFragment).commit();

        root.tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        fragmentHideAll();
                        getSupportFragmentManager().beginTransaction().show(homeFragment).commit();
                        break;
                    case 1:
                        fragmentHideAll();
                        getSupportFragmentManager().beginTransaction().show(sortFragment).commit();
                        break;
                    case 2:
                        fragmentHideAll();
                        getSupportFragmentManager().beginTransaction().show(specialFragment).commit();
                        break;
                    case 3:
                        fragmentHideAll();
                        getSupportFragmentManager().beginTransaction().show(myFragment).commit();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void fragmentHideAll() {
        getSupportFragmentManager().beginTransaction().hide(homeFragment).commit();
        getSupportFragmentManager().beginTransaction().hide(sortFragment).commit();
        getSupportFragmentManager().beginTransaction().hide(specialFragment).commit();
        getSupportFragmentManager().beginTransaction().hide(myFragment).commit();
    }

    //选项菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //选项菜单点击事件
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search:
                Toast.makeText(this, "搜索", Toast.LENGTH_SHORT).show();
                break;
            case R.id.gouwuche:
                Toast.makeText(this, "购物车", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}