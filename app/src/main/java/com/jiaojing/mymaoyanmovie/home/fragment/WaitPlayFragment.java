package com.jiaojing.mymaoyanmovie.home.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.google.gson.Gson;
import com.jiaojing.mymaoyanmovie.R;
import com.jiaojing.mymaoyanmovie.base.BaseFragment;
import com.jiaojing.mymaoyanmovie.home.adapter.WaitBeanAdapter2;
import com.jiaojing.mymaoyanmovie.home.bean.WaitPlayBean;
import com.jiaojing.mymaoyanmovie.home.bean.WaitTrailerBean;
import com.jiaojing.mymaoyanmovie.utils.Constant;
import com.jiaojing.mymaoyanmovie.utils.ToastUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/**
 * Created by jiaojing on 2016/11/30.
 * 作用：xxx
 */
public class WaitPlayFragment extends BaseFragment {


    @Bind(R.id.stickyListView)
    StickyListHeadersListView stickyListView;
    @Bind(R.id.refresh)
    MaterialRefreshLayout refresh;
    private WaitPlayBean.DataBean waitPlayBeanData;

    private LinearLayout topSearch;
    private LinearLayout ll_tra;
    private List<WaitTrailerBean.DataBean> waitTrailerBeanData;

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
        return Constant.HOME_WAIT;
    }

    @Override
    protected void initData(String content) {
//        getDataFromNet();

        topSearch = (LinearLayout) View.inflate(mContext, R.layout.fragment_top_search, null);
        stickyListView.addHeaderView(topSearch);

        if (content != null) {
            progressWaitData(content);
        }
        initRefreshLayout();

    }

    private void initRefreshLayout() {
        refresh.setMaterialRefreshListener(new MyMaterialRefreshListener());
    }
    class MyMaterialRefreshListener extends MaterialRefreshListener {
        //  下拉刷新
        @Override
        public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
            refreshData();

        }

        //上拉加载更多
        @Override
        public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {
            super.onRefreshLoadMore(materialRefreshLayout);
//            loadMoreData();
        }
    }

    private void refreshData() {
        handler.sendEmptyMessageDelayed(1, 8000);
        getDataFromNet();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_wait;
    }

    @Override
    protected void initTitle() {
    }

//    @Override
//    protected int getLayoutById() {
//        return R.layout.fragment_home_wait;
//    }

//    @Override
//    public void initData() {
//        super.initData();
//        getDataFromNet();
//
//        topSearch = (LinearLayout) View.inflate(mContext, R.layout.fragment_top_search, null);
//        stickyListView.addHeaderView(topSearch);
////        stickyListView.addHeaderView(srcolloview);
//
//    }

    private void getDataFromNet() {


        OkHttpUtils.get()
                .url(Constant.HOME_WAIT)
                .id(100)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        ToastUtil.showToast(mContext, "wait联网请求失败");
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        switch (id) {
                            case 100:
                                if (response != null) {
                                    progressWaitData(response);

                                }
                                break;
                            case 101:
                                ToastUtil.showToast(mContext, "https");
                                break;
                        }
                    }
                });
    }


    private void progressWaitData(String json) {
        WaitPlayBean waitPlayBean = new Gson().fromJson(json, WaitPlayBean.class);
        waitPlayBeanData = waitPlayBean.getData();
        if(waitPlayBean != null){
            WaitBeanAdapter2 adapter = new WaitBeanAdapter2(mContext, waitPlayBeanData);
            stickyListView.setAdapter(adapter);

            handler.removeMessages(1);//刷新成功，移除停止刷新消息

            refresh.finishRefresh();//结束刷新动画
        }

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
}
