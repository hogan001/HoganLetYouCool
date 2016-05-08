package com.linfp.okhttp_manager_library.utils;

import com.linfp.okhttp_manager_library.callback.StringCallback;
import com.linfp.okhttp_manager_library.manager.OkHttpUtils;

import java.util.Map;

/**
 * Created by chenhu on 2016/4/8.
 */
public class HoganUtils {

    public HoganUtils(){};

    private static class LazyHolder{
             private static final HoganUtils INSTANCE = new HoganUtils();
    }

    /**
     *  懒汉式单例 既实现了线程安全，又避免了同步带来的性能影响
     * */
    public static final HoganUtils getInstance(){
        return  LazyHolder.INSTANCE;
    }

    /**
     *  @param params
     *  @param  url
     *  @param tag
     *  @param callback
     *  四个参数的GET请求
     *
     * */
      public void getNetworkRequest(Map<String,String> params,   String url, String tag,StringCallback callback){
          OkHttpUtils.get()
                  .params(params)
                  .url(url)
                  .tag(tag)
                  .build()
                  .execute(callback);

      }
    /**
     *  @param params
     *  @param  url
     *  @param tag
     *  @param callback
     *   四个参数的POST请求
     *
     * */
    public void postNetworkRequest(Map<String,String> params,   String url, String tag,StringCallback callback){
        OkHttpUtils.post()
                .params(params)
                .url(url)
                .tag(tag)
                .build()
                .execute(callback);

    }
}
