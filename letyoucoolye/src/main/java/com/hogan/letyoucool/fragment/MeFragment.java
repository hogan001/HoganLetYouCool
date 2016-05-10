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
        return rootView;
    }

    @Override
    protected void initData() {
        mContext =getActivity();
        Login();

    }
    private void Login() {
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("rad", System.currentTimeMillis() + "");
        params.put("companyCode", "000001");
        params.put("client", "1");
        params.put("type", "1");
        params.put("loginid", "156622");
        params.put("pwd", "123456");
        params.put("phonetype", "android");
        params.put("uniquecode", "867299021714134");
        HoganUtils.getInstance().getNetworkRequest(params, HttpUrl.NEWS, "tag", new StringCallback() {
            @Override
            public void onBefore(Request request) {
                super.onBefore(request);
                DataLoadingDialog.getInstance().show(mContext, "数据加载中...");
            }

            @Override
            public void onAfter() {
                super.onAfter();
                DataLoadingDialog.getInstance().dismiss();
            }

            @Override
            public void onError(Call call, Exception e) {
                Log.e("onError", e.toString());
            }

            @Override
            public void onResponse(String response) {
                Log.e("onResponse", response);
                news.setText(response);
                Gson gson = new Gson();
                EmployeeLandingBean bean1 = gson.fromJson(response, EmployeeLandingBean.class);
                Log.e("tag", bean1.getToken() + "___" + bean1.getCompanyName() + "___" + bean1.getEdiname() + "__" + bean1.getJobNumber());
            }
        });

    }


}
