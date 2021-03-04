package com.whyug.sqlquery.logic;

import com.whyug.sqlquery.condition.Where;
import com.whyug.sqlquery.enums.LogicEnum;
import com.whyug.sqlquery.expr.ExprStrategy;


public class OrHandler implements LogicStrategy {
    @Override
    public boolean support(LogicEnum logicEnum) {
        return LogicEnum.OR.equals(logicEnum);
    }

    @Override
    public LogicPipeline handler(Where where, LogicPipelineContext logicPipelineContext, ExprStrategy exprStrategy) {
        OrLogicPipeline pipeline = new OrLogicPipeline();
        pipeline.setExprStrategy(exprStrategy);
        pipeline.setWhere(where);
        logicPipelineContext.pipelines.addFirst(pipeline);
        logicPipelineContext.orCount++;
        return pipeline;
    }
}
