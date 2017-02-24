package com.jiaojing.mymaoyanmovie.mine.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jiaojing.mymaoyanmovie.R;
import com.jiaojing.mymaoyanmovie.base.BaseFragment;
import com.jiaojing.mymaoyanmovie.mine.activity.LoginActivity;
import com.jiaojing.mymaoyanmovie.mine.bean.Container;
import com.jiaojing.mymaoyanmovie.mine.utils.ImageUtil;
import com.jiaojing.mymaoyanmovie.mine.view.CircleImageView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by jiaojing on 2016/11/30.
 * 作用：xxx
 */
public class MineFragment extends BaseFragment {

    @Bind(R.id.btn_loginout)
    Button btnLoginout;
    @Bind(R.id.username)
    TextView username;
    @Bind(R.id.iv_userheader)
    CircleImageView ivUserheader;
    //是否登录成功
    private boolean isLogin = false;
    private MyBroad myBroad;
    @Bind(R.id.ll_login)
    LinearLayout llLogin;


    @Override
    protected String getUrl() {
        return null;
    }

    @Override
    protected void initData(String content) {

        IntentFilter filter = new IntentFilter();
        filter.addAction("abcdefg");
        myBroad = new MyBroad();
        mContext.registerReceiver(myBroad, filter);
        if (Container.mQQAuth != null && Container.mQQAuth.isSessionValid()) {
            updateUI();
        }

        llLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isLogin) {
                    return;
                }
                Intent intent = new Intent(mContext, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initTitle() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    class MyBroad extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            isLogin = true;
            updateUI();
        }
    }
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Bitmap bitmap = (Bitmap) msg.obj;
            ivUserheader.setImageBitmap(bitmap);
            super.handleMessage(msg);
        }
    };

    private void updateUI() {
        btnLoginout.setVisibility(View.VISIBLE);
        String name = Container.name;
        username.setText(name);
        final String icon = Container.icon;
        new Thread() {

            //加载QQ头像，可能耗时
            @Override
            public void run() {
                Bitmap bitmap = ImageUtil.getbitmap(icon);
                Message msg = new Message();
                msg.obj = bitmap;
                mHandler.sendMessage(msg);
            }
        }.start();

    }

}
