package com.whyug.sqlquery.logic;

import com.whyug.sqlquery.condition.Where;
import com.whyug.sqlquery.enums.LogicEnum;
import com.whyug.sqlquery.expr.ExprStrategy;

public class AndHandler implements LogicStrategy {
    @Override
    public boolean support(LogicEnum logicEnum) {
        return LogicEnum.AND.equals(logicEnum);
    }

    @Override
    public LogicPipeline handler(Where where, LogicPipelineContext logicPipelineContext, ExprStrategy exprStrategy) {
        AndLogicPipeline andLogicPipeline = new AndLogicPipeline();
        andLogicPipeline.setWhere(where);
        andLogicPipeline.setExprStrategy(exprStrategy);
        logicPipelineContext.pipelines.addLast(andLogicPipeline);
        logicPipelineContext.andCount++;
        return andLogicPipeline;
    }
}
