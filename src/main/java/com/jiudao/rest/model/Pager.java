package com.jiudao.rest.model;

import java.util.List;

/**
 * Pager
 *
 * version 1.0
 *
 * @create 2018-07-05 12:10
 *
 * @copyright huxiaolei1997@gmail.com
 */
public class Pager<T> {
    // 当前所在页号
    private int current_page;

    // 总共有多少条数据
    private int total_record;

    // 总共有多少页
    private int total_page;

    // 每页有多少条数据
    private int page_size;

    // 每页要显示的数据
    private List<T> dataList;

    public int getCurrent_page() {
        return current_page;
    }

    public Pager(int current_page, int total_record, int total_page, int page_size, List<T> dataList) {
        this.current_page = current_page;
        this.total_record = total_record;
        this.total_page = total_page;
        this.page_size = page_size;
        this.dataList = dataList;
    }

    public Pager() {

    }

    public void setCurrent_page(int current_page) {
        this.current_page = current_page;
    }

    public int getTotal_record() {
        return total_record;
    }

    public void setTotal_record(int total_record) {
        this.total_record = total_record;
    }

    public int getTotal_page() {
        return total_page;
    }

    public void setTotal_page(int total_page) {
        this.total_page = total_page;
    }

    public int getPage_size() {
        return page_size;
    }

    public void setPage_size(int page_size) {
        this.page_size = page_size;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    @Override
    public String toString() {
        return "{" +
                "current_page: " + current_page +
                ", total_record: " + total_record +
                ", total_page: " + total_page +
                ", page_size: " + page_size +
                ", dataList: " + dataList +
                '}';
    }
}
