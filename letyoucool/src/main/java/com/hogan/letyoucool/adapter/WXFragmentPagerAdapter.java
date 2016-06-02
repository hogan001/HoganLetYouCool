package com.hogan.letyoucool.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * @author chenhu
 * @描述    重写FragmentPagerAdapter
 * @时间 2015-12-2 上午11:12:58
 * */
public class WXFragmentPagerAdapter extends FragmentPagerAdapter {
	private ArrayList<Fragment> mList;
	public WXFragmentPagerAdapter(FragmentManager fm) {
		super(fm);
		
	}
	
	public WXFragmentPagerAdapter(FragmentManager fragmentManager, ArrayList<Fragment> list) {
		super(fragmentManager);
		this.mList = list;
	}
	

	@Override
	public Fragment getItem(int arg0) {
		if(mList!=null&&mList.size()>0){
			return mList.get(arg0);
		}
		else{
			return null;
		}
	}

	
	@Override
	public int getCount() {
		
		if(mList!=null&&mList.size()>0){
			return mList.size();
		}else{
			return 0;
		}
	
	}

}
