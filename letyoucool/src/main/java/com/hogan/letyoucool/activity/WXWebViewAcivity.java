package com.hogan.letyoucool.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hogan.letyoucool.R;
import com.hogan.letyoucool.application.AppManager;
import com.hogan.letyoucool.toastLogUtils.DataLoadingDialog;
import com.hogan.letyoucool.toastLogUtils.LogUtil;

import net.youmi.android.banner.AdSize;
import net.youmi.android.banner.AdView;
import net.youmi.android.banner.AdViewListener;

import butterknife.Bind;
import butterknife.ButterKnife;
/**
 * 作者：hogan
 * 时间: 2016/5/8 18:37
 * 描述：微信头条详细内容
 **/

public class WXWebViewAcivity extends BaseActivity implements OnClickListener {
    @Bind(R.id.tv_center)
    protected TextView tv_center;
    @Bind(R.id.iv_back)
    protected ImageView iv_back;
    @Bind(R.id.empty_view_root)
    protected LinearLayout mEmptyView;
    private WebView webView;
    private WebSettings settings;
    private String webUrl;
    private Context mContext;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_web_wx);
        ButterKnife.bind(this);
        tv_center.setText("内容详情");
        iv_back.setOnClickListener(this);
        mContext=this;
        webUrl =getIntent().getStringExtra("webUrl");

    }

    @Override
    protected void initData() {
        initWebView();
        getNetWorkStatus();
    }

    private void initWebView() {
        webView = (WebView) findViewById(R.id.tripapprovel_webView);
        DataLoadingDialog.getInstance().show(this,"加载中...");
        settings = webView.getSettings();
        //执行js脚本
        settings.setJavaScriptEnabled(true);
        //支持缩放
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        //加载缓存
        settings.setCacheMode(WebSettings.LOAD_DEFAULT);
        settings.setDomStorageEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient());
        webView.setDownloadListener(new MyWebViewDownLoadListener());
        webView.loadUrl(webUrl);

        webView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {


            }

        });
        DataLoadingDialog.getInstance().dismiss();
     //  setupBannerAd();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                AppManager.getInstance().finishActivity(this);
                break;
            default:
                break;
        }
    }

    /*
     * 设置回退 如果不做任何处理，浏览网页，点击系统“Back”键， 整个Browser会调用finish()而结束自身， 如果希望浏览的网
     * 页回退而不是推出浏览器，需要在当前Activity中处理并消费掉该Back事件。
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {

            WXWebViewAcivity.this.finish();
            return true;
        } else {
            WXWebViewAcivity.this.finish();
        }
        return false;
    }

    public class MyWebViewDownLoadListener implements DownloadListener {
        @Override
        public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
            Uri uri = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    }

    //判断联网状态，根据联网状态来判断是否显示无网络界面
    private void getNetWorkStatus() {

        boolean netSataus = false;
        ConnectivityManager cwjManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        cwjManager.getActiveNetworkInfo();

        if (cwjManager.getActiveNetworkInfo() != null) {
            netSataus = cwjManager.getActiveNetworkInfo().isAvailable();
        }

        if (!netSataus) {
            mEmptyView.setVisibility(View.VISIBLE);
            webView.setVisibility(View.GONE);
        } else {
            mEmptyView.setVisibility(View.GONE);
            webView.setVisibility(View.VISIBLE);
        }
    }


    /**
     * 设置广告条广告
     */
    private void setupBannerAd() {
        //		/**
        //		 * 普通布局
        //		 */
        //		//　实例化广告条
        //		AdView adView = new AdView(mContext, AdSize.FIT_SCREEN);
        //		LinearLayout bannerLayout = (LinearLayout) findViewById(R.id.ll_banner);
        //		bannerLayout.addView(adView);
        /**
         * 悬浮布局
         */
        // 实例化LayoutParams(重要)
        FrameLayout.LayoutParams layoutParams =
                new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        //　设置广告条的悬浮位置，这里示例为右下角
        layoutParams.gravity = Gravity.BOTTOM | Gravity.RIGHT;
        //　实例化广告条
        AdView adView = new AdView(mContext, AdSize.FIT_SCREEN);
        // 监听广告条接口
        adView.setAdListener(new AdViewListener() {

            @Override
            public void onSwitchedAd(AdView adView) {
                LogUtil.e( "广告条切换");
            }

            @Override
            public void onReceivedAd(AdView adView) {
                LogUtil.e( "请求广告条成功");
            }

            @Override
            public void onFailedToReceivedAd(AdView adView) {
                LogUtil.e( "请求广告条失败");
            }
        });
        // 调用Activity的addContentView函数
        ((Activity) mContext).addContentView(adView, layoutParams);
    }
}
