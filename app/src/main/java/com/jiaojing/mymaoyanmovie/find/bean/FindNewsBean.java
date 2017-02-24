package com.jiaojing.mymaoyanmovie.find.bean;

import java.util.List;

/**
 * Created by jiaojing on 2016/12/5.
 * 作用：xxx
 */
public class FindNewsBean {


    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * hasMore : true
         * limit : 10
         * offset : 0
         * total : 0
         */

        private PagingBean paging;
        private long timestamp;
        /**
         * commentCount : 10
         * description :
         * feedType : 7
         * id : 23716
         * images : [{"authorId":0,"height":512,"id":2781436,"sizeType":0,"targetId":17120,"targetType":13,"url":"http://p0.meituan.net/movie/8b616f72fee6298cd3643ad7aadc9c18193462.jpg@300w_225h_1e_1c","width":512}]
         * style : 2
         * time : 1480984740000
         * title : 《银魂》首曝角色海报，这是你期待的坂田银时吗
         * upCount : 10
         * url : meituanmovie://www.meituan.com/forum/newsDetail?id=17120
         * user : {"age":"25","authInfo":"","avatarType":255,"avatarurl":"http://p1.meituan.net/avatar/1fae1268d70810edf668395dc7a74bfc18495.jpg","birthday":-2240553600000,"city":{"deleted":false,"id":1,"nm":"北京","py":"beijing"},"currentExp":15,"gender":0,"id":332456130,"interest":"","juryLevel":0,"maoyanAge":"0.5","marriage":"","nextTitle":"","nickName":"猫眼资讯","occupation":"","registerTime":1459394732000,"roleType":0,"signature":"","title":"青铜会员","topicCount":0,"totalExp":130,"uid":0,"userLevel":1,"userNextLevel":2,"username":"maoyan_movie","vipInfo":"官方","vipType":1,"visitorCount":41}
         * viewCount : 747
         */

        private List<FeedsBean> feeds;

        public PagingBean getPaging() {
            return paging;
        }

        public void setPaging(PagingBean paging) {
            this.paging = paging;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }

        public List<FeedsBean> getFeeds() {
            return feeds;
        }

        public void setFeeds(List<FeedsBean> feeds) {
            this.feeds = feeds;
        }

        public static class PagingBean {
            private boolean hasMore;
            private int limit;
            private int offset;
            private int total;

            public boolean isHasMore() {
                return hasMore;
            }

            public void setHasMore(boolean hasMore) {
                this.hasMore = hasMore;
            }

            public int getLimit() {
                return limit;
            }

            public void setLimit(int limit) {
                this.limit = limit;
            }

            public int getOffset() {
                return offset;
            }

            public void setOffset(int offset) {
                this.offset = offset;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }
        }

        public static class FeedsBean {
            private int commentCount;
            private String description;
            private int feedType;
            private int id;
            private int style;
            private long time;
            private String title;
            private int upCount;
            private String url;
            /**
             * age : 25
             * authInfo :
             * avatarType : 255
             * avatarurl : http://p1.meituan.net/avatar/1fae1268d70810edf668395dc7a74bfc18495.jpg
             * birthday : -2240553600000
             * city : {"deleted":false,"id":1,"nm":"北京","py":"beijing"}
             * currentExp : 15
             * gender : 0
             * id : 332456130
             * interest :
             * juryLevel : 0
             * maoyanAge : 0.5
             * marriage :
             * nextTitle :
             * nickName : 猫眼资讯
             * occupation :
             * registerTime : 1459394732000
             * roleType : 0
             * signature :
             * title : 青铜会员
             * topicCount : 0
             * totalExp : 130
             * uid : 0
             * userLevel : 1
             * userNextLevel : 2
             * username : maoyan_movie
             * vipInfo : 官方
             * vipType : 1
             * visitorCount : 41
             */

            private UserBean user;
            private int viewCount;
            /**
             * authorId : 0
             * height : 512
             * id : 2781436
             * sizeType : 0
             * targetId : 17120
             * targetType : 13
             * url : http://p0.meituan.net/movie/8b616f72fee6298cd3643ad7aadc9c18193462.jpg@300w_225h_1e_1c
             * width : 512
             */

            private List<ImagesBean> images;

            public int getCommentCount() {
                return commentCount;
            }

