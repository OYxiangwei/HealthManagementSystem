package com.oy.entity;

public class PaginationObject {
    private Object list;
    private int pageSize;
    private int pageNum;
    private long total;

    public PaginationObject() {
    }

    public PaginationObject(Object list, int pageNum, int pageSize, long total) {
        this.list = list;
        this.pageSize = pageSize;
        this.pageNum = pageNum;
        this.total = total;
    }

    public Object getList() {
        return list;
    }

    public void setList(Object list) {
        this.list = list;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "PaginationObject{" +
                "list=" + list +
                ", pageSize=" + pageSize +
                ", pageNum=" + pageNum +
                ", total=" + total +
                '}';
    }
}
