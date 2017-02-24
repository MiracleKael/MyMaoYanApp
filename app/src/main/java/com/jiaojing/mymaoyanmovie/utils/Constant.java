package com.jiaojing.mymaoyanmovie.utils;

/**
 * Created by jiaojing on 2016/11/30.
 * 作用：常量类
 */
public class Constant {
    //今日推荐页URL
    public static final String  TODAYRECOMM = "http://api.meituan.com/dianying/posters.json?city_id=1&poster_type=1&__vhost=api.maoyan.com&utm_campaign=AmovieBmovieCD-1&movieBundleVersion=6801&utm_source=hiapk&utm_medium=android&utm_term=6.8.0&utm_content=860311023305964&ci=1&net=255&dModel=MI%203&uuid=F096369352E4004DD3758BF83FE24AC312445F9B51AD3D8FCE2A0CD57754F6E4&lat=0.0&lng=0.0&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1463656383990&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=09cbe8d3-3cb0-4e54-bc41-8f0b3387cdf2&__skcy=RbOZVh%2BK%2Bf86K3WlGJYg4ls7DIU%3D";

    //首页热映
    public static final String HOME_HOT_BASE = "http://m.maoyan.com/movie/list.json?type=hot&";

    //热映界面-ViewPager
    public static final String  HOME_HOT_ViewPager = "http://advert.mobile.meituan.com/api/v3/adverts?cityid=1&category=11&version=6.8.0&new=0&app=movie&clienttp=android&uuid=FCFAB9D8DD339645D629C8372A29A2C6AD16F9C9E87AF9AC0D656B29DD5AC6DE&devid=866641027400542&uid=&movieid=&partner=1&apptype=1&smId=&utm_campaign=AmovieBmovieCD-1&movieBundleVersion=6801&utm_source=qq&utm_medium=android&utm_term=6.8.0&utm_content=866641027400542&ci=1&net=255&dModel=HM%20NOTE%201LTETD&lat=40.100855&lng=116.378273&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1463730432992&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=01f9c5c0-eb56-4e19-92fb-b86b16ad79da&__skcy=5K8wRR%2FKYAZDTgmAzbhrXi%2FomzU%3D";

    //待映
    public static final String  HOME_WAIT = "http://api.meituan.com/mmdb/movie/v2/list/rt/order/coming.json?ci=1&limit=12&token=&__vhost=api.maoyan.com&utm_campaign=AmovieBmovieCD-1&movieBundleVersion=6801&utm_source=xiaomi&utm_medium=android&utm_term=6.8.0&utm_content=868030022327462&net=255&dModel=MI%205&uuid=0894DE03C76F6045D55977B6D4E32B7F3C6AAB02F9CEA042987B380EC5687C43&lat=40.100673&lng=116.378619&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1463704714271&__skua=7e01cf8dd30a179800a7a93979b430b2&__skno=1a0b4a9b-44ec-42fc-b110-ead68bcc2824&__skcy=sXcDKbGi20CGXQPPZvhCU3%2FkzdE%3D";
    //待映---预告片
    public static final String HOME_WAIT_TRAILER = "http://api.maoyan.com/mmdb/movie/lp/list.json?utm_campaign=AmovieBmovieCD-1&movieBundleVersion=7601&utm_source=meituan&utm_medium=android&utm_term=7.6.0&utm_content=000000000000000&ci=1&net=13&dModel=Android%20SDK%20built%20for%20x86_64&uuid=DD912D1B051F987F2712A1A48E82FD578BEA3ADF987122065B356025C2BF818F&refer=/Welcome";
    //待映---近期最受期待
    public static final String HOME_WAIT_HOT = "http://api.maoyan.com/mmdb/movie/v1/list/wish/order/coming.json?offset=0&limit=50&ci=1";
    //找片 上面三个
    public static final String HOME_FIND_SCROLL = "http://api.maoyan.com/mmdb/search/movie/tag/types.json?token=&utm_campaign=AmovieBmovieCD-1&movieBundleVersion=7601&utm_source=meituan&utm_medium=android&utm_term=7.6.0&utm_content=000000000000000&ci=1&net=13&dModel=Android%20SDK%20built%20for%20x86_64&uuid=DD912D1B051F987F2712A1A48E82FD578BEA3ADF987122065B356025C2BF818F&refer=/Welcome";
    //找片 中间
    public static final String HOME_FIND_GRIDVIEW = "http://api.maoyan.com/mmdb/movieboard/fixedboard/v1/hot/list.json?utm_campaign=AmovieBmovieCD-1&movieBundleVersion=7601&utm_source=meituan&utm_medium=android&utm_term=7.6.0&utm_content=000000000000000&ci=1&net=13&dModel=Android%20SDK%20built%20for%20x86_64&uuid=DD912D1B051F987F2712A1A48E82FD578BEA3ADF987122065B356025C2BF818F&refer=/Welcome";
    //找片  底部电影奖项
    public static final String HOME_FIND_AWARD = "http://api.maoyan.com/mmdb/movie/winning/film/2016-12-02/list.json?utm_campaign=AmovieBmovieCD-1&movieBundleVersion=7601&utm_source=meituan&utm_medium=android&utm_term=7.6.0&utm_content=000000000000000&ci=1&net=13&dModel=Android SDK built for x86_64&uuid=DD912D1B051F987F2712A1A48E82FD578BEA3ADF987122065B356025C2BF818F&refer=/Welcome";

    //发现页面上面
    public static final String Find_TOP = "http://api.maoyan.com/sns/v2/buttons.json?utm_campaign=AmovieBmovieCD-1&movieBundleVersion=7601&utm_source=meizu&utm_medium=android&utm_term=7.6.0&utm_content=865479028905735&ci=1&net=255&dModel=MX4&uuid=F02F61DCB963FEAF421EF2B0673996706BABCBA6FA9412580E90681C52CB9B11&lat=40.10077&lng=116.378582&__reqTraceID=3549463187063305748&refer=%2FWelcome&__skck=6a375bce8c66a0dc293860dfa83833ef&__skts=1480832640407&__skua=32bcf146c756ecefe7535b95816908e3&__skno=f9b222bf-f57d-4c18-ac19-52c3bd199905&__skcy=rSQm2Bkrgr%2BJHs31LsskUzU0FT8%3D";
    //发现页面recycleview
    public static final String Find_NEWS = "http://api.maoyan.com/sns/v5/feed.json?";
    //影院页面
    public static final String Find_CINEMA_LISTVIEW = "http://m.maoyan.com/cinemas.json";

    //搜索-热门搜索
    public static final String SEARCH_HOT = "http://api.meituan.com/mmdb/search/movie/hotword/list.json?token=&__vhost=api.maoyan.com";










}
