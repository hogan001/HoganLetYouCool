package com.hogan.letyoucool.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 作者：hogan
 * 时间: 2016/5/8 17:01
 * 描述：Fragment基类
 */
public abstract class BaseFragment extends Fragment {

    private View rootView;
    private Context mContext;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = initView(inflater);
        return rootView;
    }

    protected abstract void initData();
    protected abstract View initView(LayoutInflater inflater);
}
