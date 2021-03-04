package com.whyug.sqlquery.expr;

import com.whyug.sqlquery.condition.Where;
import com.whyug.sqlquery.enums.ExprEnum;

import java.lang.reflect.Field;

public class LTHandler implements ExprStrategy {


    @Override
    public boolean support(ExprEnum exprEnum) {
        return ExprEnum.LT.equals(exprEnum);
    }

    @Override
    public boolean handler(Object o, Where where) {
        Class<?> oClass = o.getClass();
        try {
            Field field = oClass.getDeclaredField(where.getColumn());
            field.setAccessible(true);
            Integer objValue = (Integer) field.get(o);
            int condition = Integer.parseInt(where.getValue());
            return objValue < condition;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
