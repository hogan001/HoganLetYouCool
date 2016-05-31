package com.hogan.letyoucool.activity;

import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.hogan.letyoucool.R;

import java.nio.Buffer;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 作者: 陈虎
 * 日期: 2016/5/9  14:37
 * 描述:
 */
public class LoginActivity extends BaseActivity {
    @Bind(R.id.login)
    protected TextView login;
    private Context mContext;
    @Override
    protected void initView() {
        setContentView(R.layout.login_activity);
        ButterKnife.bind(this);
        mContext=this;
    }

    @Override
    protected void initData() {
         login.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent=new Intent(mContext,MainActivity.class);
                 startActivity(intent);
             }
         });
    }

}
