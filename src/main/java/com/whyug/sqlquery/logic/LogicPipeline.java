package com.whyug.sqlquery.logic;

/**
 * where条件链
 *
 * @author wyh
 * @date 2020/3/2
 */
public interface LogicPipeline {

    /**
     * where条件具体处理
     *
     * @param o
     * @return
     */
    boolean judge(Object o);

    /**
     * 是否需要进行下个节点
     * @param result
     * @return
     */
    boolean next(boolean result);
}
