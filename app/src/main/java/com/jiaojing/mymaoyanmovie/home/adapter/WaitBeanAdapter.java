package com.jiaojing.mymaoyanmovie.home.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiaojing.mymaoyanmovie.R;
import com.jiaojing.mymaoyanmovie.home.bean.WaitPlayBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.ButterKnife;
import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

/**
 * Created by jiaojing on 2016/12/1.
 * 作用：xxx
 */
public class WaitBeanAdapter extends BaseAdapter implements StickyListHeadersAdapter, SectionIndexer {



    private static final String PRE_FliM = "预告片";
    private static final String RECENT_THO = "近期较热";
    private Context mContext;
    private WaitPlayBean.DataBean waitPlayBeanData;
    private LayoutInflater mInflater;

    private int[] mSectionIndices;
    private String[] mSectionHeaders;

    //定义hashMap 用来存放之前创建的每一项item
    HashMap<Integer, View> lmap = new HashMap<Integer, View>();

    public WaitBeanAdapter(Context context, WaitPlayBean.DataBean waitPlayBeanData) {
        mContext = context;
        this.waitPlayBeanData = waitPlayBeanData;
        mInflater = LayoutInflater.from(mContext);
        mSectionIndices = getSectionposition();
        mSectionHeaders = getSectionDate();


    }

    //得到每一组的头部,
    private String[] getSectionDate() {
        String[] sectionHeaders = new String[mSectionIndices.length];
        sectionHeaders[0] = PRE_FliM;
        sectionHeaders[1] = RECENT_THO;
        for (int i = 0; i < mSectionIndices.length - 2; i++) {
            sectionHeaders[i + 2] = waitPlayBeanData.getComing().get(mSectionIndices[i + 2]).getComingTitle();
        }
        return sectionHeaders;
    }

    //得到每一组第一个item位置.已数组形式暂存
    private int[] getSectionposition() {
        List<Integer> list = new ArrayList<>();
        String lastDate = waitPlayBeanData.getComing().get(0).getComingTitle();
        list.add(0);
        for (int i = 1; i < waitPlayBeanData.getComing().size(); i++) {
            String rt = waitPlayBeanData.getComing().get(i).getComingTitle();
            if (!rt.equals(lastDate)) {
                lastDate = rt;
                list.add(i);
            }
        }
        int[] positon = new int[list.size() + 2];
        positon[0] = 0;
        positon[1] = 1;
        for (int i = 0; i < list.size(); i++) {
            positon[i + 2] = list.get(i);
        }
        return positon;
    }

