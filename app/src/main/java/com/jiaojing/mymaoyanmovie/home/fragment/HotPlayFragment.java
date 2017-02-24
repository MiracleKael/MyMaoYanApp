package com.jiaojing.mymaoyanmovie.home.fragment;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.google.gson.Gson;
import com.jiaojing.mymaoyanmovie.R;
import com.jiaojing.mymaoyanmovie.base.BaseFragment;
import com.jiaojing.mymaoyanmovie.home.activity.HotMoreActivity;
import com.jiaojing.mymaoyanmovie.home.activity.HotSearchActivity;
import com.jiaojing.mymaoyanmovie.home.adapter.ListViewAdapter;
import com.jiaojing.mymaoyanmovie.home.bean.HomeHotBannerBean;
import com.jiaojing.mymaoyanmovie.home.bean.HomeHotListViewBean;
import com.jiaojing.mymaoyanmovie.home.ui.TransitionHelper;
import com.jiaojing.mymaoyanmovie.utils.CacheUtils;
import com.jiaojing.mymaoyanmovie.utils.Constant;
import com.jiaojing.mymaoyanmovie.utils.ToastUtil;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import okhttp3.Call;

/**
 * Created by jiaojing on 2016/11/30.
 * 作用：xxx
 */
public class HotPlayFragment extends BaseFragment {

    public static final String LIST_VIEW_DATA = "ListViewData";
    public static final String HOT_BANNER = "hot_banner";
    @Bind(R.id.listView_hot)
    ListView listViewHot;
    @Bind(R.id.refresh)
    MaterialRefreshLayout refresh;
    private HomeHotListViewBean.DataBean listviewData;
    private List<HomeHotBannerBean.DataBean> bannerData;
    private LinearLayout topSearch;
    private LinearLayout ll_banner;
    private Banner banner;
    private ListViewAdapter listViewAdapter;

    //上拉加载更多请求的数据从第几个数据开始，如果下拉刷新成功过了，需要再次置为0
    private int offset = 0;
    //每页显示的数据个数，每次加载的数据个数
    private int limit = 10;
    //下拉刷新的url
    private String downRefreshUrl = Constant.HOME_HOT_BASE + "offset=0&limit=" + limit;
    //上拉加载更多的url
    private String upRefreshUrl;
    private List<HomeHotListViewBean.DataBean.MoviesBean> newListData;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    ToastUtil.showToast(mContext, "刷新失败，请检查网络");
                    refresh.finishRefresh();//时间一到,停止刷新
                    break;
            }
        }
    };

    @Override
    protected String getUrl() {
        return Constant.HOME_HOT_BASE + "offset=0&limit=10";
    }

    @Override
    protected void initData(String content) {
//监听刷新
        initRefreshLayout();

        if (content == "") {
            Log.e("TAG", "用了本地存储数据");
            String json1 = CacheUtils.getString(mContext, LIST_VIEW_DATA);
            String json2 = CacheUtils.getString(mContext, HOT_BANNER);
            if (!TextUtils.isEmpty(json1) && !TextUtils.isEmpty(json2)) {
                progressListViewData(json1);
                progressBannerData(json2);
            }

        } else {
            progressListViewData(content);
            //再给banner设置数据
            getBannerDataFromNet();
        }
//        String json1 = CacheUtils.getString(mContext, LIST_VIEW_DATA);
//        String json2 = CacheUtils.getString(mContext, HOT_BANNER);
//        if(!TextUtils.isEmpty(json1) && !TextUtils.isEmpty(json2)){
//            progressListViewData(json1);
//            progressBannerData(json2);
//        }else{
//            getDataFromNet();
//        }
        //如果没网，还没缓存，打开app一片空白,禁止可下拉刷星
        if (listviewData == null) {
            refresh.setLoadMore(false);//设置不可上啦刷新
        } else {
            refresh.setLoadMore(true);//设置可上啦刷新
        }

        listViewHot.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    if (Build.VERSION.SDK_INT >= 21) {//判断当前安卓手机版本是否大于5.0， 有特效
                        Intent intent = new Intent(mContext, HotSearchActivity.class);
                        final Pair<View, String>[] pairs = TransitionHelper.createSafeTransitionParticipants(getActivity(), false, new Pair<>(topSearch, "topsearch"));
                        ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), pairs);
                        startActivity(intent, transitionActivityOptions.toBundle());
                    } else {
                        Intent intent = new Intent(mContext, HotSearchActivity.class);
                        startActivity(intent);
                    }

                }
                if (position >= 2) {
                    int filmId = listViewAdapter.getFilmId(position);

                    String url = "http://m.maoyan.com/movie/" + filmId + "?_v_=yes";
//                Uri uri = Uri.parse(url);
//                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                startActivity(intent);
                    Intent intent = new Intent(mContext, HotMoreActivity.class);
                    intent.putExtra("URL", url);
                    startActivity(intent);
                }

            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_hot;
    }

    @Override
    protected void initTitle() {
        topSearch = (LinearLayout) View.inflate(mContext, R.layout.fragment_top_search, null);
        ll_banner = (LinearLayout) View.inflate(mContext, R.layout.fragment_banner, null);
        banner = (Banner) ll_banner.findViewById(R.id.banner);
    }


    private void initRefreshLayout() {
        refresh.setMaterialRefreshListener(new MyMaterialRefreshListener());
    }

    class MyMaterialRefreshListener extends MaterialRefreshListener {
        //  下拉刷新
        @Override
        public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
            offset = 0;
            refreshData();

        }

        //上拉加载更多
        @Override
        public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {
            super.onRefreshLoadMore(materialRefreshLayout);
            loadMoreData();
        }
    }

    private void loadMoreData() {
        //重新规划联网地址
        offset += 10;
        upRefreshUrl = Constant.HOME_HOT_BASE + "offset=" + offset + "&limit=" + limit;

        //先去除两个头
        listViewHot.removeHeaderView(topSearch);
        listViewHot.removeHeaderView(ll_banner);

        //联网请求数据，得到数据
        getMoreData(upRefreshUrl);

        listViewHot.addHeaderView(topSearch);
        listViewHot.addHeaderView(ll_banner);

        listViewHot.setAdapter(listViewAdapter);

        listViewHot.setSelection(offset);

        refresh.finishRefreshLoadMore();
    }

    private void getMoreData(String newUrl) {
        OkHttpUtils.get()
                .url(newUrl)
                .id(100)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        ToastUtil.showToast(mContext, "hot界面Listview联网请求失败" + e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        switch (id) {
                            case 100:
                                if (response != null) {

                                    HomeHotListViewBean homeHotListViewBean = new Gson().fromJson(response, HomeHotListViewBean.class);
                                    newListData = homeHotListViewBean.getData().getMovies();

                                    listViewAdapter.addData(newListData);
                                }
                                break;
                            case 101:
                                ToastUtil.showToast(mContext, "https");
                                break;
                        }
                    }
                });
    }

    private void refreshData() {
        //发送8秒的消息，如果还没得到请求的数据，就停止刷新
        handler.sendEmptyMessageDelayed(1, 8000);

        getBannerDataFromNet();
        getListViewDataFromNet(downRefreshUrl);
    }

