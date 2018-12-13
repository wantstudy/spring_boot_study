package com.example.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author weiwei
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: 基础类
 * @date 2018/12/1321:24
 */
public class BaseEntity implements Serializable{

    //页码
    protected transient int page = 1;

    //每页数量
    protected transient int size = 20;

    //排序字段
    protected transient String sortSid = "id";

    public int getPage() {
        return page - 1;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSortSid() {
        return sortSid;
    }

    public void setSortSid(String sortSid) {
        this.sortSid = sortSid;
    }
}
