package com.jiaojing.mymaoyanmovie.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by jiaojing on 2016/11/30.
 * 作用：xxx
 */
public abstract class BaseFragment extends Fragment{
    public Context mContext;
    public com.jiaojing.mymaoyanmovie.base.LoadingPage loadingPage;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = View.inflate(mContext, getLayoutById(), null);
//        ButterKnife.bind(this, view);
//        initTitle();
//        return view;
        loadingPage = new com.jiaojing.mymaoyanmovie.base.LoadingPage(getActivity()) {

            @Override
            public int layoutId() {
                return getLayoutId();
            }

            @Override
            protected void onSuccess(ResultState resultState, View view_success) {
                ButterKnife.bind(BaseFragment.this, view_success);//绑定布局

                initTitle();

                initData(resultState.getContent());
            }

            @Override
            protected String url() {
                return getUrl();
            }
        };
        return loadingPage;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        show();
    }

    protected abstract String getUrl();

    protected abstract void initData(String content);

    protected abstract int getLayoutId();

    protected abstract void initTitle();

    //执行联网
    public void show(){
        loadingPage.show();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


}
