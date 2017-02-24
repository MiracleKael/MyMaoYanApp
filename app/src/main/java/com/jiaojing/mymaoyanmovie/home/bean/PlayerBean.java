package com.jiaojing.mymaoyanmovie.home.bean;

import java.util.List;

/**
 * Created by jiaojing on 2016/12/9.
 * 作用：xxx
 */
public class PlayerBean {

    /**
     * globalReleased : true
     * image : http://p0.meituan.net/w.h/movie/018ceaadb90ac5c1b9ba33546d1fb746401981.jpg
     * name : 血战钢锯岭
     * pubdesc : 2016-12-08大陆上映
     * score : 9.4
     * showSt : 3
     * ver : 2D/中国巨幕
     * wish : 32064
     * wishst : 0
     */

    private MovieVOBean movieVO;
    /**
     * comment : 44
     * count : 480038
     * id : 82137
     * img : http://p1.meituan.net/w.h/movie/1953971b19f7e0491a81d36973a62a2518591.jpg
     * logoVideoUrl : http://v.meituan.net/movie/videos/d07ce826b984436cb79bde9c9e78e5d2.mp4
     * movieId : 338349
     * movieName : 血战钢锯岭
     * pubTime : 2016.12.08
     * score : 9.4
     * showSt : 3
     * tl : “孤胆傲志”预告片
     * tm : 119
     * type : 1
     * url : http://maoyan.meituan.net/movie/videos/854x480cacd191cf0ef4a37808da1fb590c3bf2.mp4
     * wish : 32064
     */

    private List<VlistBean> vlist;

    public MovieVOBean getMovieVO() {
        return movieVO;
    }

    public void setMovieVO(MovieVOBean movieVO) {
        this.movieVO = movieVO;
    }

    public List<VlistBean> getVlist() {
        return vlist;
    }

    public void setVlist(List<VlistBean> vlist) {
        this.vlist = vlist;
    }

    public static class MovieVOBean {
        private boolean globalReleased;
        private String image;
        private String name;
        private String pubdesc;
        private double score;
        private int showSt;
        private String ver;
        private int wish;
        private int wishst;

        public boolean isGlobalReleased() {
            return globalReleased;
        }

        public void setGlobalReleased(boolean globalReleased) {
            this.globalReleased = globalReleased;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPubdesc() {
            return pubdesc;
        }

        public void setPubdesc(String pubdesc) {
            this.pubdesc = pubdesc;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public int getShowSt() {
            return showSt;
        }

        public void setShowSt(int showSt) {
            this.showSt = showSt;
        }

        public String getVer() {
            return ver;
        }

        public void setVer(String ver) {
            this.ver = ver;
        }

        public int getWish() {
            return wish;
        }

        public void setWish(int wish) {
            this.wish = wish;
        }

        public int getWishst() {
            return wishst;
        }

        public void setWishst(int wishst) {
            this.wishst = wishst;
        }
    }

    public static class VlistBean {
        private int comment;
        private int count;
        private int id;
        private String img;
        private String logoVideoUrl;
        private int movieId;
        private String movieName;
        private String pubTime;
        private double score;
        private int showSt;
        private String tl;
        private int tm;
        private int type;
        private String url;
        private int wish;

        public int getComment() {
            return comment;
        }

        public void setComment(int comment) {
            this.comment = comment;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getLogoVideoUrl() {
            return logoVideoUrl;
        }

        public void setLogoVideoUrl(String logoVideoUrl) {
            this.logoVideoUrl = logoVideoUrl;
        }

        public int getMovieId() {
            return movieId;
        }

        public void setMovieId(int movieId) {
            this.movieId = movieId;
        }

        public String getMovieName() {
            return movieName;
        }

        public void setMovieName(String movieName) {
            this.movieName = movieName;
        }

        public String getPubTime() {
            return pubTime;
        }

        public void setPubTime(String pubTime) {
            this.pubTime = pubTime;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public int getShowSt() {
            return showSt;
        }

        public void setShowSt(int showSt) {
            this.showSt = showSt;
        }

        public String getTl() {
            return tl;
        }

        public void setTl(String tl) {
            this.tl = tl;
        }

        public int getTm() {
            return tm;
        }

        public void setTm(int tm) {
            this.tm = tm;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getWish() {
            return wish;
        }

        public void setWish(int wish) {
            this.wish = wish;
        }
    }
}
