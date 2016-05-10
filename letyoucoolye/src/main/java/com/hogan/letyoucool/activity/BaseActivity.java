package com.hogan.letyoucool.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.hogan.letyoucool.application.AppManager;


/**
 * 作者：hogan
 * 时间: 2016/5/8 18:37
 * 描述：
 **/
public abstract class BaseActivity extends AppCompatActivity {
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        mContext=this;
        AppManager.getInstance().addActivity(this);
        initView();
        initData();
    }


    /**
     * 抽象方法子类必须实现
     */
    protected abstract void initView();

    protected abstract void initData();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getInstance().finishActivity(this);
    }
}
