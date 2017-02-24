package com.jiaojing.mymaoyanmovie.utils;

import android.os.Handler;
import android.view.View;

import com.jiaojing.mymaoyanmovie.app.MyApplication;

/**
 * Created by jiaojing on 2016/12/7.
 * 作用：xxx
 */
public class UIUtils {

    //返回指定布局id,所对应的视图对象
    public static View getView(int layoutId){
        View view = View.inflate(MyApplication.mContext,layoutId,null);
        return view;
    }

    //获取程序需要的消息处理器的对象
    public static Handler getHandler(){
        return MyApplication.handler;
    }

    //保证如下操作在主线程
    public static void runOnUiThread(Runnable runnable){
        if(isMainThread()){
            runnable.run();
        }else{
            UIUtils.getHandler().post(runnable);
        }
    }
    //判断当前的线程是否是主线程
    private static boolean isMainThread() {
        int currentThreadId = android.os.Process.myTid();
        return MyApplication.mainThreadId == currentThreadId;
    }
}
