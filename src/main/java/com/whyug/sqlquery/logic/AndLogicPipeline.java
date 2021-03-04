package com.whyug.sqlquery.logic;

public class AndLogicPipeline extends AbstractLogic {

    @Override
    public boolean next(boolean result) {
        //and需要继续判断
        return result;
    }
}
