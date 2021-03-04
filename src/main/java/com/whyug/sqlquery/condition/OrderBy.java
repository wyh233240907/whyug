package com.whyug.sqlquery.condition;

/**
 * 排序模型
 *
 * @author wyh
 * @date 2021/3/2
 */
public class OrderBy {
    /**
     * 排序的字段
     */
    private String[] column;
    /**
     * 升序还是降序
     */
    private String sort;

    public String[] getColumn() {
        return column;
    }

    public void setColumn(String[] column) {
        this.column = column;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