            public void setCommentCount(int commentCount) {
                this.commentCount = commentCount;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getFeedType() {
                return feedType;
            }

            public void setFeedType(int feedType) {
                this.feedType = feedType;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getStyle() {
                return style;
            }

            public void setStyle(int style) {
                this.style = style;
            }

            public long getTime() {
                return time;
            }

            public void setTime(long time) {
                this.time = time;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getUpCount() {
                return upCount;
            }

            public void setUpCount(int upCount) {
                this.upCount = upCount;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public UserBean getUser() {
                return user;
            }

            public void setUser(UserBean user) {
                this.user = user;
            }

            public int getViewCount() {
                return viewCount;
            }

            public void setViewCount(int viewCount) {
                this.viewCount = viewCount;
            }

            public List<ImagesBean> getImages() {
                return images;
            }

            public void setImages(List<ImagesBean> images) {
                this.images = images;
            }

            public static class UserBean {
                private String age;
                private String authInfo;
                private int avatarType;
                private String avatarurl;
                private long birthday;
                /**
                 * deleted : false
                 * id : 1
                 * nm : 北京
                 * py : beijing
                 */

                private CityBean city;
                private int currentExp;
                private int gender;
                private int id;
                private String interest;
                private int juryLevel;
                private String maoyanAge;
                private String marriage;
                private String nextTitle;
                private String nickName;
                private String occupation;
                private long registerTime;
                private int roleType;
                private String signature;
                private String title;
                private int topicCount;
                private int totalExp;
                private int uid;
                private int userLevel;
                private int userNextLevel;
                private String username;
                private String vipInfo;
                private int vipType;
                private int visitorCount;

                public String getAge() {
                    return age;
                }

                public void setAge(String age) {
                    this.age = age;
                }

                public String getAuthInfo() {
                    return authInfo;
                }

                public void setAuthInfo(String authInfo) {
                    this.authInfo = authInfo;
                }

                public int getAvatarType() {
                    return avatarType;
                }

                public void setAvatarType(int avatarType) {
                    this.avatarType = avatarType;
                }

                public String getAvatarurl() {
                    return avatarurl;
                }

                public void setAvatarurl(String avatarurl) {
                    this.avatarurl = avatarurl;
                }

                public long getBirthday() {
                    return birthday;
                }

                public void setBirthday(long birthday) {
                    this.birthday = birthday;
                }

                public CityBean getCity() {
                    return city;
                }

                public void setCity(CityBean city) {
                    this.city = city;
                }

                public int getCurrentExp() {
                    return currentExp;
                }

                public void setCurrentExp(int currentExp) {
                    this.currentExp = currentExp;
                }

                public int getGender() {
                    return gender;
                }

                public void setGender(int gender) {
                    this.gender = gender;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getInterest() {
                    return interest;
                }

                public void setInterest(String interest) {
                    this.interest = interest;
                }

                public int getJuryLevel() {
                    return juryLevel;
                }

                public void setJuryLevel(int juryLevel) {
                    this.juryLevel = juryLevel;
                }

                public String getMaoyanAge() {
                    return maoyanAge;
                }

                public void setMaoyanAge(String maoyanAge) {
                    this.maoyanAge = maoyanAge;
                }

                public String getMarriage() {
                    return marriage;
                }

                public void setMarriage(String marriage) {
                    this.marriage = marriage;
                }

                public String getNextTitle() {
                    return nextTitle;
                }

                public void setNextTitle(String nextTitle) {
                    this.nextTitle = nextTitle;
                }

                public String getNickName() {
                    return nickName;
                }

                public void setNickName(String nickName) {
                    this.nickName = nickName;
                }

                public String getOccupation() {
                    return occupation;
                }

                public void setOccupation(String occupation) {
                    this.occupation = occupation;
                }

                public long getRegisterTime() {
                    return registerTime;
                }

                public void setRegisterTime(long registerTime) {
                    this.registerTime = registerTime;
                }

                public int getRoleType() {
                    return roleType;
                }

                public void setRoleType(int roleType) {
                    this.roleType = roleType;
                }

                public String getSignature() {
                    return signature;
                }

                public void setSignature(String signature) {
                    this.signature = signature;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public int getTopicCount() {
                    return topicCount;
                }

                public void setTopicCount(int topicCount) {
                    this.topicCount = topicCount;
                }

                public int getTotalExp() {
                    return totalExp;
                }

                public void setTotalExp(int totalExp) {
                    this.totalExp = totalExp;
                }

                public int getUid() {
                    return uid;
                }

                public void setUid(int uid) {
                    this.uid = uid;
                }

                public int getUserLevel() {
                    return userLevel;
                }

                public void setUserLevel(int userLevel) {
                    this.userLevel = userLevel;
                }

                public int getUserNextLevel() {
                    return userNextLevel;
                }

                public void setUserNextLevel(int userNextLevel) {
                    this.userNextLevel = userNextLevel;
                }

                public String getUsername() {
                    return username;
                }

                public void setUsername(String username) {
                    this.username = username;
                }

                public String getVipInfo() {
                    return vipInfo;
                }

                public void setVipInfo(String vipInfo) {
                    this.vipInfo = vipInfo;
                }

                public int getVipType() {
                    return vipType;
                }

                public void setVipType(int vipType) {
                    this.vipType = vipType;
                }

                public int getVisitorCount() {
                    return visitorCount;
                }

                public void setVisitorCount(int visitorCount) {
                    this.visitorCount = visitorCount;
                }

                public static class CityBean {
                    private boolean deleted;
                    private int id;
                    private String nm;
                    private String py;

                    public boolean isDeleted() {
                        return deleted;
                    }

                    public void setDeleted(boolean deleted) {
                        this.deleted = deleted;
                    }

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getNm() {
                        return nm;
                    }

                    public void setNm(String nm) {
                        this.nm = nm;
                    }

                    public String getPy() {
                        return py;
                    }

                    public void setPy(String py) {
                        this.py = py;
                    }
                }
            }

            public static class ImagesBean {
                private int authorId;
                private int height;
                private int id;
                private int sizeType;
                private int targetId;
                private int targetType;
                private String url;
                private int width;

                public int getAuthorId() {
                    return authorId;
                }

                public void setAuthorId(int authorId) {
                    this.authorId = authorId;
                }

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getSizeType() {
                    return sizeType;
                }

                public void setSizeType(int sizeType) {
                    this.sizeType = sizeType;
                }

                public int getTargetId() {
                    return targetId;
                }

                public void setTargetId(int targetId) {
                    this.targetId = targetId;
                }

                public int getTargetType() {
                    return targetType;
                }

                public void setTargetType(int targetType) {
                    this.targetType = targetType;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }
            }
        }
    }
}
