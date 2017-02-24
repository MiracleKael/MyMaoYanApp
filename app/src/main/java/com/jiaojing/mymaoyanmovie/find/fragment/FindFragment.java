package com.jiaojing.mymaoyanmovie.find.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.google.gson.Gson;
import com.jiaojing.mymaoyanmovie.R;
import com.jiaojing.mymaoyanmovie.base.BaseFragment;
import com.jiaojing.mymaoyanmovie.find.MyDecoration;
import com.jiaojing.mymaoyanmovie.find.adapter.FindNewsBeanAdapter;
import com.jiaojing.mymaoyanmovie.find.bean.FindNewsBean;
import com.jiaojing.mymaoyanmovie.utils.Constant;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.Bind;
import okhttp3.Call;

/**
 * Created by jiaojing on 2016/11/30.
 * 作用：xxx
 */
public class FindFragment extends BaseFragment {

    @Bind(R.id.find_recycle)
    RecyclerView findRecycle;
    @Bind(R.id.refresh)
    MaterialRefreshLayout refresh;
    private FindNewsBeanAdapter adapter;

    int count = 0;//上拉刷新了几次
    int offset = 0;//联网获取的数据哪个数据
    private FindNewsBean findNewsBean;


    @Override
    protected String getUrl() {
        return Constant.Find_NEWS +"offset=0";
    }

    @Override
    protected void initData(String content) {
        refresh.setLoadMore(true);//设置可上啦刷新
        if(content != ""){
            progressData(content);
        }
//        getDataFormNet();

        //监听刷新
        initRefreshLayout();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_find;
    }

    @Override
    protected void initTitle() {

    }

    //    @Override
//    protected int getLayoutById() {
//        return R.layout.fragment_find;
//    }

//    @Override
//    public void initData() {
//        super.initData();
//        refresh.setLoadMore(true);//设置可上啦刷新
//        getDataFormNet();
//
//        //监听刷新
//        initRefreshLayout();
//
//    }

    private void initRefreshLayout() {
        refresh.setMaterialRefreshListener(new MyMaterialRefreshListener());
    }
    class MyMaterialRefreshListener extends MaterialRefreshListener {
        //  下拉刷新
        @Override
        public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
            count = 0;//上拉刷新了几次
            offset = 0;//联网获取的数据哪个数据
            refreshData();
        }

        //上拉加载更多
        @Override
        public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {
            super.onRefreshLoadMore(materialRefreshLayout);
            loadMoreData();
        }
    }

    private void refreshData() {
        getDataFormNet();
        refresh.finishRefresh();
    }

    private void loadMoreData() {
        getMoreInfoFromNet();
        //刷新
        Log.e("TAG", "getItemCount===" + adapter.getItemCount());

        refresh.finishRefreshLoadMore();
    }

    private void getMoreInfoFromNet() {

        String newUpUrl = Constant.Find_NEWS + "offset=" + offset;

        OkHttpUtils.get()
                .id(100)
                .url(newUpUrl)
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
                                    count += 1;
                                    offset = 10 * count;

                                    FindNewsBean findNewsBeanMore = new Gson().fromJson(response, FindNewsBean.class);
                                    List<FindNewsBean.DataBean.FeedsBean> feeds = findNewsBeanMore.getData().getFeeds();

                                    //将新得到的数据添加到集合中
                                    adapter.addData(feeds);

                                }
                                break;
                        }
                    }
                });
    }

    private void getDataFormNet() {

        OkHttpUtils.get()
                .url(Constant.Find_NEWS +"offset=0")
                .id(100)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("TAG", "发现界面资讯联网失败");
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.e("TAG", "发现界面资讯联网成功");
                        switch (id) {
                            case 100:
                                if (response != null) {
                                    progressData(response);
                                }
                                break;
                        }
                    }
                });


    }

    private void progressData(String response) {
        count += 1;
        offset = 10 * count;

        findNewsBean = new Gson().fromJson(response, FindNewsBean.class);

        adapter = new FindNewsBeanAdapter(mContext, findNewsBean);
        findRecycle.setAdapter(adapter);
//
        LinearLayoutManager manager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        findRecycle.setLayoutManager(manager);
        //这句就是添加我们自定义的分隔线
        findRecycle.addItemDecoration(new MyDecoration(mContext, MyDecoration.VERTICAL_LIST));
    }

}
