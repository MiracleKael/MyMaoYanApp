package com.jiaojing.mymaoyanmovie.cinema.adapter;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.jiaojing.mymaoyanmovie.R;
import com.jiaojing.mymaoyanmovie.bean.ChangpingCounty;
import com.jiaojing.mymaoyanmovie.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

/**
 * Created by jiaojing on 2016/12/6.
 * 作用：xxx
 */
public class CinemaHeadListviewAdapter extends BaseAdapter implements StickyListHeadersAdapter, SectionIndexer {
    private Context mContext;
    private ArrayList<ChangpingCounty> countrylists;
    private int[] mSectionIndices;
    private String[] mSectionHeaders;
    private LayoutInflater mInflater;
    private PopupWindow popupWindow;
    private PopupWindow mPopupwindow;

    public CinemaHeadListviewAdapter(Context context, ArrayList<ChangpingCounty> countrylists) {
        mContext = context;
        this.countrylists = countrylists;
        mInflater = LayoutInflater.from(mContext);
//        mSectionIndices = getSectionposition();
//        mSectionHeaders = getSectionDate();
    }

//    private String[] getSectionDate() {
//        String[] sectionHeaders = new String[mSectionIndices.length];
//
//        return new String[0];
//    }
//
//    private int[] getSectionposition() {
//        int[] positon = new int[1];
//        positon[0] = 0;//只有第一个位置有头
//
//        return positon;
//    }

    @Override
    public View getHeaderView(int position, View convertView, ViewGroup parent) {
        if (position == 0) {//只有potion==0时添加一个头
            HeadViewHolder holder;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.cinema_headlistview_head, parent, false);
                holder = new HeadViewHolder(convertView);
                convertView.setTag(holder);
            } else {
                holder = (HeadViewHolder) convertView.getTag();
            }

            //设置监听
            final View finalConvertView = convertView;
            holder.tv_area.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showAreaPopupWindow(finalConvertView);
                }
            });

        }


        return convertView;
    }


    private  ListView listview_left ;
    private ListView listview_right ;
    private void showAreaPopupWindow(View finalConvertView) {
        View view = mInflater.inflate(R.layout.popupwindow_area, null);
        mPopupwindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        listview_left = (ListView) view.findViewById(R.id.listview_left);
        listview_right = (ListView) view.findViewById(R.id.listview_right);

        String[] city = new String[]{"全部","朝阳区","海淀区","大兴区", "东城区","丰台区","西城区","通州区","昌平区","房山区", "顺义区","门头沟区","石景山区","怀柔区","平谷区","密云县","延庆县"};

        List<String> cities = new ArrayList<>();
        for(int i=0; i<city.length; i++){
            cities.add(city[i]);
        }
        //设置左边listview的适配器
        final com.jiaojing.mymaoyanmovie.cinema.adapter.ListviewLeftAdapter leftAdapter = new com.jiaojing.mymaoyanmovie.cinema.adapter.ListviewLeftAdapter(mContext, cities);
        listview_left.setAdapter(leftAdapter);
        listview_left.setSelection(0);

        //设置item点击事件
        listview_left.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                leftAdapter.setSelectedFirstPosition(position);
                leftAdapter.notifyDataSetChanged();
                updateRightListView(position);//更新第二个listview中的信息
            }
        });

        //显示popupwindow
        mPopupwindow.setTouchInterceptor(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
                    popupWindow.dismiss();
                    return true;
                }
                return false;
            }
        });


        mPopupwindow.setBackgroundDrawable(new BitmapDrawable());
        //显示位置
        mPopupwindow.showAsDropDown(finalConvertView);

    }

    private void updateRightListView(int position) {
        /**
         * 第二个listview的数据
         */
        String[][] sub_items = new String[][] {
                new String[]{},
                new String[] { "1-1", "1-2", "1-3", "1-4", "1-5","1-6","1-7","1-8","1-9"},
                new String[] { "2-1", "2-2", "2-3", "2-4", "2-5","2-6","2-7","2-8","2-9"},
                new String[] { "3-1", "3-2", "3-3", "3-4", "3-5","3-6","3-7","3-8","3-9"},
                new String[] { "4-1", "4-2", "4-3", "4-4", "4-5","4-6","4-7","4-8","4-9"},
                new String[] { "5-1", "5-2", "5-3", "5-4", "5-5","5-6","5-7","5-8","5-9"},
                new String[] { "5-1", "5-2", "5-3", "5-4", "5-5","5-6","5-7","5-8","5-9"},
                new String[] { "6-1", "6-2", "6-3", "6-4", "6-5","6-6","6-7","6-8","6-9"},
                new String[] { "7-1", "7-2", "7-3", "7-4", "7-5","7-6","7-7","7-8","7-9"} };

        List<String> list = new ArrayList<>();
        String[] sub_item = sub_items[position];
        for(int i=0; i< sub_item.length; i++){
            list.add(sub_item[i]);
        }
        com.jiaojing.mymaoyanmovie.cinema.adapter.ListviewRightAdapter rightAdapter = new com.jiaojing.mymaoyanmovie.cinema.adapter.ListviewRightAdapter(mContext,list);
        listview_right.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ToastUtil.showToast(mContext, "点击了位置"+position);
                mPopupwindow.dismiss();
            }
        });

        listview_right.setAdapter(rightAdapter);

    }

    class HeadViewHolder {
        public TextView tv_area;
        public HeadViewHolder(View convertView) {
            tv_area = (TextView) convertView.findViewById(R.id.tv_area);
        }
    }

    @Override
    public long getHeaderId(int position) {
        return 1;
    }

    @Override
    public int getCount() {
        return countrylists.size();
    }

    @Override
    public Object getItem(int position) {
        return countrylists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_cinema_listview, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        ChangpingCounty changpingCounty = countrylists.get(position);
        holder.cinemaName.setText(changpingCounty.getNm());
        holder.cinemaLocation.setText(changpingCounty.getAddr());
        holder.minPrice.setText("" + changpingCounty.getSellPrice());

        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.cinema_name)
        TextView cinemaName;
        @Bind(R.id.min_price)
        TextView minPrice;
        @Bind(R.id.cinema_location)
        TextView cinemaLocation;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    @Override
    public Object[] getSections() {
        return new Object[0];
    }

    @Override
    public int getPositionForSection(int sectionIndex) {
        return 0;
    }

    @Override
    public int getSectionForPosition(int position) {
        return 0;
    }

}
