package com.jiaojing.mymaoyanmovie.home.fragment;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiaojing.mymaoyanmovie.R;
import com.jiaojing.mymaoyanmovie.base.BaseFragment;
import com.jiaojing.mymaoyanmovie.citypick.CityPickActivity;
import com.jiaojing.mymaoyanmovie.home.adapter.HomeFragmentAdapter;
import com.jiaojing.mymaoyanmovie.home.ui.MyViewPagerIndicator;
import com.jiaojing.mymaoyanmovie.utils.CacheUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by jiaojing on 2016/11/30.
 * 作用：xxx
 */
public class HomeFragment extends BaseFragment {
    public static final String KEY_PICKED_CITY = "picked_city";

    public static final String CITY = "city";
    private static String[] titles = {"热映", "待映", "找片"};
    private HomeFragmentAdapter adapter;
    @Bind(R.id.tv_city_show)
    TextView tvCityShow;
    @Bind(R.id.tv_cinema)
    TextView tvCinema;
    @Bind(R.id.iv_search_cinema)
    ImageView ivSearchCinema;
    @Bind(R.id.indicator)
    MyViewPagerIndicator indicator;
    @Bind(R.id.vp_home)
    ViewPager vpHome;

    @Override
    protected String getUrl() {
        return null;
    }

    @Override
    protected void initData(String content) {
        List<String> titleList = new ArrayList();
        for (int i = 0; i < titles.length; i++) {
            titleList.add(titles[i]);
        }
        Log.e("TAG", titleList.toString());

        adapter = new HomeFragmentAdapter(getFragmentManager());
        vpHome.setAdapter(adapter);

        indicator.setDatas(titleList);
        indicator.setViewPager(vpHome);

        String location = CacheUtils.getString(mContext, CITY);
        if(location != null){
            tvCityShow.setText(location);
        }

        tvCityShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, CityPickActivity.class);
                intent.putExtra("isFromMainActivity", true);
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initTitle() {
        tvCityShow.setVisibility(View.VISIBLE);
        indicator.setVisibility(View.VISIBLE);
        tvCinema.setVisibility(View.GONE);
        ivSearchCinema.setVisibility(View.GONE);
    }

//    @Override
//    protected int getLayoutById() {
//        return R.layout.fragment_home;
//    }

//    @Override
//    public void initData() {
//        super.initData();
//
//        List<String> titleList = new ArrayList();
//        for (int i = 0; i < titles.length; i++) {
//            titleList.add(titles[i]);
//        }
//        Log.e("TAG", titleList.toString());
//
//        adapter = new HomeFragmentAdapter(getFragmentManager());
//        vpHome.setAdapter(adapter);
//
//        indicator.setDatas(titleList);
//        indicator.setViewPager(vpHome);
//
//        String location = CacheUtils.getString(mContext, CITY);
//        if(location != null){
//            tvCityShow.setText(location);
//        }
//
//        tvCityShow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(mContext, CityPickActivity.class);
//                intent.putExtra("isFromMainActivity", true);
//                startActivityForResult(intent, 0);
//            }
//        });
//    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0 && resultCode ==-1){
            String whichCity = data.getStringExtra(KEY_PICKED_CITY);
            if(whichCity != null){
                tvCityShow.setText(whichCity);
            }

        }
    }
}
