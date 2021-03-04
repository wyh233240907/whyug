package com.whyug.sqlquery.condition;

/**
 * 查询条数模型
 *
 * @author wyh
 * @date 2021/3/3
 */
public class Limit {
    /**
     * 偏移量
     */
    private Integer offset = 0;
    /**
     * 最大数据
     */
    private Integer maxSize = Integer.MAX_VALUE;

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(Integer maxSize) {
        this.maxSize = maxSize;
    }
}
