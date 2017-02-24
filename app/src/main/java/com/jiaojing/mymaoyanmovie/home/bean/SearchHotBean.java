package com.jiaojing.mymaoyanmovie.home.bean;

import java.util.List;

/**
 * Created by jiaojing on 2016/12/7.
 * 作用：xxx
 */
public class SearchHotBean {

    /**
     * url :
     * value : 魔兽
     */

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String url;
        private String value;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
