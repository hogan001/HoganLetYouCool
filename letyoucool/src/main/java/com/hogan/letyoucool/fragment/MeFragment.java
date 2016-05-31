package com.hogan.letyoucool.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.hogan.letyoucool.R;
import com.hogan.letyoucool.activity.CardIDActivity;
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
public class MeFragment extends BaseFragment implements View.OnClickListener {
    @Bind(R.id.me_cardID_layout)
    protected LinearLayout me_cardID_layout;

    private View rootView;
    private Context mContext;


    @Override
    protected View initView(LayoutInflater inflater) {
       rootView = inflater.inflate(R.layout.me_fragment,null);
        ButterKnife.bind(this,rootView);
        return rootView;
    }

    @Override
    protected void initData() {
        mContext =getActivity();
        setListener();
    }

    private void setListener(){
        me_cardID_layout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.me_cardID_layout:
                Intent intent =new Intent(mContext, CardIDActivity.class);
                startActivity(intent);
                break;
        }

    }
}
