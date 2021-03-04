package com.whyug.sqlquery.logic;

public class OrLogicPipeline extends AbstractLogic {

    @Override
    public boolean next(boolean result) {
        //or条件只要有一个为true就没必要继续条件判断了
        return !result;
    }
}
