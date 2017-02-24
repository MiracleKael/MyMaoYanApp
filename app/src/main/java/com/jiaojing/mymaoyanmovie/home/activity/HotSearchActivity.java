package com.jiaojing.mymaoyanmovie.home.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.jiaojing.mymaoyanmovie.R;
import com.jiaojing.mymaoyanmovie.home.bean.SearchHotBean;
import com.jiaojing.mymaoyanmovie.home.ui.FlowLayout;
import com.jiaojing.mymaoyanmovie.utils.Constant;
import com.jiaojing.mymaoyanmovie.utils.DensityUtil;
import com.jiaojing.mymaoyanmovie.utils.ToastUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;

public class HotSearchActivity extends Activity {

    @Bind(R.id.et_search)
    EditText etSearch;
    @Bind(R.id.search_cancle)
    TextView searchCancle;
    @Bind(R.id.flowlayout)
    FlowLayout flowlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_hot_search);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        getDataFromNet();

        searchCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void getDataFromNet() {
        OkHttpUtils.get()
                .id(100)
                .url(Constant.SEARCH_HOT)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("TAG", "热搜联网失败");
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e("TAG", "热搜联网成功");
                        switch (id) {
                            case 100:
                                if (response != null) {
                                    SearchHotBean searchHotBean = new Gson().fromJson(response, SearchHotBean.class);
                                    List<SearchHotBean.DataBean> data = searchHotBean.getData();
                                    setFlowLayoutData(data);
                                }
                                break;
                        }
                    }
                });
    }

    private void setFlowLayoutData(List<SearchHotBean.DataBean> data) {
        if (data != null && data.size() > 0) {
            String[] addData = {"速度与激情8", "捉迷藏", "奇异博士", "你的名字", "从你的全世界路过"};
            for (int i = 0; i < data.size()+addData.length; i++) {

                final TextView tv = new TextView(this);
                if(i >= data.size()){
                    tv.setText(addData[i - data.size()]);
                }else {
                    tv.setText(data.get(i).getValue());
                }

                tv.setTextSize(DensityUtil.dip2px(this, 5));
                //提供边距对象
                ViewGroup.MarginLayoutParams mp = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                mp.leftMargin = DensityUtil.dip2px(this, 5);
                mp.topMargin = DensityUtil.dip2px(this, 5);
                mp.rightMargin = DensityUtil.dip2px(this, 5);
                mp.bottomMargin = DensityUtil.dip2px(this, 5);
                tv.setLayoutParams(mp);
                //设置背景颜色
                tv.setBackgroundColor(Color.parseColor("#F5F5F5"));
                int padding = DensityUtil.dip2px(this, 5);
                tv.setPadding(padding, padding, padding, padding);

                tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastUtil.showToast(HotSearchActivity.this, "点击了"+ tv.getText());
                    }
                });

                flowlayout.addView(tv);


            }
        }
    }


}
