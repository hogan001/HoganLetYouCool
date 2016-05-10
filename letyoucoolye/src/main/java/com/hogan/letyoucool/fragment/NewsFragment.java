package com.hogan.letyoucool.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hogan.letyoucool.R;
import com.hogan.letyoucool.bean.EmployeeLandingBean;
import com.hogan.letyoucool.recycleview.ItemsAdapter;
import com.hogan.letyoucool.recycleview.OnLoadMoreListener;
import com.hogan.letyoucool.recycleview.WrapContentLinearLayoutManager;
import com.hogan.letyoucool.toastLogUtils.DataLoadingDialog;
import com.hogan.letyoucool.toastLogUtils.LogUtil;
import com.hogan.letyoucool.toastLogUtils.ToastManager;
import com.hogan.letyoucool.url.HttpUrl;
import com.hogan.letyoucool.view.RefreshLayout;
import com.linfp.okhttp_manager_library.callback.StringCallback;
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
 * 描述:
 */
public class NewsFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {
    @Bind(R.id.recyclerview)
    protected RecyclerView mRecyclerView;
    @Bind(R.id.swiperefreshlayout)
    protected SwipeRefreshLayout swiperefreshlayout;
    private ItemsAdapter mAdapter;
    private View rootView;
    private Context mContext;
    private List<String> data;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };


    @Override
    protected View initView(LayoutInflater inflater) {
        rootView = inflater.inflate(R.layout.news_fragment, null);
        ButterKnife.bind(this, rootView);
        mContext = getActivity();
        return rootView;
    }

    @Override
    protected void initData() {
        data = new ArrayList<String>();
        setSwiperefreshlayout();
    }



    private void setSwiperefreshlayout() {
        swiperefreshlayout.setColorSchemeResources(R.color.swipe_color_1,
                R.color.swipe_color_2,
                R.color.swipe_color_3,
                R.color.swipe_color_4);
        swiperefreshlayout.setOnRefreshListener(this);
        final WrapContentLinearLayoutManager layoutManager = new WrapContentLinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new ItemsAdapter(mContext,data,mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);
        swiperefreshlayout.post(new Runnable() {
            @Override
            public void run() {
                swiperefreshlayout.setRefreshing(true);
            }
        });
        getPullData();
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int lastVisibleItem = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
                int totalItemCount = layoutManager.getItemCount();
                if(lastVisibleItem>=totalItemCount-4 && dy>0){
                    getDownData();
                }

            }
        });
    }

    /**
     * 下拉数据
     * */
    private void getPullData() {

        mHandler.postDelayed(new Runnable() {
            public void run() {
                swiperefreshlayout.setRefreshing(false);
                int index = data.size();
                for (int i = index; i < index + 8; i++) {
                    data.add("第" + i + "个数据");
                }
                mAdapter.notifyDataSetChanged();
            }

        }, 3000);
    }
    /**
     * 上拉数据
     * */
    private void getDownData() {

        mHandler.postDelayed(new Runnable() {
            public void run() {
                swiperefreshlayout.setRefreshing(false);
                int index = data.size();
                for (int i = index; i < index + 3; i++) {
                    data.add("第" + i + "个数据");
                }
                mAdapter.notifyDataSetChanged();
            }

        }, 3000);
    }




    @Override
    public void onRefresh() {
        LogUtil.e("onRefresh");

//        if(!swiperefreshlayout.isRefreshing()){
            data.clear();
            getPullData();
       // }

    }

//    @Override
//    public void onLoadMore() {
//        LogUtil.e("onLoadMore");
//        mAdapter.setLoaded();
//        getDownData();
//
//    }
}
