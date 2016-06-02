package com.hogan.letyoucool.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.hogan.letyoucool.R;
import com.hogan.letyoucool.toastLogUtils.LogUtil;

import net.youmi.android.AdManager;
import net.youmi.android.spot.SplashView;
import net.youmi.android.spot.SpotDialogListener;
import net.youmi.android.spot.SpotManager;

import butterknife.ButterKnife;

/**
 * 作者: 陈虎
 * 日期: 2016/5/9  14:37
 * 描述: 主界面
 */
public class StartUpActivity extends BaseActivity {
    private Context mContext;

    @Override
    protected void initView() {
        setContentView(R.layout.login_activity);
        ButterKnife.bind(this);
        mContext = this;
        AdManager.getInstance(this).init("d98c71de538cb906", "6c208b9be3d7b608", true);
    }

    @Override
    protected void initData() {
        setupSplashAd();
    }

    /**
     * 设置开屏广告
     */
    private void setupSplashAd() {

        /** 自定义模式*/
        SplashView splashView = new SplashView(this, null);
        // 设置是否显示倒计时，默认显示
        splashView.setShowReciprocal(true);
        // 设置是否显示关闭按钮，默认不显示
        splashView.hideCloseBtn(true);
        //传入跳转的intent，若传入intent，初始化时目标activity应传入null
        Intent intent = new Intent(this, MainActivity.class);
        splashView.setIntent(intent);
        //展示失败后是否直接跳转，默认直接跳转
        splashView.setIsJumpTargetWhenFail(true);
        //获取开屏视图
        View splash = splashView.getSplashView();

        final RelativeLayout splashLayout = (RelativeLayout) findViewById(R.id.rl_splash);
        //		splashLayout.setVisibility(View.GONE);
        //添加开屏视图到布局中
        RelativeLayout.LayoutParams params =
                new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        params.addRule(RelativeLayout.ABOVE, R.id.view_divider);
        splashLayout.addView(splash, params);
        //显示开屏
        SpotManager.getInstance(mContext)
                .showSplashSpotAds(mContext, splashView, new SpotDialogListener() {

                    @Override
                    public void onShowSuccess() {
                        LogUtil.e("开屏展示成功");
                        splashLayout.setVisibility(View.VISIBLE);
                        splashLayout.startAnimation(AnimationUtils.loadAnimation(StartUpActivity.this, R.anim.anim_splash_enter));
                    }

                    @Override
                    public void onShowFailed() {
                        //  LogUtil.e("开屏展示失败");
                    }

                    @Override
                    public void onSpotClosed() {
                        LogUtil.e("开屏被关闭");
                        //传入跳转的intent，若传入intent，初始化时目标activity应传入null
//                        Intent intent = new Intent(StartUpActivity.this, MainActivity.class);
//                        startActivity(intent);
//                        finish();
                    }

                    @Override
                    public void onSpotClick(boolean isWebPath) {
                        LogUtil.e("开屏被点击");
                    }
                });

        /**
         * 默认模式
         */
//        SpotManager.getInstance(this).showSplashSpotAds(this,
//         MainActivity.class);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SpotManager.getInstance(this).onDestroy();
    }
}
