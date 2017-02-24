package com.jiaojing.mymaoyanmovie.home.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiaojing.mymaoyanmovie.R;
import com.jiaojing.mymaoyanmovie.home.bean.FindGridViewBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by jiaojing on 2016/12/4.
 * 作用：xxx
 */
public class FindGridViewAdapter extends BaseAdapter {
    private Context mContext;
    private List<FindGridViewBean.DataBean> findGridViewBeanData;

    public FindGridViewAdapter(Context context, List<FindGridViewBean.DataBean> data) {
        mContext = context;
        findGridViewBeanData = data;
    }


    @Override
    public int getCount() {
        return findGridViewBeanData == null ? 0 : findGridViewBeanData.size();
    }

    @Override
    public Object getItem(int position) {
        return findGridViewBeanData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_find_gridview, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        //得到数据
        FindGridViewBean.DataBean dataBean = findGridViewBeanData.get(position);

        //装配数据
        holder.findGridBoardname.setText(dataBean.getBoardName());
        if(position == 1){
            holder.findGridBoardname.setTextColor(Color.parseColor("#F35947"));
        }else if(position == 2){
            holder.findGridBoardname.setTextColor(Color.parseColor("#F7893F"));
        }else if(position ==3){
            holder.findGridBoardname.setTextColor(Color.parseColor("#7CC53A"));
        }
        holder.findGridMoivename.setText(dataBean.getMovieName());
        String url1 = dataBean.getMovieImgs().get(0);
        String url2 = dataBean.getMovieImgs().get(1);

        String substring1 = url1.substring(32, url1.length());
        String substring2 = url2.substring(32, url2.length());

        String newUrl1 = "http://p0.meituan.net/165.220/movie/" + substring1;
        String newUrl2 = "http://p0.meituan.net/165.220/movie/" + substring2;

        Glide.with(mContext).load(newUrl1).into(holder.findGridImg2);
        Glide.with(mContext).load(newUrl2).into(holder.findGridImg1);

        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.find_grid_boardname)
        TextView findGridBoardname;
        @Bind(R.id.find_grid_moivename)
        TextView findGridMoivename;
        @Bind(R.id.find_grid_img1)
        ImageView findGridImg1;
        @Bind(R.id.find_grid_img2)
        ImageView findGridImg2;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}
