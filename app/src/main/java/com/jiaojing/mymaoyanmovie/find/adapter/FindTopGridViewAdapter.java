package com.jiaojing.mymaoyanmovie.find.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiaojing.mymaoyanmovie.R;
import com.jiaojing.mymaoyanmovie.find.bean.FindFourButton;

import java.util.List;

/**
 * Created by jiaojing on 2016/12/6.
 * 作用：xxx
 */
public class FindTopGridViewAdapter extends BaseAdapter{
    private Context mContext;
    private  List<FindFourButton.DataBean> findFourButtonData;
    public FindTopGridViewAdapter(Context context, List<FindFourButton.DataBean> findFourButtonData) {
        mContext = context;
        this.findFourButtonData=findFourButtonData;
    }

    @Override
    public int getCount() {
        return findFourButtonData == null ? 0 : findFourButtonData.size();
    }

    @Override
    public Object getItem(int position) {
        return findFourButtonData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            convertView = View.inflate(mContext, R.layout.item_find_top,null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        //
        FindFourButton.DataBean dataBean = findFourButtonData.get(position);
        //
        holder.find_top_tv.setText(dataBean.getTitle());
        Glide.with(mContext)
                .load(dataBean.getImage().getUrl())
                .into(holder.find_top_img);

        return convertView;
    }
    class ViewHolder{
        private TextView find_top_tv;
        private ImageView find_top_img;

        public ViewHolder(View convertView) {
            find_top_img = (ImageView) convertView.findViewById(R.id.find_top_img);
            find_top_tv = (TextView) convertView.findViewById(R.id.find_top_tv);
        }

    }
}
