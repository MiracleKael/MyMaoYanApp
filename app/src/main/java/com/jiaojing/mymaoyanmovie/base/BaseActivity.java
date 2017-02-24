package com.jiaojing.mymaoyanmovie.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import butterknife.ButterKnife;

/**
 * Created by jiaojing on 2016/11/30.
 * 作用：xxx
 */
public abstract class BaseActivity extends FragmentActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutById());
        ButterKnife.bind(this);
//        if(Build.VERSION.SDK_INT >= 21){//判断当前手机版本是否大于21
//            setupWindowAnimations();
//        }

        initData();

        listener();
    }

    protected abstract void listener();

    protected abstract void initData();

    protected abstract int getLayoutById();

//    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
//    private void setupWindowAnimations() {
//        // 设置进入过渡动画
//        Visibility enterTransition = buildEnterTransition();
//        getWindow().setEnterTransition(enterTransition);
//    }
//    @TargetApi(Build.VERSION_CODES.KITKAT)
//    private Visibility buildEnterTransition() {
//        Fade enterTransition = new Fade();
//        enterTransition.setDuration(500);
//        return enterTransition;
//    }
}
