package com.whyug.sqlquery.condition;

import com.whyug.sqlquery.enums.ExprEnum;
import com.whyug.sqlquery.enums.LogicEnum;

/**
 * where条件模型
 *
 * @author wyh
 * @date 2021/3/2
 */
public class Where {
    /**
     * 查询列
     */
    private String column;

    /**
     * = > <
     */
    private ExprEnum expr;

    /**
     * 条件值
     */
    private String value;

    /**
     * and or
     */
    private LogicEnum logic;

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ExprEnum getExpr() {
        return expr;
    }

    public void setExpr(ExprEnum expr) {
        this.expr = expr;
    }

    public LogicEnum getLogic() {
        return logic;
    }

    public void setLogic(LogicEnum logic) {
        this.logic = logic;
    }
}
