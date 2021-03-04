package com.whyug.sqlquery.expr;

import com.whyug.sqlquery.condition.Where;
import com.whyug.sqlquery.enums.ExprEnum;

import java.lang.reflect.Field;

/**
 * 等于逻辑处理
 *
 * @author wyh
 * @date 2021/3/2
 */
public class EQHandler implements ExprStrategy {


    @Override
    public boolean support(ExprEnum exprEnum) {
        return ExprEnum.EQ.equals(exprEnum);
    }

    @Override
    public boolean handler(Object o,Where where) {
        Class<?> oClass = o.getClass();
        try {
            Field field = oClass.getDeclaredField(where.getColumn());
            field.setAccessible(true);
            return field.get(o).toString().equals(where.getValue());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
