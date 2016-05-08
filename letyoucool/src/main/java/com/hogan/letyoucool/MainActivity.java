package com.hogan.letyoucool;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.hogan.letyoucool.activity.BaseActivity;
import com.hogan.letyoucool.utilsHelp.toastUtil.ToastManager;

public class MainActivity extends BaseActivity implements View.OnClickListener{
      private TextView tv,left;

    @Override
    protected void initView() {
        setContentView(R.layout.content_main);
        tv = (TextView) findViewById(R.id.tv);
        left = (TextView) findViewById(R.id.toolbar_title_left);
        tv.setOnClickListener(this);
        left.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv:
                ToastManager.showShortText(MainActivity.this, "textview");
                break;
            case R.id.toolbar_title_left:
                ToastManager.showShortText(MainActivity.this, "left");
                break;
        }
    }
}
