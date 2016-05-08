package com.hogan.letyoucool.utilsHelp;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

import java.util.Stack;

/**
 * 作者：hogan
 * 时间: 2016/5/8 17:13
 * 描述：这是一个管理Activity的类，可以对项目中Activity的生命周期进行管理，达到安全退出的目的；
 **/
public class AppManager {

    private static Stack<Activity> activityStack;
    private static AppManager instance;

    private AppManager() {
    }


    public static AppManager getInstance() {

        if (instance == null) {
            synchronized (AppManager.class){
                if(instance ==null){
                    instance = new AppManager();
                }
            }
        }

        return instance;
    }

    /**
     * 添加Activity到堆栈中
     */
    public void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<Activity>();
        }
        activityStack.add(activity);
    }

    /**
     * 获取当前Activity（堆栈中最后压入的）
     */
    public Activity currentActivity() {
        Activity activity = activityStack.lastElement();
        return activity;
    }

    /**
     * 结束当前Activity（堆栈中最后压入的）
     */
    public void finishActivity() {
        Activity activity = activityStack.lastElement();
        finishActivity(activity);
    }

    /**
     * 结束指定的Activity
     */
    public void finishActivity(Activity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            activity.finish();
            activity = null;
        }
    }



    /**
     * 结束所有Activity
     */
    private void finishAllActivity() {
        for (int i = 0; i < activityStack.size(); i++) {
            if (null != activityStack.get(i)) {
                activityStack.get(i).finish();
            }
        }
    }

    /**
     * 彻底退出应用程序，安全退出
     */
    public void AppExit(Context mContext) {
        try {
            finishAllActivity();
            ActivityManager manager = (ActivityManager) mContext.getSystemService(Context.ACTIVITY_SERVICE);
            manager.restartPackage(mContext.getPackageName());
            System.exit(0);
            android.os.Process.killProcess(android.os.Process.myPid());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
