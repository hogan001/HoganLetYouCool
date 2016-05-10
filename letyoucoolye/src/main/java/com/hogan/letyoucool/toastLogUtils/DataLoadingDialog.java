package com.hogan.letyoucool.toastLogUtils;

import android.content.Context;

import com.bigkoo.svprogresshud.SVProgressHUD;

/**
 * 作者: 陈虎
 * 日期: 2016/5/9  11:19
 * 描述: SVProgressHUD封闭的数据加载对话框
 */
public class DataLoadingDialog {
    private SVProgressHUD mSVProgressHUD = null;
    private static DataLoadingDialog mInstance;
    public DataLoadingDialog() {

    }

    /**
     * 单例模式
     */
    public static DataLoadingDialog getInstance() {

        if (mInstance == null) {
            synchronized (DataLoadingDialog.class) {
                if (mInstance == null) {
                    mInstance = new DataLoadingDialog();
                }
            }
        }
        return mInstance;
    }

    /**
     * 显示dialog
     */
    public void show(Context mContext, String str) {
        mSVProgressHUD = new SVProgressHUD(mContext);
        mSVProgressHUD.showWithStatus(str, SVProgressHUD.SVProgressHUDMaskType.Gradient);
    }

    /**
     * 消失dialog
     */
    public void dismiss() {
        if (mSVProgressHUD != null) {
            if (mSVProgressHUD.isShowing()) {
                mSVProgressHUD.dismiss();
            }
            mSVProgressHUD = null;
        }
    }
}
