package com.jiaojing.mymaoyanmovie.home.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.jiaojing.mymaoyanmovie.R;
import com.jiaojing.mymaoyanmovie.base.BaseFragment;
import com.jiaojing.mymaoyanmovie.home.adapter.FindGridViewAdapter;
import com.jiaojing.mymaoyanmovie.utils.Constant;
import com.jiaojing.mymaoyanmovie.utils.ToastUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;

/**
 * Created by jiaojing on 2016/11/30.
 * 作用：xxx
 */
public class FindFilmFragment extends BaseFragment {

    @Bind(R.id.ll_type)
    LinearLayout llType;
    @Bind(R.id.ll_area)
    LinearLayout llArea;
    @Bind(R.id.ll_year)
    LinearLayout llYear;
    @Bind(R.id.gridview)
    GridView gridview;
    @Bind(R.id.ll_award)
    LinearLayout llAward;
    private List<com.jiaojing.mymaoyanmovie.home.bean.FindScrollBean.DataBean> findScrollBeanData;

//    @Override
//    protected void initTitle() {
//    }

//    @Override
//    protected int getLayoutById() {
//        return R.layout.fragment_home_findfilm;
//    }

    //    @Override
//    public void initData() {
//        super.initData();
//        getDataFromNet();
//
//    }
    @Override
    protected String getUrl() {
        return Constant.HOME_FIND_GRIDVIEW;
    }

    @Override
    protected void initData(String content) {
        if (content != null) {
            progressGridData(content);
            getDataFromNet();
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_findfilm;
    }

    private void getDataFromNet() {
        OkHttpUtils.get()
                .url(Constant.HOME_FIND_SCROLL)
                .id(100)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        ToastUtil.showToast(mContext, "find界面scroll联网请求失败" + e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e("TAG", "fing界面scrollview请求成功");
                        switch (id) {
                            case 100:
                                if (response != null) {
                                    com.jiaojing.mymaoyanmovie.home.bean.FindScrollBean findScrollBean = new Gson().fromJson(response, com.jiaojing.mymaoyanmovie.home.bean.FindScrollBean.class);
                                    findScrollBeanData = findScrollBean.getData();

                                    List<com.jiaojing.mymaoyanmovie.home.bean.FindScrollBean.DataBean.TagListBean> typeList1 = findScrollBeanData.get(0).getTagList();
                                    //给第一行 scrlscrollview添加数据
                                    for (int i = 0; i < typeList1.size(); i++) {
                                        View inflate = LayoutInflater.from(mContext).inflate(R.layout.find_scrollview_text, null);
                                        RelativeLayout rl = (RelativeLayout) inflate.findViewById(R.id.rl);
                                        TextView textView = (TextView) inflate.findViewById(R.id.tv_scrollview);
                                        textView.setText(typeList1.get(i).getTagName());
                                        llType.addView(rl);
                                    }

                                    List<com.jiaojing.mymaoyanmovie.home.bean.FindScrollBean.DataBean.TagListBean> typeList2 = findScrollBeanData.get(1).getTagList();
                                    for (int i = 0; i < typeList2.size(); i++) {
                                        View inflate = LayoutInflater.from(mContext).inflate(R.layout.find_scrollview_text, null);
                                        RelativeLayout rl = (RelativeLayout) inflate.findViewById(R.id.rl);
                                        TextView textView = (TextView) inflate.findViewById(R.id.tv_scrollview);
                                        textView.setText(typeList2.get(i).getTagName());
                                        llArea.addView(rl);
                                    }

                                    List<com.jiaojing.mymaoyanmovie.home.bean.FindScrollBean.DataBean.TagListBean> typeList3 = findScrollBeanData.get(2).getTagList();
                                    for (int i = 0; i < typeList3.size(); i++) {
                                        View inflate = LayoutInflater.from(mContext).inflate(R.layout.find_scrollview_text, null);
                                        RelativeLayout rl = (RelativeLayout) inflate.findViewById(R.id.rl);
                                        TextView textView = (TextView) inflate.findViewById(R.id.tv_scrollview);
                                        textView.setText(typeList3.get(i).getTagName());
                                        llYear.addView(rl);
                                    }


                                }
                                break;
                        }
                    }
                });

//        OkHttpUtils.get()
//                .url(Constant.HOME_FIND_GRIDVIEW)
//                .id(100)
//                .build()
//                .execute(new StringCallback() {
//                    @Override
//                    public void onError(Call call, Exception e, int id) {
//                        ToastUtil.showToast(mContext, "find界面gridview联网请求失败" + e.getMessage());
//                    }
//
//                    @Override
//                    public void onResponse(String response, int id) {
//                        Log.e("TAG", "fing界面gridview请求成功");
//                        switch (id) {
//                            case 100:
//                                if (response != null) {
//                                    FindGridViewBean findGridViewBean = new Gson().fromJson(response, FindGridViewBean.class);
//                                    List<FindGridViewBean.DataBean> data = findGridViewBean.getData();
//
//                                    FindGridViewAdapter adapter = new FindGridViewAdapter(mContext, data);
//                                    gridview.setAdapter(adapter);
//                                }
//                                break;
//                        }
//                    }
//                });

