package com.jiaojing.mymaoyanmovie.app;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import com.amap.api.location.AMapLocationClient;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by jiaojing on 2016/11/30.
 * 作用：xxx
 */
public class MyApplication extends Application{
    public static Context mContext;
    public static Handler handler;
    public static Thread mainThread;//获取主线程
    public static int mainThreadId;//获取主线程的id
    @Override
    public void onCreate() {
        super.onCreate();

        handler = new Handler();
        mainThread = Thread.currentThread();//当前用于初始化Application的线程，即为主线程

        mainThreadId = android.os.Process.myTid();//获取当亲主线程的id

        mContext = this.getApplicationContext();

        initOkHttpUtils();
        AMapLocationClient.setApiKey("771db4926bd31ecb0a11ff248b3909fc");
    }


    private void initOkHttpUtils() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(new LoggerInterceptor("TAG"))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                        //其他配置
                .build();

        OkHttpUtils.initClient(okHttpClient);
    }

//    public static Context getContext(){
//        return mContext;
//    }
}
