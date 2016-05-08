package com.linfp.okhttp_manager_library.builder;

import com.linfp.okhttp_manager_library.manager.OkHttpUtils;
import com.linfp.okhttp_manager_library.request.OtherRequest;
import com.linfp.okhttp_manager_library.request.RequestCall;

/**
 * Created by zhy on 16/3/2.
 */
public class HeadBuilder extends GetBuilder
{
    @Override
    public RequestCall build()
    {
        return new OtherRequest(null, null, OkHttpUtils.METHOD.HEAD, url, tag, params, headers).build();
    }
}