//    private void getDataFromNet() {
//        //得到banner的数据
//        getBannerDataFromNet();
//        //得到listView的数据
//        getListViewDataFromNet(getUrl());
//
//    }

    private void getListViewDataFromNet(String url) {
        OkHttpUtils.get()
                .url(url)
                .id(100)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        ToastUtil.showToast(mContext, "hot界面Listview联网请求失败" + e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e("TAG", "hot界面Listview联网请求成功");
                        switch (id) {
                            case 100:
                                if (response != null) {
                                    //解析数据
                                    progressListViewData(response);

                                }
                                break;
                            case 101:
                                ToastUtil.showToast(mContext, "https");
                                break;
                        }
                    }
                });
    }

    private void setAdapter() {

        listViewHot.addHeaderView(topSearch);
        listViewHot.addHeaderView(ll_banner);

        listViewAdapter = new ListViewAdapter(mContext, listviewData);
        listViewHot.setAdapter(listViewAdapter);
    }

    private void getBannerDataFromNet() {
        OkHttpUtils.get()
                .url(Constant.HOME_HOT_ViewPager)
                .id(100)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        ToastUtil.showToast(mContext, "banner联网请求失败");
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e("TAG", "hot界面banner联网请求成功");
                        switch (id) {
                            case 100:
                                if (response != null) {
                                    //缓存到本地
                                    CacheUtils.putString(mContext, HOT_BANNER, response);

                                    progressBannerData(response);
                                }
                                break;
                            case 101:
                                ToastUtil.showToast(mContext, "https");
                                break;
                        }
                    }
                });
    }

    private void setBannerData() {
        List<String> imageUris = new ArrayList<>();
        for (int i = 0; i < bannerData.size(); i++) {
            imageUris.add(bannerData.get(i).getImgUrl());
        }
        //设置循环指示点
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //设置类似手风琴动画
        banner.setBannerAnimation(Transformer.Accordion);
        //设置图片集合
        banner.setImages(imageUris);
        //设置加载图片
        banner.setImageLoader(new ImageLoader() {

            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context)
                        .load(path)
                        .centerCrop()//图片自动填充
                        .into(imageView);
            }
        });
        banner.start();
    }

    private void progressBannerData(String json) {
        HomeHotBannerBean homeHotBannerBean = new Gson().fromJson(json, HomeHotBannerBean.class);
        bannerData = homeHotBannerBean.getData();

        setBannerData();
    }

    private void progressListViewData(String json) {
        //保存到本地
        CacheUtils.putString(mContext, LIST_VIEW_DATA, json);

        HomeHotListViewBean homeHotListViewBean = new Gson().fromJson(json, HomeHotListViewBean.class);
        listviewData = homeHotListViewBean.getData();

        //如果有头先清除两个头
        listViewHot.removeHeaderView(topSearch);
        listViewHot.removeHeaderView(ll_banner);


        //再清除集合数据，并刷新适配器
        if (listViewAdapter != null) {//防止在没网，还没缓存的情况下，打开app,出现下拉刷新空指针错误
            listViewAdapter.clearData();
        }

        //设置适配器数据
        setAdapter();

        handler.removeMessages(1);//刷新成功，移除停止刷新消息

        refresh.finishRefresh();//结束刷新动画

        refresh.setLoadMore(true);//这时有数据了，恢复设置可上啦刷新
    }
}
