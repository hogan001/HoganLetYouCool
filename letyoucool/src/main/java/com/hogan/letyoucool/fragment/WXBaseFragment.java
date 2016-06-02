package com.hogan.letyoucool.fragment;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hogan.letyoucool.R;
import com.hogan.letyoucool.adapter.WXFragmentPagerAdapter;
import com.hogan.letyoucool.application.MyApplication;
import com.hogan.letyoucool.fragment_wx.LadyFragment;
import com.hogan.letyoucool.fragment_wx.MilitaryFragment;
import com.hogan.letyoucool.fragment_wx.PopularFragment;

import java.lang.reflect.Field;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 作者: 陈虎
 * 日期: 2016/5/31  15:05
 * 描述:
 */
public class WXBaseFragment extends BaseFragment implements View.OnClickListener, ViewPager.OnPageChangeListener{
    @Bind(R.id.app_pager)
    protected ViewPager app_pager;
    @Bind(R.id.app_tab)
    protected ImageView app_tab;
    @Bind(R.id.wx_popular_tv)
    protected TextView wx_popular_tv;

    @Bind(R.id.wx_military_tv)
    protected TextView wx_military_tv;

    @Bind(R.id.wx_lady_tv)
    protected TextView wx_lady_tv;
    private View rootView;
    private WXFragmentPagerAdapter mAdapter;
    private ArrayList<Fragment> mList;
    private int currentIndex;
    private Context mContext;
    @Override
    protected View initView(LayoutInflater inflater) {
        rootView = inflater.inflate(R.layout.fragment_application, null);
        ButterKnife.bind(this, rootView);
        mContext = getActivity();
        return rootView;
    }

    @Override
    protected void initData() {
        initViewPager();
        initTabLineWidth();
        setListener();
    }

    private void setListener() {
        wx_popular_tv.setOnClickListener(this);
        wx_military_tv.setOnClickListener(this);
        wx_lady_tv.setOnClickListener(this);
        app_pager.setOnPageChangeListener(this);
    }

    /**
     * 初始化viewpager
     */
    private void initViewPager() {
        mList = new ArrayList<Fragment>();
        PopularFragment popularFragment =new PopularFragment();
        MilitaryFragment militaryFragment = new MilitaryFragment();
        LadyFragment ladyFragment = new LadyFragment();
        mList.add(popularFragment);
        mList.add(militaryFragment);
        mList.add(ladyFragment);

        mAdapter = new WXFragmentPagerAdapter(getChildFragmentManager(),
                mList);
        app_pager.setAdapter(mAdapter);
        app_pager.setOffscreenPageLimit(2);
        app_pager.setCurrentItem(currentIndex);
        changeTabColor(currentIndex);
    }

    private void changeTabColor(int arg0) {
        TextView[] texts = new TextView[]{wx_popular_tv, wx_military_tv,
                wx_lady_tv};
        for (int i = 0; i < texts.length; i++) {
            if (i == arg0) {
                texts[i].setTextColor(Color.parseColor("#025fa1"));
            } else {
                texts[i].setTextColor(Color.parseColor("#8d8c8c"));
            }
        }
    }

    private void initTabLineWidth() {
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) app_tab
                .getLayoutParams();
        lp.width = MyApplication.screenWidth / 3;
        app_tab.setLayoutParams(lp);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        try {
            Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
            childFragmentManager.setAccessible(true);
            childFragmentManager.set(this, null);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.wx_popular_tv:
                currentIndex = 0;
                break;
            case R.id.wx_military_tv:
                currentIndex = 1;
                break;
            case R.id.wx_lady_tv:
                currentIndex = 2;
                break;
        }
        app_pager.setCurrentItem(currentIndex);
        changeTabColor(currentIndex);
    }

    @Override
    public void onPageScrolled(int position, float offset, int positionOffsetPixels) {
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) app_tab
                .getLayoutParams();
        /**
         * 利用currentIndex(当前所在页面)和position(下一个页面)以及offset来 设置mTabLineIv的左边距
         * 滑动场景： 记4个页面, 从左到右分别为0,1,2,3
         */

        int screenWidth = MyApplication.screenWidth;

        if (currentIndex == 0 && position == 0)// 0->1
        {
            lp.leftMargin = (int) (offset * (screenWidth * 1.0 / 3) + currentIndex
                    * (screenWidth / 3));

        } else if (currentIndex == 1 && position == 0) // 1->0
        {
            lp.leftMargin = (int) (-(1 - offset) * (screenWidth * 1.0 / 3) + currentIndex
                    * (screenWidth / 3));

        } else if (currentIndex == 1 && position == 1) // 1->2
        {
            lp.leftMargin = (int) (offset * (screenWidth * 1.0 / 3) + currentIndex
                    * (screenWidth / 3));
        } else if (currentIndex == 2 && position == 1) // 2->1
        {
            lp.leftMargin = (int) (-(1 - offset) * (screenWidth * 1.0 / 3) + currentIndex
                    * (screenWidth / 3));
        }

        app_tab.setLayoutParams(lp);
    }

    @Override
    public void onPageSelected(int position) {
        currentIndex = position;
        changeTabColor(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
