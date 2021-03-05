package com.whyug.sqlquery.orderby;


import com.whyug.sqlquery.condition.OrderBy;

import java.lang.reflect.Field;
import java.util.Comparator;

/**
 * 排序
 *
 * @author wyh
 * @date 2021/3/3
 */
public class OrderByComparator implements Comparator {
    private OrderBy orderBy;

    public OrderBy getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(OrderBy orderBy) {
        this.orderBy = orderBy;
    }

    @Override
    public int compare(Object o1, Object o2) {
        int value = 0;
        for (String s : orderBy.getColumn()) {
            Object o1Column = null;
            Object o2Column = null;
            try {
                Field o1Filed = o1.getClass().getDeclaredField(s);
                o1Filed.setAccessible(true);
                o1Column = o1Filed.get(o1);

                Field o2Filed = o2.getClass().getDeclaredField(s);
                o2Filed.setAccessible(true);
                o2Column = o1Filed.get(o2);

            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (orderBy.getSort().equalsIgnoreCase("asc")) {
                value = o1Column.hashCode() > o2Column.hashCode() ? 1 : o1Column.hashCode() == o2Column.hashCode() ? 0 : -1;
            } else if (orderBy.getSort().equalsIgnoreCase("desc")) {
                value = o1Column.hashCode() < o2Column.hashCode() ? 1 : o1Column.hashCode() == o2Column.hashCode() ? 0 : -1;
            } else {
                throw new RuntimeException();
            }
            if (value != 0)
                break;
        }
        return value;
    }
}
