package com.jiaojing.mymaoyanmovie.home.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.jiaojing.mymaoyanmovie.R;
import com.jiaojing.mymaoyanmovie.home.bean.WaitHotBean;
import com.jiaojing.mymaoyanmovie.home.bean.WaitPlayBean;
import com.jiaojing.mymaoyanmovie.home.bean.WaitTrailerBean;
import com.jiaojing.mymaoyanmovie.utils.Constant;
import com.jiaojing.mymaoyanmovie.utils.ToastUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.Call;
import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

/**
 * Created by jiaojing on 2016/12/1.
 * 作用：xxx
 */
public class WaitBeanAdapter2 extends BaseAdapter implements StickyListHeadersAdapter, SectionIndexer {
    /**
     * 视频
     */
    private static final int TYPE_TRAILER = 0;

    /**
     * 图片
     */
    private static final int TYPE_HOT = 1;

    /**
     * 文字
     */
    private static final int TYPE_PRESALE = 2;


    private static final String PRE_FliM = "预告片推荐";
    private static final String RECENT_THO = "近期最受期待";
    private Context mContext;
    private WaitPlayBean.DataBean waitPlayBeanData;
    private LayoutInflater mInflater;

    private int[] mSectionIndices;
    private String[] mSectionHeaders;
    private LinearLayout mGallery;
    private LinearLayout ll_hot;

    //定义hashMap 用来存放之前创建的每一项item
    HashMap<Integer, View> lmap = new HashMap<Integer, View>();
    private List<WaitTrailerBean.DataBean> waitTrailerBeanData;

    public WaitBeanAdapter2(Context context, WaitPlayBean.DataBean waitPlayBeanData) {
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
        for (int i = 2; i < mSectionIndices.length; i++) {
            sectionHeaders[i] = waitPlayBeanData.getComing().get(mSectionIndices[i]-2).getComingTitle();
        }
        for(int i= 0;i<sectionHeaders.length;i++){
            Log.e("TAG", "mSectionIndices=="+sectionHeaders[i]);
        }
        return sectionHeaders;
    }

    //得到每一组第一个item位置.已数组形式暂存
    private int[] getSectionposition() {
        List<Integer> list = new ArrayList<>();
        String lastDate = waitPlayBeanData.getComing().get(0).getComingTitle();
        list.add(2);
        for (int i = 1; i < waitPlayBeanData.getComing().size(); i++) {
            String rt = waitPlayBeanData.getComing().get(i).getComingTitle();
            if (!rt.equals(lastDate)) {
                lastDate = rt;
                list.add(2+i);
            }
        }
        for(int i= 0;i<list.size();i++){
            Log.e("TAG", "list=="+list.get(i));
        }
        int[] positon = new int[list.size() + 2];
        positon[0] = 0;
        positon[1] = 1;
        for (int i = 0; i < list.size(); i++) {
            positon[i + 2] = list.get(i);
        }
        for(int i= 0;i<positon.length;i++){
            Log.e("TAG", "mSectionIndices=="+positon[i]);
        }
        return positon;
    }


