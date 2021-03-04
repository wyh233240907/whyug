package com.whyug.sqlquery.logic;

import com.whyug.sqlquery.condition.Where;
import com.whyug.sqlquery.expr.ExprStrategy;

/**
 * 逻辑处理公共类
 *
 * @author wyh
 * @date 2020/3/2
 */
public abstract class AbstractLogic implements LogicPipeline {

    private Where where;

    private ExprStrategy exprStrategy;

    public Where getWhere() {
        return where;
    }


    public void setWhere(Where where) {
        this.where = where;
    }

    public ExprStrategy getExprStrategy() {
        return exprStrategy;
    }

    public void setExprStrategy(ExprStrategy exprStrategy) {
        this.exprStrategy = exprStrategy;
    }

    @Override
    public boolean judge(Object o) {
        return exprStrategy.handler(o, where);
    }
}
