package com.hogan.letyoucool.utilsHelp;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
/**
 * 作者：hogan
 * 时间: 2016/5/8 17:13
 * 描述：SharedPreferences工具
 **/
public class SharedPreferencesUtils {
	//默认
	public static void saveData(Context context, String key, Object object) {
		
		try {
			SharedPreferences sp = PreferenceManager
					.getDefaultSharedPreferences(context);
			String type = object.getClass().getSimpleName();
			Editor editor = sp.edit();
			if ("String".equals(type)) {
				editor.putString(key, (String) object);
			} else if ("Integer".equals(type)) {
				editor.putInt(key, (Integer) object);
			} else if ("Boolean".equals(type)) {
				editor.putBoolean(key, (Boolean) object);
			} else if ("Float".equals(type)) {
				editor.putFloat(key, (Float) object);
			} else if ("Long".equals(type)) {
				editor.putLong(key, (Long) object);
			}
			editor.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//自定义spname
	public static void saveData(Context context,String spname, String key, Object object) {
		try {
			SharedPreferences sp = context.getSharedPreferences(spname, 0);
			String type = object.getClass().getSimpleName();
			Editor editor = sp.edit();
			if ("String".equals(type)) {
				editor.putString(key, (String) object);
			} else if ("Integer".equals(type)) {
				editor.putInt(key, (Integer) object);
			} else if ("Boolean".equals(type)) {
				editor.putBoolean(key, (Boolean) object);
			} else if ("Float".equals(type)) {
				editor.putFloat(key, (Float) object);
			} else if ("Long".equals(type)) {
				editor.putLong(key, (Long) object);
			}
			editor.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Object getData(Context context, String spname,String key,
			Object defaultObject) {
		
		try {
			SharedPreferences sp = context.getSharedPreferences(spname, 0);
			String type = defaultObject.getClass().getSimpleName();
			if ("String".equals(type)) {
				return sp.getString(key, (String) defaultObject);
			} else if ("Integer".equals(type)) {
				return sp.getInt(key, (Integer) defaultObject);
			} else if ("Boolean".equals(type)) {
				return sp.getBoolean(key, (Boolean) defaultObject);
			} else if ("Float".equals(type)) {
				return sp.getFloat(key, (Float) defaultObject);
			} else if ("Long".equals(type)) {
				return sp.getLong(key, (Long) defaultObject);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}
	
	public static Object getData(Context context, String key,
			Object defaultObject) {
		SharedPreferences sp = PreferenceManager
				.getDefaultSharedPreferences(context);
		try {
			String type = defaultObject.getClass().getSimpleName();
			if ("String".equals(type)) {
				return sp.getString(key, (String) defaultObject);
			} else if ("Integer".equals(type)) {
				return sp.getInt(key, (Integer) defaultObject);
			} else if ("Boolean".equals(type)) {
				return sp.getBoolean(key, (Boolean) defaultObject);
			} else if ("Float".equals(type)) {
				return sp.getFloat(key, (Float) defaultObject);
			} else if ("Long".equals(type)) {
				return sp.getLong(key, (Long) defaultObject);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}

	//移除指定sp中的指定元素
	public static void removeData(Context context,String spName,String key){
		SharedPreferences sp = context.getSharedPreferences(spName, 0);
		sp.edit().remove(key).commit();
	}
}
