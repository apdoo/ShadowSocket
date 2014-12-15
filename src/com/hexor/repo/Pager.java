package com.hexor.repo;

/**
 * Created with IntelliJ IDEA.
 * User: Dong
 * Date: 14-8-27
 * Time: 下午3:03
 * To change this template use File | Settings | File Templates.
 */
public class Pager {
    private int count;
    private int index=0;
    private int data=24;
    private int pageCount;
    private int currentPage=1;

    public int getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    public int getPageCount() {
        return pageCount;
    }
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }

}

