package com.hogan.letyoucool.activity;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hogan.letyoucool.R;
import com.hogan.letyoucool.application.AppManager;
import com.hogan.letyoucool.bean.CardIdBean;
import com.hogan.letyoucool.bean.Constant;
import com.hogan.letyoucool.toastLogUtils.DataLoadingDialog;
import com.hogan.letyoucool.toastLogUtils.LogUtil;
import com.hogan.letyoucool.toastLogUtils.ToastManager;
import com.hogan.letyoucool.url.HttpUrl;
import com.hogan.letyoucool.utilsHelp.GsonUtil;
import com.linfp.okhttp_manager_library.callback.StringCallback;
import com.linfp.okhttp_manager_library.manager.OkHttpUtils;
import com.linfp.okhttp_manager_library.utils.HoganUtils;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Request;

/**
 * 作者: 陈虎
 * 日期: 2016/5/31  15:57
 * 描述: 身份证查询页面
 */
public class CardIDActivity extends BaseActivity implements View.OnClickListener {
    @Bind(R.id.iv_back)
    protected ImageView iv_back;
    @Bind(R.id.tv_center)
    protected TextView titleName;
    @Bind(R.id.cardID_et)
    protected EditText cardID_et;
    @Bind(R.id.cardid_content_tv)
    protected TextView cardid_content_tv;
    @Bind(R.id.cardID_bt)
    protected Button cardID_bt;
    private Context mContext;


    @Override
    protected void initView() {
        setContentView(R.layout.cardid_layout);
        ButterKnife.bind(this);
        mContext = this;
        titleName.setText("身份证查询");
    }

    @Override
    protected void initData() {
        setListener();
    }

    private void setListener() {
        cardID_bt.setOnClickListener(this);
        iv_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cardID_bt:
                LogUtil.e("id_" + cardID_et.getText().toString().trim());
                getDataFromService(cardID_et.getText().toString().trim());
                break;
            case R.id.iv_back:
                AppManager.getInstance().finishActivity(this);
                break;
        }

    }

    /**
     * 服务器获取数据
     */
    private void getDataFromService(String urlParam) {
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("rad", String.valueOf(System.currentTimeMillis()));
        params.put("id", urlParam);
        HoganUtils.getInstance().getNetworkRequestHead(params, HttpUrl.CARD_ID, "getDataFromService", new StringCallback() {
            @Override
            public void onBefore(Request request) {
                super.onBefore(request);
                DataLoadingDialog.getInstance().show(mContext, "加载中...");
            }

            @Override
            public void onAfter() {
                super.onAfter();
                DataLoadingDialog.getInstance().dismiss();
            }

            @Override
            public void onError(Call call, Exception e) {
                ToastManager.showShortText(mContext, "数据加载失败:" + e.toString());
            }

            @Override
            public void onResponse(String response) {

                LogUtil.e(response);
                try {
                    CardIdBean cardIdBean = GsonUtil.changeGsonToBean(response, CardIdBean.class);
                    cardid_content_tv.setText(cardIdBean.getErrNum() + "__" + cardIdBean.getRetData().getAddress() + "_" +
                            cardIdBean.getRetData().getBirthday() + "_" +
                            cardIdBean.getRetData().getSex());
                } catch (Exception e) {
                    e.printStackTrace();
                    cardid_content_tv.setText("身份证号码不合法!");
                }

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        OkHttpUtils.getInstance().cancelTag("getDataFromService");
    }
}
