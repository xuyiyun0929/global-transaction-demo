package com.evan.demo.storage.entity;

import java.util.Date;

public class Store {
    private Integer product_id;

    private String product_count;

    private Date opr_time;

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getProduct_count() {
        return product_count;
    }

    public void setProduct_count(String product_count) {
        this.product_count = product_count;
    }

    public Date getOpr_time() {
        return opr_time;
    }

    public void setOpr_time(Date opr_time) {
        this.opr_time = opr_time;
    }
}