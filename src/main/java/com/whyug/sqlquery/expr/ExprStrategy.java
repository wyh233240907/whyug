package com.whyug.sqlquery.expr;

import com.whyug.sqlquery.condition.Where;
import com.whyug.sqlquery.enums.ExprEnum;

/**
 * 表达式逻辑处理
 */
public interface ExprStrategy {

    /**
     * 是否是该表达是处理类
     *
     * @param exprEnum
     * @return
     */
    boolean support(ExprEnum exprEnum);

    /**
     * 对应表达式处理方法
     *
     * @param o
     * @param where
     * @return
     */
    boolean handler(Object o, Where where);
}