        OkHttpUtils.get()
                .url(Constant.HOME_FIND_AWARD)
                .id(100)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        ToastUtil.showToast(mContext, "find界面award联网请求失败" + e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e("TAG", "find界面award请求成功");
                        switch (id) {
                            case 100:
                                if (response != null) {
                                    com.jiaojing.mymaoyanmovie.home.bean.FindAwardBean findAwardBean = new Gson().fromJson(response, com.jiaojing.mymaoyanmovie.home.bean.FindAwardBean.class);
                                    List<com.jiaojing.mymaoyanmovie.home.bean.FindAwardBean.DataBean> findAwardBeanData = findAwardBean.getData();

                                    for (int i = 0; i < findAwardBeanData.size(); i++) {
                                        TextView find_award_awardname = new TextView(mContext);
                                        TextView find_award_time = new TextView(mContext);
                                        TextView find_award_flimname = new TextView(mContext);
                                        ImageView find_warad_img = new ImageView(mContext);

                                        View inflate = LayoutInflater.from(mContext).inflate(R.layout.find_award, null);
                                        find_award_awardname = (TextView) inflate.findViewById(R.id.find_award_awardname);
                                        find_award_time = (TextView) inflate.findViewById(R.id.find_award_time);
                                        find_award_flimname = (TextView) inflate.findViewById(R.id.find_award_flimname);
                                        find_warad_img = (ImageView) inflate.findViewById(R.id.find_warad_img);

                                        com.jiaojing.mymaoyanmovie.home.bean.FindAwardBean.DataBean dataBean = findAwardBeanData.get(i);

                                        find_award_awardname.setText(dataBean.getFestivalName());
                                        String heldDate = dataBean.getHeldDate();
                                        String newDate = heldDate.substring(5, heldDate.length());
                                        find_award_time.setText(newDate);
                                        find_award_flimname.setText(dataBean.getMovieName());
                                        String url = dataBean.getImg();
                                        String substring = url.substring(32, url.length());
                                        String newUrl = "http://p0.meituan.net/165.220/movie/" + substring;
                                        Glide.with(mContext).load(newUrl).into(find_warad_img);

                                        llAward.addView(inflate);//前往不要忘记这
                                    }


                                }
                                break;
                        }
                    }
                });
    }

    private void progressGridData(String json) {
        com.jiaojing.mymaoyanmovie.home.bean.FindGridViewBean findGridViewBean = new Gson().fromJson(json, com.jiaojing.mymaoyanmovie.home.bean.FindGridViewBean.class);
        List<com.jiaojing.mymaoyanmovie.home.bean.FindGridViewBean.DataBean> data = findGridViewBean.getData();

        FindGridViewAdapter adapter = new FindGridViewAdapter(mContext, data);
        gridview.setAdapter(adapter);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }


    @Override
    protected void initTitle() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
