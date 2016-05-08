package com.linfp.okhttp_manager_library.utils;

import android.os.Build;
import android.util.Log;

import com.linfp.okhttp_manager_library.BuildConfig;

/**
 * Created by zhy on 15/11/6.
 */
public class L
{


    public static void e(String msg)
    {
        if (BuildConfig.DEBUG)
        {
            Log.e("OkHttp", msg);
        }
    }

}

