package com.hogan.letyoucool.application;

import android.app.Application;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * 作者: 陈虎
 * 日期: 2016/5/9  11:11
 * 描述: 全局基类
 */
public class MyApplication extends Application {
    public   static  int screenWidth;
    public   static int screenHeight;

    @Override
    public void onCreate() {
        super.onCreate();
        getScreenWH();
    }

    /**得到手机的宽度与高度*/
    private void getScreenWH(){
        DisplayMetrics metric = new DisplayMetrics();
        WindowManager wm = (WindowManager) getApplicationContext()
                .getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(metric);
        screenWidth = metric.widthPixels; // 屏幕宽度（像素）
        screenHeight = metric.heightPixels; // 屏幕高度（像素）

    }


}