    //产生 分区头部的View
    @Override
    public View getHeaderView(int position, View convertView, ViewGroup parent) {
        Log.e("TAG", "getHeaderView===========");
        HeadHolderView headHolder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.wait_head_view, parent, false);
            headHolder = new HeadHolderView();
            headHolder.tvHead = (TextView) convertView.findViewById(R.id.tv_headview);
            convertView.setTag(headHolder);
        } else {
            headHolder = (HeadHolderView) convertView.getTag();
        }
        String mSectionDate = mSectionHeaders[position];
        headHolder.tvHead.setText(mSectionDate);

        return convertView;
    }

    @Override
    public long getHeaderId(int position) {
        Log.e("TAG", "getHeaderId===========");
        if (position == 0) {
            return 0;
        }
        if (position == 1) {
            return 1;
        } else {
            String rt = waitPlayBeanData.getComing().get(position - 2).getComingTitle();
            for (int i = 0; i < mSectionHeaders.length; i++) {
                if (rt.equals(mSectionHeaders[i])) {
                    return i + 2;
                }
            }
        }

//        Log.e("TAG","return====0");
        return 0;
    }

    @Override
    public int getCount() {
        Log.e("TAG", "getCount==========");
        return waitPlayBeanData.getComing().size() + 2;
    }

    @Override
    public Object getItem(int position) {
        Log.e("TAG", "getItem==========");
        if (position == 0) {
            return new TextView(mContext);
        }
        if (position == 1) {
            return new TextView(mContext);
        }
        if (position == 2) {
            return waitPlayBeanData.getComing().get(position - 2);
        }
        return "";
    }

    @Override
    public long getItemId(int position) {
        Log.e("TAG", "getItemId==========");
        return position;
    }


    //产生 列表行的View
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.e("TAG", "getView==========");
        ViewHolder holder;
        if (position == 0) {
            convertView = mInflater.inflate(R.layout.list_textone, parent, false);
            holder = new ViewHolder(convertView);
            holder.tv_one.setText("我去");

            lmap.put(position, convertView);
        }
        if (position == 1) {

//            convertView = View.inflate(mContext, R.layout.list_texttwo, null);
            convertView = mInflater.inflate(R.layout.list_texttwo, parent, false);
            lmap.put(position, convertView);
        }
        if (position >= 2) {

            if (lmap.get(position) == null) {
                convertView = View.inflate(mContext, R.layout.item_wait_listview, null);
                holder = new ViewHolder(convertView);
                convertView.setTag(holder);
                lmap.put(position, convertView);
            } else {
                convertView = lmap.get(position);
                holder = (ViewHolder) convertView.getTag();
            }

            WaitPlayBean.DataBean.ComingBean comingBean = waitPlayBeanData.getComing().get(position - 2);
            String imgUrl = comingBean.getImg();
            String substring = imgUrl.substring(32, imgUrl.length());
            String newUrl = "http://p0.meituan.net/165.220/movie/"+ substring;
                    Glide.with(mContext)
                    .load(newUrl)
                    .into(holder.ivWaitFilmImg);

            holder.tvWaitFlimname.setText(comingBean.getNm());
            holder.tv2.setText(comingBean.getWish()+"");
            holder.tvWaitFocus.setText(comingBean.getScm());
            holder.tvWaitShowinfo.setText(comingBean.getDesc());

        }

        return convertView;
    }


    // 获取 分区的对象
    @Override
    public Object[] getSections() {
        Log.e("TAG", "getSections==========");
        return mSectionHeaders;
    }


    // 通过 分区ID 返回 对应的 位置
    @Override
    public int getPositionForSection(int sectionIndex) {
        Log.e("TAG", "getPositionForSection==========");
        if (sectionIndex >= mSectionIndices.length) {
            sectionIndex = mSectionIndices.length - 1;
        } else if (sectionIndex < 0) {
            sectionIndex = 0;
        }
        return mSectionIndices[sectionIndex];
    }

    // 通过 位置 返回 对应的分区ID
    @Override
    public int getSectionForPosition(int position) {
        Log.e("TAG", "getSectionForPosition==========");
        for (int i = 0; i < mSectionIndices.length; i++) {
            if (position < mSectionIndices[i]) {
                return i - 1;
            }
        }
        return mSectionIndices.length - 1;
    }

    static class HeadHolderView {
        TextView tvHead;
    }

    static class ViewHolder {
        private ImageView ivWaitFilmImg;
        private ImageView ivWaitPlay;
        private TextView tvWaitFlimname;
        private ImageView ivWaitThreeD;
        private ImageView ivWaitImax;
        private TextView tv2;
        private TextView tv1;
        private TextView tvWaitFocus;
        private TextView tvWaitShowinfo;
        private TextView btnWaitWish;
        private TextView btnWaitOrder;

//            ivWaitFilmImg = (ImageView)findViewById( R.id.iv_wait_film_img );
//            ivWaitPlay = (ImageView)findViewById( R.id.iv_wait_play );
//            tvWaitFlimname = (TextView)findViewById( R.id.tv_wait_flimname );
//            ivWaitThreeD = (ImageView)findViewById( R.id.iv_wait_threeD );
//            ivWaitImax = (ImageView)findViewById( R.id.iv_wait_imax );
//            tv2 = (TextView)findViewById( R.id.tv2 );
//            tv1 = (TextView)findViewById( R.id.tv1 );
//            tvWaitFocus = (TextView)findViewById( R.id.tv_wait_focus );
//            tvWaitShowinfo = (TextView)findViewById( R.id.tv_wait_showinfo );
//            btnWaitWish = (TextView)findViewById( R.id.btn_wait_wish );
//            btnWaitOrder = (TextView)findViewById( R.id.btn_wait_order );


        private TextView tv_one;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
//            tv_one = (TextView) view.findViewById(R.id.tv_one);
        }
    }
}
