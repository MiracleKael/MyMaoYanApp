package com.jiaojing.mymaoyanmovie.find.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.jiaojing.mymaoyanmovie.R;
import com.jiaojing.mymaoyanmovie.find.bean.FindFourButton;
import com.jiaojing.mymaoyanmovie.find.bean.FindNewsBean;
import com.jiaojing.mymaoyanmovie.utils.Constant;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import okhttp3.Call;

/**
 * Created by jiaojing on 2016/12/5.
 * 作用：xxx
 */
public class FindNewsBeanAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    /**
     * 5种类型
     */
    /**
     * 头部
     */
    public static final int TYPE_TOP = 0;//头部
    /**
     * type2
     */
    public static final int TYPE_TWO = 2;//左边一张图片，右边一段文字
    /**
     * type3
     */
    public static final int TYPE_THREE = 3;//三个等大小的图片


    /**
     * type4
     */
    public static final int TYPE_FOUR = 4;//一张大图片，两张小图片
    /**
     * type5
     */
    public static final int TYPE_FIVE = 5;//左边一张图片,点击播放视频，右边一段文字

    public static final int TYPE_SEVEN = 7;//上面一段文字，下面一张大图


    /**
     * 当前类型
     */
    public int currentType ;

    private Context mContext;
    private LayoutInflater mLayouInflaster;
    private final List<FindNewsBean.DataBean.FeedsBean> feedsBeans;

    public FindNewsBeanAdapter(Context context, FindNewsBean findNewsBean) {
        mContext = context;
        feedsBeans = findNewsBean.getData().getFeeds();
        mLayouInflaster = LayoutInflater.from(mContext);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(currentType == TYPE_TOP){
           return new  TypeToptViewHoler(mLayouInflaster.inflate(R.layout.item_type_top,null),mContext);
        }
        if (currentType == TYPE_THREE) {
            return new TypeThreeViewHoler(mLayouInflaster.inflate(R.layout.item_type_three, null), mContext);
        }
        if (currentType == TYPE_FIVE) {
            return new TypeFiveViewHoler(mLayouInflaster.inflate(R.layout.item_type_five, null), mContext);
        }
        if (currentType == TYPE_TWO) {
            return new TypeTwoViewHoler(mLayouInflaster.inflate(R.layout.item_type_two, null), mContext);

        }
        if (currentType == TYPE_FOUR) {
            return new TypeFourViewHoler(mLayouInflaster.inflate(R.layout.item_type_four, null), mContext);

        }if(currentType == TYPE_SEVEN){
            return new TypeSevenViewHoler(mLayouInflaster.inflate(R.layout.item_type_seven, null), mContext);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);

        if(itemViewType == TYPE_TOP){
            TypeToptViewHoler typeTopViewHoler = (TypeToptViewHoler) holder;
            typeTopViewHoler.setData();
        }else if (itemViewType == TYPE_FIVE) {
            TypeFiveViewHoler typeFiveViewHoler = (TypeFiveViewHoler) holder;
            typeFiveViewHoler.setData(feedsBeans.get(position - 1));
        }else if (itemViewType == TYPE_THREE) {
            TypeThreeViewHoler typeThreeViewHoler = (TypeThreeViewHoler) holder;
            typeThreeViewHoler.setData(feedsBeans.get(position - 1));
        }else if (itemViewType == TYPE_TWO) {
            TypeTwoViewHoler typeTwoViewHoler = (TypeTwoViewHoler) holder;
            typeTwoViewHoler.setData(feedsBeans.get(position - 1));
        }else if (itemViewType == TYPE_FOUR) {
            TypeFourViewHoler typeFourViewHoler = (TypeFourViewHoler) holder;
            typeFourViewHoler.setData(feedsBeans.get(position - 1));
        }
        else if (itemViewType == TYPE_SEVEN) {
            TypeSevenViewHoler typeSevenViewHoler = (TypeSevenViewHoler) holder;
            typeSevenViewHoler.setData(feedsBeans.get(position - 1));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            currentType = TYPE_TOP;
            return currentType;
        }else{
            int feedType = feedsBeans.get(position - 1).getStyle();
            switch (feedType) {
                case 2:
                    currentType = TYPE_TWO;
                    break;
                case 3:
                    currentType = TYPE_THREE;
                    break;

                case 4:
                    currentType = TYPE_FOUR;
                    break;
                case 5:
                    currentType = TYPE_FIVE;
                    break;
                case 7:
                    currentType = TYPE_SEVEN;
                    break;
            }
            return currentType;
        }
    }

    @Override
    public int getItemCount() {
        return feedsBeans.size()+1;
    }

    //添加上拉刷新增加的数据
    public void addData(List<FindNewsBean.DataBean.FeedsBean> feeds) {
        feedsBeans.addAll(feeds);
        notifyDataSetChanged();
    }

    //头部的适配器
    class TypeToptViewHoler extends RecyclerView.ViewHolder {
        private Context mContext;
        private GridView find_gridview;

        public TypeToptViewHoler(View itemView, Context context) {
            super(itemView);
            mContext = context;
            find_gridview = (GridView) itemView.findViewById(R.id.find_gridview);
        }


        public void setData() {
            OkHttpUtils.get()
                    .id(100)
                    .url(Constant.Find_TOP)
                    .build()
                    .execute(new StringCallback() {
                        @Override
                        public void onError(Call call, Exception e, int id) {
                            Log.e("TAG", "发现界面四个联网失败");
                        }

                        @Override
                        public void onResponse(String response, int id) {
                            Log.e("TAG", "发现界面四个联网成功");
                            switch (id) {
                                case 100:
                                    if (response != null) {
                                        FindFourButton findFourButton = new Gson().fromJson(response, FindFourButton.class);
                                        List<FindFourButton.DataBean> findFourButtonData = findFourButton.getData();
                                        com.jiaojing.mymaoyanmovie.find.adapter.FindTopGridViewAdapter adapter = new com.jiaojing.mymaoyanmovie.find.adapter.FindTopGridViewAdapter(mContext, findFourButtonData);
                                        find_gridview.setAdapter(adapter);

//                                        for (int i = 0; i < findFourButtonData.size(); i++) {
//                                            if (i == 0) {
//                                                find_tv01.setText(findFourButtonData.get(0).getTitle());
//                                                Glide.with(mContext)
//                                                        .load(findFourButtonData.get(0).getImage().getUrl())
//                                                        .into(find_img01);
//                                            }
//                                            if (i == 1) {
//                                                find_tv02.setText(findFourButtonData.get(1).getTitle());
//                                                Glide.with(mContext)
//                                                        .load(findFourButtonData.get(1).getImage().getUrl())
//                                                        .into(find_img02);
//                                            }
//                                            if (i == 2) {
//                                                find_tv03.setText(findFourButtonData.get(2).getTitle());
//                                                Glide.with(mContext)
//                                                        .load(findFourButtonData.get(2).getImage().getUrl())
//                                                        .into(find_img03);
//                                            }
//                                            if (i == 3) {
//                                                find_tv04.setText(findFourButtonData.get(3).getTitle());
//                                                Glide.with(mContext)
//                                                        .load(findFourButtonData.get(3).getImage().getUrl())
//                                                        .into(find_img04);
//                                            }
//                                        }

                                    }
                                    break;
                            }

                        }
                    });
        }
    }

    //type7类型的适配器
    class TypeSevenViewHoler extends RecyclerView.ViewHolder {
        private TextView type_seven_title;
        private TextView type_seven_from;
        private TextView type_seven_watch;
        private TextView type_seven_discuss;
        private ImageView type_seven_img;
        public TypeSevenViewHoler(View itemView,  Context mContext) {
            super(itemView);
            type_seven_img = (ImageView) itemView.findViewById(R.id.type_seven_img);
            type_seven_title = (TextView) itemView.findViewById(R.id.type_seven_title);
            type_seven_from = (TextView) itemView.findViewById(R.id.type_seven_from);
            type_seven_watch = (TextView) itemView.findViewById(R.id.type_seven_watch);
            type_seven_discuss = (TextView) itemView.findViewById(R.id.type_seven_discuss);
        }

        public void setData(FindNewsBean.DataBean.FeedsBean feedsBean) {

            Glide.with(mContext).load(feedsBean.getImages().get(0).getUrl()).into(type_seven_img);
            type_seven_title.setText(feedsBean.getTitle());

        }
    }


    //type4类型的适配器
    class TypeFiveViewHoler extends RecyclerView.ViewHolder {
        private TextView type_four_title;
        private ImageView type_four_img;
        private TextView type_four_from;
        private TextView type_four_watch;
        private TextView type_four_discuss;

        private Context mContext;

        public TypeFiveViewHoler(View itemView,  Context context) {
            super(itemView);
            mContext = context;
            type_four_title = (TextView) itemView.findViewById(R.id.type_four_title);
            type_four_img = (ImageView) itemView.findViewById(R.id.type_four_img);
            type_four_from = (TextView) itemView.findViewById(R.id.type_four_from);
            type_four_watch = (TextView) itemView.findViewById(R.id.type_four_watch);
            type_four_discuss = (TextView) itemView.findViewById(R.id.type_four_discuss);
        }

        public void setData(FindNewsBean.DataBean.FeedsBean feedsBean) {
            type_four_title.setText(feedsBean.getTitle());
            String url = feedsBean.getImages().get(0).getUrl();
            String substring = url.substring(28, url.length());

            Glide.with(mContext).load("http://p0.meituan.net/165.220/movie/"+substring).into(type_four_img);

            type_four_from.setText(feedsBean.getUser().getNickName());
            type_four_watch.setText(feedsBean.getViewCount()+"");
            type_four_discuss.setText(feedsBean.getUser().getTopicCount()+"");
        }
    }

    //type8类型的适配器
    class TypeFourViewHoler extends RecyclerView.ViewHolder {

        private TextView type_eight_title;
        private ImageView type_eight_img1;
        private ImageView type_eight_img2;
        private ImageView type_eight_img3;
        private TextView type_eight_from;
        private TextView type_eight_watch;
        private TextView type_eight_discuss;

        private Context mContext;
        public TypeFourViewHoler(View itemView, Context context) {
            super(itemView);
            mContext = context;
            type_eight_title = (TextView) itemView.findViewById(R.id.type_eight_title);
            type_eight_img1 = (ImageView) itemView.findViewById(R.id.type_eight_img1);
            type_eight_img2 = (ImageView) itemView.findViewById(R.id.type_eight_img2);
            type_eight_img3 = (ImageView) itemView.findViewById(R.id.type_eight_img3);
            type_eight_from = (TextView) itemView.findViewById(R.id.type_eight_from);
            type_eight_watch = (TextView) itemView.findViewById(R.id.type_eight_watch);
            type_eight_discuss = (TextView) itemView.findViewById(R.id.type_eight_discuss);
        }

        public void setData(FindNewsBean.DataBean.FeedsBean feedsBean) {

            type_eight_title.setText(feedsBean.getTitle());
            String url1 = feedsBean.getImages().get(0).getUrl();
            String substring1 = url1.substring(28, url1.length());
            String url2 = feedsBean.getImages().get(1).getUrl();
            String substring2 = url2.substring(28, url2.length());
            String url3 = feedsBean.getImages().get(2).getUrl();
            String substring3 = url3.substring(28, url3.length());

            Glide.with(mContext).load("http://p0.meituan.net/165.220/movie/"+substring1).into(type_eight_img1);
            Glide.with(mContext).load("http://p0.meituan.net/165.220/movie/"+substring2).into(type_eight_img2);
            Glide.with(mContext).load("http://p0.meituan.net/165.220/movie/"+substring3).into(type_eight_img3);

            type_eight_from.setText(feedsBean.getUser().getNickName());
            type_eight_watch.setText(feedsBean.getViewCount()+"");
            type_eight_discuss.setText(feedsBean.getUser().getTopicCount()+"");
        }
    }


    //type7类型的适配器
    class TypeTwoViewHoler extends RecyclerView.ViewHolder {
        private TextView type_seven_title;
        private ImageView type_seven_img;
        private TextView type_seven_from;
        private TextView type_seven_watch;
        private TextView type_seven_discuss;

        private Context mContext;

        public TypeTwoViewHoler(View itemView, Context context) {
            super(itemView);
            mContext = context;
            type_seven_title = (TextView) itemView.findViewById(R.id.type_seven_title);
            type_seven_img = (ImageView) itemView.findViewById(R.id.type_seven_img);
            type_seven_from = (TextView) itemView.findViewById(R.id.type_seven_from);
            type_seven_watch = (TextView) itemView.findViewById(R.id.type_seven_watch);
            type_seven_discuss = (TextView) itemView.findViewById(R.id.type_seven_discuss);
        }

        public void setData(FindNewsBean.DataBean.FeedsBean feedsBean) {
            type_seven_title.setText(feedsBean.getTitle());
            String url = feedsBean.getImages().get(0).getUrl();
            String substring = url.substring(28, url.length());

            Glide.with(mContext).load("http://p0.meituan.net/165.220/movie/"+substring).into(type_seven_img);
            FindNewsBean.DataBean.FeedsBean.UserBean user = feedsBean.getUser();
            if(user != null){//判断有没有user
                type_seven_from.setText(feedsBean.getUser().getNickName());
                type_seven_discuss.setText(feedsBean.getUser().getTopicCount()+"");
            }
            type_seven_watch.setText(feedsBean.getViewCount()+"");

        }
    }

    //type2类型的适配器器
    class TypeThreeViewHoler extends RecyclerView.ViewHolder {
        private TextView type_two_title;
        private ImageView type_two_img01;
        private ImageView type_two_img02;
        private ImageView type_two_img03;
        private TextView type_two_from;
        private TextView type_two_watch;
        private TextView type_two_discuss;

        private Context mContext;

        public TypeThreeViewHoler(View itemView, Context context) {
            super(itemView);
            mContext = context;
            type_two_title = (TextView) itemView.findViewById(R.id.type_two_title);
            type_two_img01 = (ImageView) itemView.findViewById(R.id.type_two_img01);
            type_two_img02 = (ImageView) itemView.findViewById(R.id.type_two_img02);
            type_two_img03 = (ImageView) itemView.findViewById(R.id.type_two_img03);
            type_two_from = (TextView) itemView.findViewById(R.id.type_two_from);
            type_two_watch = (TextView) itemView.findViewById(R.id.type_two_watch);
            type_two_discuss = (TextView) itemView.findViewById(R.id.type_two_discuss);

        }


        public void setData(FindNewsBean.DataBean.FeedsBean feedsBean) {
            type_two_title.setText(feedsBean.getTitle());
            List<FindNewsBean.DataBean.FeedsBean.ImagesBean> images = feedsBean.getImages();

            Log.e("TAG","feedsBean====="+feedsBean.getTitle());
            if(images.size() != 0){
                String url1 = images.get(0).getUrl();
                String substring1 = url1.substring(28, url1.length());
                String url2 = images.get(1).getUrl();
                String substring2 = url2.substring(28, url2.length());
                String url3 = images.get(2).getUrl();
                String substring3 = url3.substring(28, url3.length());

                Glide.with(mContext).load("http://p0.meituan.net/165.220/movie/"+substring1).into(type_two_img01);
                Glide.with(mContext).load("http://p0.meituan.net/165.220/movie/"+substring2).into(type_two_img02);
                Glide.with(mContext).load("http://p0.meituan.net/165.220/movie/"+substring3).into(type_two_img03);
            }else{
                type_two_img01.setVisibility(View.GONE);
                type_two_img02.setVisibility(View.GONE);
                type_two_img03.setVisibility(View.GONE);
            }

            FindNewsBean.DataBean.FeedsBean.UserBean user = feedsBean.getUser();
            if(user != null){//判断有没有user
                type_two_from.setText(feedsBean.getUser().getNickName());
                type_two_discuss.setText(feedsBean.getUser().getTopicCount()+"");
            }
            type_two_watch.setText(feedsBean.getViewCount()+"");



        }
    }
}
