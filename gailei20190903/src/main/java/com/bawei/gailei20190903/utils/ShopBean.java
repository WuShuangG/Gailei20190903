package com.bawei.gailei20190903.utils;

import java.util.List;

/**
 * author: 盖磊
 * data: 2019/9/3 09:9:12
 * function:a)	根据服务器响应的json封装ShopBean类
 */
public class ShopBean {

    private List<DataInfo> data;

    public List<DataInfo> getData() {
        return data;
    }

    public void setData(List<DataInfo> data) {
        this.data = data;
    }

    public class DataInfo {
        private String goods_thumb;
        private String goods_name;
        private String currency_price;

        public String getGoods_thumb() {
            return goods_thumb;
        }

        public void setGoods_thumb(String goods_thumb) {
            this.goods_thumb = goods_thumb;
        }

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public String getCurrency_price() {
            return currency_price;
        }

        public void setCurrency_price(String currency_price) {
            this.currency_price = currency_price;
        }
    }
}
