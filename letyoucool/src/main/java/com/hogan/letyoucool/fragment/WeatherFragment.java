package com.hogan.letyoucool.fragment;

import android.view.LayoutInflater;
import android.view.View;

import com.hogan.letyoucool.R;
import com.hogan.letyoucool.toastLogUtils.LogUtil;

import butterknife.ButterKnife;

/**
 * 作者: 陈虎
 * 日期: 2016/5/9  15:26
 * 描述:
 */
public class WeatherFragment extends BaseFragment {
    private View rootView;
    @Override
    protected View initView(LayoutInflater inflater) {
        rootView = inflater.inflate(R.layout.weather_fragment,null);
        ButterKnife.bind(this,rootView);
        LogUtil.e("WeatherFragment oncreate");
        return rootView;
    }

    @Override
    protected void initData() {

    }
}
