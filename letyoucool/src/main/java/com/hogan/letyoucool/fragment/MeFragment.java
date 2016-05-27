package com.hogan.letyoucool.fragment;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.hogan.letyoucool.R;
import com.hogan.letyoucool.bean.EmployeeLandingBean;
import com.hogan.letyoucool.toastLogUtils.DataLoadingDialog;
import com.hogan.letyoucool.toastLogUtils.LogUtil;
import com.hogan.letyoucool.url.HttpUrl;
import com.linfp.okhttp_manager_library.callback.StringCallback;
import com.linfp.okhttp_manager_library.utils.HoganUtils;

import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Request;

/**
 * 作者: 陈虎
 * 日期: 2016/5/9  14:47
 * 描述:
 */
public class MeFragment extends BaseFragment {
    @Bind(R.id.me)
    protected TextView news;

    private View rootView;
    private Context mContext;


    @Override
    protected View initView(LayoutInflater inflater) {
       rootView = inflater.inflate(R.layout.me_fragment,null);
        ButterKnife.bind(this,rootView);
        LogUtil.e("MeFragment oncreate");
        return rootView;
    }

    @Override
    protected void initData() {
        mContext =getActivity();

    }



}
