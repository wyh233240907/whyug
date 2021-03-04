package com.whyug.sqlquery.logic;

import com.whyug.sqlquery.condition.Where;
import com.whyug.sqlquery.enums.LogicEnum;
import com.whyug.sqlquery.expr.ExprStrategy;

public interface LogicStrategy {
    boolean support(LogicEnum logicEnum);

    LogicPipeline handler(Where where, LogicPipelineContext logicPipelineContext, ExprStrategy exprStrategy);
}
