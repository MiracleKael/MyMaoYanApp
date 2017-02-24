package com.jiaojing.mymaoyanmovie;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.jiaojing.mymaoyanmovie.app.SplashBean;
import com.jiaojing.mymaoyanmovie.citypick.CityPickActivity;
import com.jiaojing.mymaoyanmovie.utils.CacheUtils;
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

public class WelcomeActivity extends Activity {
    public static final String CITY = "city";
    @Bind(R.id.img1)
    ImageView img1;
    @Bind(R.id.img2)
    ImageView img2;
    private Handler handler = new Handler(){
        public void handleMessage(Message msg){
            switch (msg.what){
                case 1:
                    img1.setVisibility(View.GONE);
                    img2.setVisibility(View.VISIBLE);
                    sendEmptyMessageDelayed(2,1500);
                    break;
                case 2:
                    GoToActivity();
                    break;
            }
        }
    };

    private void GoToActivity() {
        String city = CacheUtils.getString(WelcomeActivity.this, CITY);
        Log.e("TAG", "city=====" + city);
        Intent intent;
                if(city == ""){
                    intent = new Intent(WelcomeActivity.this, CityPickActivity.class);
                }else{
        intent = new Intent(WelcomeActivity.this, MainActivity.class);
                }

        startActivity(intent);
        finish();
    }

    private String pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去除title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //去掉Activity上面的状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);

        handler.sendEmptyMessageDelayed(1, 1500);
        getDataFromNet();


//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                String city = CacheUtils.getString(WelcomeActivity.this, CITY);
//                Log.e("TAG", "city=====" + city);
//                Intent intent;
////                if(city == ""){
////                    intent = new Intent(WelcomeActivity.this, CityPickActivity.class);
////                }else{
//                intent = new Intent(WelcomeActivity.this, MainActivity.class);
////                }
//
//                startActivity(intent);
//                finish();
//            }
//        }, 1000);

    }

    private void getDataFromNet() {
        OkHttpUtils.get().id(100).url(Constant.TODAYRECOMM).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                ToastUtil.showToast(WelcomeActivity.this,"联网加载图片失败");
            }

            @Override
            public void onResponse(String response, int id) {
                switch (id){
                    case 100:
                        if(response != null){
                            SplashBean splashBean = new Gson().fromJson(response, SplashBean.class);
                            List<SplashBean.PostersBean> posters = splashBean.getPosters();
                            if(posters != null && posters.size()>0){
                                pic = posters.get(0).getPic();
                            }
                            if(pic != null){
                                Glide.with(WelcomeActivity.this)
                                        .load(pic).into(img2);
                            }
                        }

                        break;
                }
            }
        });
    }

}
