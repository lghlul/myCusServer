package com.answer.common;

import java.util.List;

/**
 * @Author: nhsoft.ll
 * @Description:
 * @Date:Create：2019/4/3 12:01
 * @Modified By：
 */
public class PageResult {
    /**
     * 分页数据列表
     */
    private List list;
    /**
     * 总记录数
     */
    private Long totalCount;
    /**
     * 总页数
     */
    private Integer totalPage;

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }
}
