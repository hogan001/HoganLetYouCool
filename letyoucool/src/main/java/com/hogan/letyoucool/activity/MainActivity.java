package com.hogan.letyoucool.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hogan.letyoucool.R;
import com.hogan.letyoucool.application.AppManager;
import com.hogan.letyoucool.fragment.MeFragment;
import com.hogan.letyoucool.fragment.NewsFragment;
import com.hogan.letyoucool.fragment.WeatherFragment;
import com.hogan.letyoucool.toastLogUtils.ToastManager;
import com.hogan.letyoucool.url.ConstantValues;
import com.hogan.letyoucool.view.MyTabWidget;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements View.OnClickListener, MyTabWidget.OnTabSelectedListener {
    @Bind(R.id.iv_back)
    protected ImageView iv_back;
    @Bind(R.id.tv_center)
    protected TextView titleName;
    @Bind(R.id.tab_widget)
    protected MyTabWidget mTabWidget;

    private boolean isExit;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private int mIndex = ConstantValues.HOME_FRAGMENT_INDEX;
    private Fragment newsFragment, weatherFragment, meFragment;

    @Override
    protected void initView() {
        setContentView(R.layout.content_main);
        /**
         * 设置View后才能注册ButterKnife
         */
        ButterKnife.bind(this);
        mContext = this;
        iv_back.setOnClickListener(this);
        mFragmentManager = getSupportFragmentManager();
        mTabWidget.setOnTabSelectedListener(this);
        //add
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void onResume() {
        super.onResume();
        onTabSelected(mIndex);
        mTabWidget.setTabsDisplay(this, mIndex);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                AppManager.getInstance().finishActivity(this);
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // 自己记录fragment的位置,防止activity被系统回收时，fragment错乱的问题
        outState.putInt("index", mIndex);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mIndex = savedInstanceState.getInt("index");
    }

    @Override
    public void onTabSelected(int index) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        hideFragments(transaction);
        switch (index) {
            case ConstantValues.HOME_FRAGMENT_INDEX:
                if (null == newsFragment) {
                    newsFragment = new NewsFragment();
                    transaction.add(R.id.center_layout, newsFragment);
                } else {
                    transaction.show(newsFragment);
                }
                titleName.setText("新闻");
                break;
            case ConstantValues.NEWS_FRAGMENT_INDEX:
                if (null == weatherFragment) {
                    weatherFragment = new WeatherFragment();
                    transaction.add(R.id.center_layout, weatherFragment);
                } else {
                    transaction.show(weatherFragment);
                }
                titleName.setText("天气");
                break;
            case ConstantValues.PERSONAL_FRAGMENT_INDEX:
                if (null == meFragment) {
                    meFragment = new MeFragment();
                    transaction.add(R.id.center_layout, meFragment);
                } else {
                    transaction.show(meFragment);
                }
                titleName.setText("我的");
                break;


            default:
                break;
        }
        mIndex = index;
        transaction.commitAllowingStateLoss();
    }

    private void hideFragments(FragmentTransaction transaction) {
        if (null != newsFragment) {
            transaction.hide(newsFragment);
        }
        if (null != weatherFragment) {
            transaction.hide(weatherFragment);
        }
        if (null != meFragment) {
            transaction.hide(meFragment);
        }
    }


    /**
     * 双击退出函数
     */
    private void exitBy2Click() {
        Timer tExit = null;
        if (isExit == false) {
            isExit = true; // 准备退出
            ToastManager.showShortText(this, "再按一次退出程序");
            tExit = new Timer();
            tExit.schedule(new TimerTask() {
                @Override
                public void run() {
                    isExit = false; // 取消退出
                }
            }, 2000); // 如果2秒钟内没有按下返回键，则启动定时器取消掉刚才执行的任务

        } else {
            AppManager.getInstance().appExit(this);
        }
    }

    /**
     * 菜单、返回键响应
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitBy2Click(); // 调用双击退出函数
        }
        return false;
    }
}
