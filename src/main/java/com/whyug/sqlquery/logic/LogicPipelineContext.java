package com.whyug.sqlquery.logic;

import java.util.LinkedList;
import java.util.List;

public class LogicPipelineContext {
    public Integer orCount = 0;

    public Integer andCount = 0;

    public LinkedList<LogicPipeline> pipelines = new LinkedList();
}
