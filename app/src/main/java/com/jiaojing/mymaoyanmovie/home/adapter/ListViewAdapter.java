package com.jiaojing.mymaoyanmovie.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiaojing.mymaoyanmovie.R;
import com.jiaojing.mymaoyanmovie.home.activity.JieCaoViewActivity;
import com.jiaojing.mymaoyanmovie.home.bean.HomeHotListViewBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by jiaojing on 2016/11/30.
 * 作用：xxx
 */
public class ListViewAdapter extends BaseAdapter {
    private Context mContext;
    private final List<HomeHotListViewBean.DataBean.MoviesBean> moviesBeanList;

    public ListViewAdapter(Context context, HomeHotListViewBean.DataBean listviewData) {
        mContext = context;
        moviesBeanList = listviewData.getMovies();
    }

    @Override
    public int getCount() {
        return moviesBeanList == null ? 0 : moviesBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return moviesBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_hot_listview, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        //获取数据
        final HomeHotListViewBean.DataBean.MoviesBean moviesBean = moviesBeanList.get(position);

        //装配数据
        if (position == 0) {
            holder.llZhuantiZixun.setVisibility(View.VISIBLE);

        } else {
            holder.llZhuantiZixun.setVisibility(View.GONE);
        }
        Glide.with(mContext)
                .load(moviesBean.getImg())
                .into(holder.ivHotFilmImg);
        holder.tvHotFlimname.setText(moviesBean.getNm());
        holder.tvHotScore.setText(moviesBean.getSc() + "");
        holder.tvHotFocus.setText(moviesBean.getScm());
        if (moviesBean.getPreSale() == 1) {//预售
            holder.tvHotShowinfo.setText(moviesBean.getRt());
            //购票不显示
            holder.btnHotBuy.setVisibility(View.GONE);
            //预售显示
            holder.btnHotOrder.setVisibility(View.VISIBLE);
        } else if (moviesBean.getPreSale() == 0) {
            holder.tvHotShowinfo.setText(moviesBean.getShowInfo());
            //购票显示
            holder.btnHotBuy.setVisibility(View.VISIBLE);
            //预售不显示
            holder.btnHotOrder.setVisibility(View.GONE);
        }
        if (moviesBean.isValue3d()) {
            //显示3D
            holder.ivHotThreeD.setVisibility(View.VISIBLE);
        } else {
            //显示3D
            holder.ivHotThreeD.setVisibility(View.GONE);
        }
        if (moviesBean.isImax()) {
            holder.ivHotImax.setVisibility(View.VISIBLE);
        } else {
            holder.ivHotImax.setVisibility(View.GONE);
        }


        //图片点击事件
        holder.rlPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = moviesBean.getId();
                String url = "http://api.meituan.com/mmdb/movie/"+ id + "/videos.json?__vhost=api.maoyan.com&utm_campaign=AmovieBmovieC110189035496448D-1&movieBundleVersion=246188&utm_source=meituan&utm_medium=android&utm_term=6.8.0&utm_content=1464192000000&ci=1&net=255&dModel=VPhone&uuid=34E86498880DD102B3AE536CBD0B91E1AE9AF35457763EC65E9904EE5A5BC752&lat=39.906899375649395&lng=116.39723909965588";
                Intent intent = new Intent(mContext, JieCaoViewActivity.class);
                intent.putExtra("playerurl",url);
                mContext.startActivity(intent);
            }
        });


        return convertView;
    }

    public void clearData() {
        moviesBeanList.clear();
        notifyDataSetChanged();
    }

    public void addData(List<HomeHotListViewBean.DataBean.MoviesBean> newListData) {
        moviesBeanList.addAll(moviesBeanList.size(), newListData);
        notifyDataSetChanged();
    }

    //得到当前电影的id
    public int getFilmId(int position) {
        return moviesBeanList.get(position - 2).getId();
    }

    static class ViewHolder {
        @Bind(R.id.iv_hot_film_img)
        ImageView ivHotFilmImg;
        @Bind(R.id.iv_hot_play)
        ImageView ivHotPlay;
        @Bind(R.id.tv_hot_flimname)
        TextView tvHotFlimname;
        @Bind(R.id.iv_hot_imax)
        ImageView ivHotImax;
        @Bind(R.id.tv_hot_score)
        TextView tvHotScore;
        @Bind(R.id.tv_hot_focus)
        TextView tvHotFocus;
        @Bind(R.id.tv_hot_showinfo)
        TextView tvHotShowinfo;
        @Bind(R.id.btn_hot_buy)
        TextView btnHotBuy;
        @Bind(R.id.btn_hot_order)
        TextView btnHotOrder;
        @Bind(R.id.iv_hot_threeD)
        ImageView ivHotThreeD;
        @Bind(R.id.tv_zhuanti)
        TextView tvZhuanti;
        @Bind(R.id.tv_zixun)
        TextView tvZixun;
        @Bind(R.id.ll_zhuanti_zixun)
        LinearLayout llZhuantiZixun;
        @Bind(R.id.rl_play)
        RelativeLayout rlPlay;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}
