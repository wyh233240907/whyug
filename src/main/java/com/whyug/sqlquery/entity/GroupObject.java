package com.whyug.sqlquery.entity;

/**
 * 分组后的对象
 *
 * @author wyh
 * @date 2021/3/5
 */
public class GroupObject {
    private Object object;

    private Integer count;

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "GroupObject{" +
                "object=" + object +
                ", count=" + count +
                '}';
    }
}
