package com.hogan.letyoucool.fragment_wx;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.hogan.letyoucool.R;
import com.hogan.letyoucool.activity.WXWebViewAcivity;
import com.hogan.letyoucool.bean.Constant;
import com.hogan.letyoucool.bean.WXDataBean;
import com.hogan.letyoucool.fragment.BaseFragment;
import com.hogan.letyoucool.recycleview.ItemClickListener;
import com.hogan.letyoucool.recycleview.ItemsAdapter;
import com.hogan.letyoucool.recycleview.WrapContentLinearLayoutManager;
import com.hogan.letyoucool.toastLogUtils.LogUtil;
import com.hogan.letyoucool.url.HttpUrl;
import com.hogan.letyoucool.utilsHelp.GsonUtil;
import com.linfp.okhttp_manager_library.callback.StringCallback;
import com.linfp.okhttp_manager_library.manager.OkHttpUtils;
import com.linfp.okhttp_manager_library.utils.HoganUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Request;

/**
 * 作者: 陈虎
 * 日期: 2016/5/9  14:47
 * 描述: 微信头条推荐内容
 */
public class PopularFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {
    @Bind(R.id.recyclerview)
    protected RecyclerView mRecyclerView;
    @Bind(R.id.swiperefreshlayout)
    protected SwipeRefreshLayout swiperefreshlayout;
    private ItemsAdapter mAdapter;
    private View rootView;
    private Context mContext;
    private List<WXDataBean.DataBean.ArticleBean> data;
    private int indexPage = 1;


    @Override
    protected View initView(LayoutInflater inflater) {
        rootView = inflater.inflate(R.layout.news_fragment, null);
        ButterKnife.bind(this, rootView);
        mContext = getActivity();
        return rootView;
    }

    @Override
    protected void initData() {
        data = new ArrayList<WXDataBean.DataBean.ArticleBean>();
        setSwiperefreshlayout();
    }

    private void setSwiperefreshlayout() {
        swiperefreshlayout.setColorSchemeResources(R.color.swipe_color_1,
                R.color.swipe_color_2,
                R.color.swipe_color_3,
                R.color.swipe_color_4);
        swiperefreshlayout.setOnRefreshListener(this);
        WrapContentLinearLayoutManager layoutManager = new WrapContentLinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new ItemsAdapter(mContext, data, mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);
        swiperefreshlayout.post(new Runnable() {
            @Override
            public void run() {
                swiperefreshlayout.setRefreshing(true);
                getDataFromService();
            }
        });
        mAdapter.setOnItemClickListener(new ItemClickListener() {
            @Override
            public void OnItemClick(View view, int postion) {
                Intent intent =new Intent(mContext, WXWebViewAcivity.class);
                intent.putExtra("webUrl",data.get(postion).getUrl());
                startActivity(intent);
            }
        });
    }


    @Override
    public void onRefresh() {
        indexPage++;
        LogUtil.e("indexPage_" + indexPage + "");
        getDataFromService();


    }

    /**
     * 从服务器获取数据
     */
    private void getDataFromService() {
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("rad", String.valueOf(System.currentTimeMillis()));
        params.put("id", Constant.POPULAR);
        params.put("page", String.valueOf(indexPage));
        HoganUtils.getInstance().getNetworkRequestHead(params, HttpUrl.NEWS, "tag", new StringCallback() {
            @Override
            public void onBefore(Request request) {
                super.onBefore(request);
            }

            @Override
            public void onAfter() {
                super.onAfter();
                swiperefreshlayout.setRefreshing(false);
            }

            @Override
            public void onError(Call call, Exception e) {
                Toast.makeText(mContext, "加载数据失败:"+e.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(String response) {
                try {
                    WXDataBean dataBean = GsonUtil.changeGsonToBean(response, WXDataBean.class);
                    if (dataBean != null && dataBean.getData() != null) {
                        if (dataBean.getData().getArticle() != null && dataBean.getData().getArticle().size() > 0) {
                            if (data != null && data.size() > 0) {
                                data.clear();
                            }
                            for (int i = 0; i < dataBean.getData().getArticle().size(); i++) {
                                WXDataBean.DataBean.ArticleBean articleBean = dataBean.getData().getArticle().get(i);
                                data.add(articleBean);
                            }
                            LogUtil.e("PopularFragment_"+dataBean.getData().getArticle().get(0).getAuthor());
                            mAdapter.notifyDataSetChanged();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(mContext, "没有更多数据", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        OkHttpUtils.getInstance().cancelTag("getDataFromService");
        mContext=null;
    }
}
