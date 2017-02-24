package com.jiaojing.mymaoyanmovie.cinema.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jiaojing.mymaoyanmovie.R;
import com.jiaojing.mymaoyanmovie.base.BaseFragment;
import com.jiaojing.mymaoyanmovie.bean.ChangpingCounty;
import com.jiaojing.mymaoyanmovie.cinema.adapter.CinemaHeadListviewAdapter;
import com.jiaojing.mymaoyanmovie.home.activity.SearchCinena;
import com.jiaojing.mymaoyanmovie.home.ui.MyViewPagerIndicator;
import com.jiaojing.mymaoyanmovie.utils.CacheUtils;
import com.jiaojing.mymaoyanmovie.utils.Constant;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.Bind;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/**
 * Created by jiaojing on 2016/11/30.
 * 作用：xxx
 */
public class CinemaFragment extends BaseFragment {
    public static final String CITY = "city";
    @Bind(R.id.tv_city_show)
    TextView tvCityShow;
    @Bind(R.id.tv_cinema)
    TextView tvCinema;
    @Bind(R.id.iv_search_cinema)
    ImageView ivSearchCinema;
    @Bind(R.id.indicator)
    MyViewPagerIndicator indicator;
    @Bind(R.id.cinema_head_listview)
    StickyListHeadersListView cinemaHeadListview;
    private ArrayList<ChangpingCounty> countrylists;

    private LinearLayout cinema_top_img;
    private ImageView img;

    @Override
    protected String getUrl() {
        return Constant.Find_CINEMA_LISTVIEW;
    }

    @Override
    protected void initData(String content) {
        String city = CacheUtils.getString(mContext, CITY);
        if (city != null) {
            tvCityShow.setText(city);
        }

        cinema_top_img = (LinearLayout) View.inflate(mContext, R.layout.cinema_top_img, null);
        img = (ImageView) cinema_top_img.findViewById(R.id.cinema_top);
        cinemaHeadListview.addHeaderView(cinema_top_img);

        if(content != ""){
            progressCinemaData(content);
        }
//        getDataFromNet();

        //搜索点击监听
        ivSearchCinema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, SearchCinena.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_cinema;
    }

    @Override
    protected void initTitle() {
        tvCityShow.setVisibility(View.VISIBLE);
        indicator.setVisibility(View.GONE);
        tvCinema.setVisibility(View.VISIBLE);
        ivSearchCinema.setVisibility(View.VISIBLE);
    }


//    private void getDataFromNet() {
//        OkHttpUtils.get()
//                .id(100)
//                .url(Constant.Find_CINEMA_LISTVIEW)
//                .build()
//                .execute(new StringCallback() {
//                    @Override
//                    public void onError(Call call, Exception e, int id) {
//                        Log.e("TAG", "影院页面======失败");
//                    }
//
//                    @Override
//                    public void onResponse(String response, int id) {
//                        Log.e("TAG", "影院页面======成功");
//                        switch (id) {
//                            case 100:
//                                if (response != null) {
//                                    progressCinemaData(response);
//
//                                }
//                                break;
//                        }
//                    }
//                });
//
//    }


    private void progressCinemaData(String json) {
//            new Gson().fromJson(json, CinemaInfo.class);

        countrylists = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject data = jsonObject.getJSONObject("data");

            JSONArray changping = data.getJSONArray("昌平区");
            if(changping != null && changping.length()>0){

                for(int i=0; i<changping.length();i++){
                    JSONObject item = (JSONObject) changping.get(i);

                    //创建类
                    ChangpingCounty changpingCounty = new ChangpingCounty();

                    int sellPrice = item.getInt("sellPrice");
                    changpingCounty.setSellPrice(sellPrice);
                    double lat = item.getDouble("lat");
                    changpingCounty.setLat(lat);

                    double lng = item.getDouble("lng");
                    changpingCounty.setLng(lng);

                    String addr = item.getString("addr");
                    changpingCounty.setAddr(addr);
                    String area = item.getString("area");
                    changpingCounty.setArea(area);
                    int poiId = item.getInt("poiId");
                    changpingCounty.setPoiId(poiId);
                    String nm = item.getString("nm");
                    changpingCounty.setNm(nm);
                    String ct = item.getString("ct");
                    changpingCounty.setCt(ct);
                    int preferential = item.getInt("preferential");
                    changpingCounty.setPreferential(preferential);
                    int sellmin = item.getInt("sellmin");
                    changpingCounty.setSellmin(sellmin);
                    boolean sell = item.getBoolean("sell");
                    changpingCounty.setSell(sell);
                    int imax = item.getInt("imax");
                    changpingCounty.setImax(imax);
                    String brd = item.getString("brd");
                    changpingCounty.setBrd(brd);
                    String dis = item.getString("dis");
                    changpingCounty.setDis(dis);
                    int deal = item.getInt("deal");
                    changpingCounty.setDeal(deal);
                    int distance = item.getInt("distance");
                    changpingCounty.setDistance(distance);
                    int follow = item.getInt("follow");
                    changpingCounty.setFollow(follow);
                    int id = item.getInt("id");
                    changpingCounty.setId(id);
                    int showCount = item.getInt("showCount");
                    changpingCounty.setShowCount(showCount);
                    int referencePrice = item.getInt("referencePrice");
                    changpingCounty.setReferencePrice(referencePrice);
                    int brdId = item.getInt("brdId");
                    changpingCounty.setBrdId(brdId);
                    int dealPrice = item.getInt("dealPrice");
                    changpingCounty.setDealPrice(dealPrice);

                    countrylists.add(changpingCounty);

                }

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


        CinemaHeadListviewAdapter adapter =  new CinemaHeadListviewAdapter(mContext, countrylists);
        cinemaHeadListview.setAdapter(adapter);

    }

}
