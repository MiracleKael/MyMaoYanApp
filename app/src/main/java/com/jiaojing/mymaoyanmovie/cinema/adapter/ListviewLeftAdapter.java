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
public class ListviewLeftAdapter extends BaseAdapter{
    private Context mContext;
    private List<String> cities;
    public ListviewLeftAdapter(Context context, List<String> cities) {
        mContext = context;
        this.cities = cities;
    }

    @Override
    public int getCount() {
        return cities.size();
    }

    @Override
    public Object getItem(int position) {
        return cities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            convertView = View.inflate(mContext, R.layout.left_listview_item, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv_city.setText(cities.get(position));


        //选中和没选中时，设置不同的颜色
        if (position == selectedPosition){
            convertView.setBackgroundResource(R.color.popup_right_bg);
        }else{
            convertView.setBackgroundResource(R.drawable.selector_left_normal);
        }

        return convertView;

    }

    public int selectedPosition = 0;

    public void setSelectedFirstPosition(int selectedPosition) {
        this.selectedPosition = selectedPosition;
    }

    public int getSelectedFirstPosition() {
        return selectedPosition;
    }


    class ViewHolder{
        TextView tv_city;

        public ViewHolder(View convertView) {
            tv_city = (TextView) convertView.findViewById(R.id.tv_city);
        }
    }
}
