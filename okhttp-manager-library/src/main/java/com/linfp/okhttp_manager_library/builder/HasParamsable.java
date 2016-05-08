package com.linfp.okhttp_manager_library.builder;

import java.util.Map;

/**
 * Created by zhy on 16/3/1.
 */
public interface HasParamsable
{
    public abstract com.linfp.okhttp_manager_library.builder.OkHttpRequestBuilder params(Map<String, String> params);

    public abstract com.linfp.okhttp_manager_library.builder.OkHttpRequestBuilder addParams(String key, String val);

}
