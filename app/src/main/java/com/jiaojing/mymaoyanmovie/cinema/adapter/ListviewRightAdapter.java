package com.jiaojing.mymaoyanmovie.cinema.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jiaojing.mymaoyanmovie.R;

import java.util.List;

/**
 * Created by jiaojing on 2016/12/8.
 * 作用：xxx
 */
public class ListviewRightAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> mList;
    public ListviewRightAdapter(Context context, List<String> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            convertView = View.inflate(mContext, R.layout.right_listview_item, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);

        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        //
        holder.tv_location.setText(mList.get(position));
        return convertView;
    }
    class ViewHolder{
        TextView tv_location;
        public ViewHolder(View convertView) {
            tv_location = (TextView) convertView.findViewById(R.id.tv_location);
        }
    }
}
