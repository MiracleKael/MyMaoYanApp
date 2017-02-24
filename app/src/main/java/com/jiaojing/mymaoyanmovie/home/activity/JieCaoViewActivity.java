package com.jiaojing.mymaoyanmovie.home.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.jiaojing.mymaoyanmovie.R;
import com.jiaojing.mymaoyanmovie.home.bean.PlayerBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import okhttp3.Call;


public class JieCaoViewActivity extends Activity {

    JCVideoPlayerStandard mJcVideoPlayerStandard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jie_cao_view);

        mJcVideoPlayerStandard = (JCVideoPlayerStandard) findViewById(R.id.jc_video);

        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        String playerurl = intent.getStringExtra("playerurl");
        OkHttpUtils.get()
                .id(100)
                .url(playerurl)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        switch (id) {
                            case 100:
                                if (response != null) {
                                    PlayerBean playerBean = new Gson().fromJson(response, PlayerBean.class);
                                    String url = playerBean.getVlist().get(0).getUrl();
                                    Log.e("TAG", "视频播放url ===="+url);
                                    String movieName = playerBean.getVlist().get(0).getMovieName();

                                    mJcVideoPlayerStandard.setUp(url, JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, movieName);
                                }
                                break;
                        }

                    }
                });


    }

//    @Override
//    public void onBackPressed() {
//        if (JCVideoPlayer.backPress()) {
//            return;
//        }
//        super.onBackPressed();
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        JCVideoPlayer.releaseAllVideos();
//    }
}
