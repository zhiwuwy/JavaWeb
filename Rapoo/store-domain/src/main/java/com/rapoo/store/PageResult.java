package com.rapoo.store;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Getter
public class PageResult {
    private Integer currentPage;
    private Integer pageSize;
    private List<Object> listData = new ArrayList<>();
    private Integer totalCount;
    private Integer beginPage;
    private Integer prevPage;
    private Integer nextPage;
    private Integer totalPage;
    private List<Integer> pageItems = Arrays.asList(3,5,7);

    public PageResult(Integer currentPage, Integer pageSize, List<Object> listData, Integer totalCount) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.listData = listData;
        this.totalCount = totalCount;
        this.beginPage = 1;
        this.totalPage = this.totalCount % this.pageSize == 0 ? this.totalCount / this.pageSize : this.totalCount / this.pageSize + 1;
        this.prevPage = this.currentPage - 1 > 0 ? this.currentPage - 1 : 1;
        this.nextPage = this.currentPage + 1 <= this.totalPage ? this.currentPage + 1 : this.totalPage;
    }
    public void setListData(List list){
        this.listData = list;
    }
    public static PageResult empty(Integer pageSize){
        return new PageResult(1,pageSize, Collections.EMPTY_LIST,0);
    }
}
