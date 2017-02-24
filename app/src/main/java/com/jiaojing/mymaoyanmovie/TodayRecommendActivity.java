package com.jiaojing.mymaoyanmovie;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.jiaojing.mymaoyanmovie.bean.TodayRecommendBean;
import com.jiaojing.mymaoyanmovie.utils.Constant;
import com.jiaojing.mymaoyanmovie.utils.ToastUtil;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;

public class TodayRecommendActivity extends Activity {

    @Bind(R.id.iv_today_recommend)
    ImageView ivTodayRecommend;
    private List<TodayRecommendBean.PostersBean> result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去除title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //去掉Activity上面的状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_today_recommend);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {
        OkHttpUtils.get()
                .url(Constant.TODAYRECOMM)
                .id(100)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("TAG", "请求网络失败");
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e("TAG", "请求网络成功");
                        Log.e("TAG", "respose == " + response);
                        switch (id){
                            case 100:
                                if (response != null) {
                                    progressData(response);
                                    Glide.with(TodayRecommendActivity.this)
                                            .load(result.get(0).getPic())
                                            .into(ivTodayRecommend);

                                    new Handler().postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            Intent intent = new Intent(TodayRecommendActivity.this, MainActivity.class);
                                            startActivity(intent);
                                            finish();
                                        }
                                    }, result.get(0).getDuration());

                                }
                                break;
                            case 101:
                                ToastUtil.showToast(TodayRecommendActivity.this, "https");
                                break;
                        }

                    }
                });
    }

    private void progressData(String json) {
        TodayRecommendBean todayRecommendBean = new Gson().fromJson(json, TodayRecommendBean.class);
        result = todayRecommendBean.getPosters();
    }
}