    //产生 分区头部的View
    @Override
    public View getHeaderView(int position, View convertView, ViewGroup parent) {
//        Log.e("TAG", "getHeaderView===========");
        HeadHolderView headHolder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.wait_head_view, parent, false);
            headHolder = new HeadHolderView();
            headHolder.tvHead = (TextView) convertView.findViewById(R.id.tv_headview);
            convertView.setTag(headHolder);
        } else {
            headHolder = (HeadHolderView) convertView.getTag();
        }


        String mSectionDate = mSectionHeaders[getSectionForPosition(position)];
        headHolder.tvHead.setText(mSectionDate);

        return convertView;
    }

    @Override
    public long getHeaderId(int position) {
//        Log.e("TAG", "getHeaderId===========");
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
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_TRAILER;
        } else if (position == 1) {
            return TYPE_HOT;
        } else {
            return TYPE_PRESALE;
        }

    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public int getCount() {
//        Log.e("TAG", "getCount==========");
        return waitPlayBeanData.getComing().size() + 2;
    }

    @Override
    public Object getItem(int position) {
//        Log.e("TAG", "getItem==========");
        if (position == 0) {
            return new ListView(mContext);
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
//        Log.e("TAG", "getItemId==========");
        return position;
    }


    //产生 列表行的View
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        Log.e("TAG", "getView==========");
        int itemViewType = getItemViewType(position);//当前itme是什么类型
        ViewHolder viewHolder;
        if (lmap.get(position) == null) {
            viewHolder = new ViewHolder();
            convertView = initTypeView(convertView, itemViewType, viewHolder, parent);

            convertView.setTag(viewHolder);
            lmap.put(position, convertView);
        } else {
            convertView = lmap.get(position);
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //绑定数据
        bindData(position, itemViewType, viewHolder);


        return convertView;
    }

    private void bindData(int position, int itemViewType, ViewHolder viewHolder) {
        switch (itemViewType){
            case TYPE_TRAILER:

                break;
            case TYPE_HOT:

                break;
            case TYPE_PRESALE:
                WaitPlayBean.DataBean.ComingBean comingBean = waitPlayBeanData.getComing().get(position - 2);
                //http://p0.meituan.net/movie/
                String url = comingBean.getImg();
                String substring = url.substring(32, url.length());
                String newUrl = "http://p0.meituan.net/movie/"+ substring;
                Glide.with(mContext).load(newUrl).into(viewHolder.ivWaitFilmImg);

//                viewHolder.ivWaitPlay = (ImageView) convertView.findViewById(R.id.iv_wait_play);
                viewHolder.tvWaitFlimname.setText(comingBean.getNm());
//                viewHolder.ivWaitThreeD = (ImageView) convertView.findViewById(R.id.iv_wait_threeD);
//                viewHolder.ivWaitImax = (ImageView) convertView.findViewById(R.id.iv_wait_imax);
//                viewHolder.tv2 = (TextView) convertView.findViewById(R.id.tv2);
//                viewHolder.tv1 = (TextView) convertView.findViewById(R.id.tv1);
//                viewHolder.tvWaitFocus = (TextView) convertView.findViewById(R.id.tv_wait_focus);
//                viewHolder.tvWaitShowinfo = (TextView) convertView.findViewById(R.id.tv_wait_showinfo);
//                viewHolder.btnWaitWish = (TextView) convertView.findViewById(R.id.btn_wait_wish);
//                viewHolder.btnWaitOrder = (TextView) convertView.findViewById(R.id.btn_wait_order);

                break;
        }

    }

    private void progressTrailerData(String response) {
        WaitTrailerBean waitTrailerBean = new Gson().fromJson(response, WaitTrailerBean.class);
        waitTrailerBeanData = waitTrailerBean.getData();


        for(int i =0 ;i< waitTrailerBeanData.size();i++ ){
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.railer_view, mGallery, false);
            ImageView img = (ImageView) inflate.findViewById(R.id.iv_tra);
            TextView tv_tra1 = (TextView) inflate.findViewById(R.id.tv_tra1);
            TextView tv_tra2 = (TextView) inflate.findViewById(R.id.tv_tra2);

            Glide.with(mContext).load(waitTrailerBeanData.get(i).getImg()).into(img);
            tv_tra1.setText(waitTrailerBeanData.get(i).getMovieName());
            tv_tra2.setText(waitTrailerBeanData.get(i).getOriginName());

            mGallery.addView(inflate);
        }
    }

    private View initTypeView(View convertView, int itemViewType, ViewHolder viewHolder, ViewGroup parent) {
        switch (itemViewType) {
            case TYPE_TRAILER:
                convertView = mInflater.inflate(R.layout.wait_trailer_view, parent, false);
                mGallery = (LinearLayout) convertView.findViewById(R.id.id_gallery);
                getTrailerDataFromNet();

                break;
            case TYPE_HOT:
//                convertView = mInflater.inflate(R.layout.list_texttwo, null);
                convertView = mInflater.inflate(R.layout.wait_hot_view, parent, false);
                ll_hot = (LinearLayout) convertView.findViewById(R.id.ll_hot);
                getHotDataFromNet();
//                viewHolder.textTwo = (TextView) convertView.findViewById(R.id.tv_two);
                break;
            case TYPE_PRESALE:
                convertView = mInflater.inflate(R.layout.item_wait_listview, null);

                viewHolder.ivWaitFilmImg = (ImageView) convertView.findViewById(R.id.iv_wait_film_img);
                viewHolder.ivWaitPlay = (ImageView) convertView.findViewById(R.id.iv_wait_play);
                viewHolder.tvWaitFlimname = (TextView) convertView.findViewById(R.id.tv_wait_flimname);
                viewHolder.ivWaitThreeD = (ImageView) convertView.findViewById(R.id.iv_wait_threeD);
                viewHolder.ivWaitImax = (ImageView) convertView.findViewById(R.id.iv_wait_imax);
                viewHolder.tv2 = (TextView) convertView.findViewById(R.id.tv2);
                viewHolder.tv1 = (TextView) convertView.findViewById(R.id.tv1);
                viewHolder.tvWaitFocus = (TextView) convertView.findViewById(R.id.tv_wait_focus);
                viewHolder.tvWaitShowinfo = (TextView) convertView.findViewById(R.id.tv_wait_showinfo);
                viewHolder.btnWaitWish = (TextView) convertView.findViewById(R.id.btn_wait_wish);
                viewHolder.btnWaitOrder = (TextView) convertView.findViewById(R.id.btn_wait_order);

                break;
        }
        return convertView;
    }

    private void getHotDataFromNet() {
        OkHttpUtils.get()
                .url(Constant.HOME_WAIT_HOT)
                .id(100)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        ToastUtil.showToast(mContext, "hot联网请求失败");
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        switch (id) {
                            case 100:
                                if (response != null) {
                                    progressHotData(response);

                                }
                                break;
                            case 101:
                                ToastUtil.showToast(mContext, "https");
                                break;
                        }
                    }
                });
    }

    private void progressHotData(String response) {
        WaitHotBean waitHotBean = new Gson().fromJson(response, WaitHotBean.class);
        List<WaitHotBean.DataBean.ComingBean> hotbean = waitHotBean.getData().getComing();

        for(int i =0 ;i< hotbean.size(); i++ ){
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.hot_view, ll_hot, false);
            ImageView img = (ImageView) inflate.findViewById(R.id.hot_img_film);
            TextView hot_txt_flimname = (TextView) inflate.findViewById(R.id.hot_txt_flimname);
            TextView hot_date = (TextView) inflate.findViewById(R.id.hot_date);
            TextView hot_want_watch = (TextView) inflate.findViewById(R.id.hot_want_watch);


            //http://p0.meituan.net/movie/
            String url = hotbean.get(i).getImg();
            String substring = url.substring(32, url.length());
            String newUrl = "http://p0.meituan.net/movie/"+ substring;
            Glide.with(mContext).load(newUrl).into(img);

            hot_txt_flimname.setText(hotbean.get(i).getNm());
            hot_date.setText(hotbean.get(i).getRt());
            hot_want_watch.setText(hotbean.get(i).getWish()+"人想看");

            ll_hot.addView(inflate);
        }
    }

    private void getTrailerDataFromNet() {
        OkHttpUtils.get()
                .url(Constant.HOME_WAIT_TRAILER)
                .id(100)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        ToastUtil.showToast(mContext, "tra联网请求失败");
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        switch (id) {
                            case 100:
                                if (response != null) {
                                    progressTrailerData(response);

                                }
                                break;
                            case 101:
                                ToastUtil.showToast(mContext, "https");
                                break;
                        }
                    }
                });


    }


    // 获取 分区的对象
    @Override
    public Object[] getSections() {
//        Log.e("TAG", "getSections==========");
        return mSectionHeaders;
    }


    // 通过 分区ID 返回 对应的 位置
    @Override
    public int getPositionForSection(int sectionIndex) {
//        Log.e("TAG", "getPositionForSection==========");
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
        if(position == 0){
            Log.e("TAG", "getSection11111==========0");
            return  0;
        }
        if(position == 1){
            Log.e("TAG", "getSection11111==========1");
            return  1;
        }
        for (int i = 2; i < mSectionIndices.length; i++) {
            if (position <= mSectionIndices[i]) {
                Log.e("TAG", "getSection2222222=========="+i);
                return i;
            }
        }
        return mSectionIndices.length -1;
    }

    static class HeadHolderView {
        TextView tvHead;
    }

    static class ViewHolder {
        //预告片栏目
        ListView textOne;
        //hOt栏目
        TextView textTwo;
        //第三部分
        ImageView ivWaitFilmImg;
        ImageView ivWaitPlay;
        TextView tvWaitFlimname;
        ImageView ivWaitThreeD;
        ImageView ivWaitImax;
        TextView tv2;
        TextView tv1;
        TextView tvWaitFocus;
        TextView tvWaitShowinfo;
        TextView btnWaitWish;
        TextView btnWaitOrder;


    }
}
