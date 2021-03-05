package com.whyug.sqlquery;

import com.whyug.sqlquery.condition.GroupBy;
import com.whyug.sqlquery.condition.Limit;
import com.whyug.sqlquery.condition.OrderBy;
import com.whyug.sqlquery.condition.Where;
import com.whyug.sqlquery.entity.GroupObject;
import com.whyug.sqlquery.entity.Order;
import com.whyug.sqlquery.entity.Student;
import com.whyug.sqlquery.enums.ExprEnum;
import com.whyug.sqlquery.enums.LogicEnum;
import com.whyug.sqlquery.expr.EQHandler;
import com.whyug.sqlquery.expr.ExprStrategy;
import com.whyug.sqlquery.expr.GTHandler;
import com.whyug.sqlquery.expr.LTHandler;
import com.whyug.sqlquery.logic.*;
import com.whyug.sqlquery.orderby.OrderByComparator;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * sql查询
 *
 * @author wyh
 * @date 2020/3/2
 */
public class SQLQuery {

    List<LogicStrategy> logicStrategies = new ArrayList<>();

    List<ExprStrategy> strategyList = new ArrayList<>();

    /**
     * 初始化工作
     */
    @Before
    public void init() {
        //or/and处理初始化
        OrHandler orHandler = new OrHandler();
        AndHandler andHandler = new AndHandler();
        logicStrategies.add(orHandler);
        logicStrategies.add(andHandler);

        //= > < 处理类初始化
        GTHandler gtHandler = new GTHandler();
        LTHandler ltHandler = new LTHandler();
        EQHandler eqHandler = new EQHandler();
        strategyList.add(gtHandler);
        strategyList.add(ltHandler);
        strategyList.add(eqHandler);
    }

    /**
     * 等于逻辑测试
     */
    @Test
    public void test1() {
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Student student = new Student();
            student.setAge(i + 1);
            student.setName("张三" + i);
            list.add(student);
        }
        Where where = new Where();
        where.setColumn("age");
        where.setExpr(ExprEnum.EQ);
        where.setLogic(LogicEnum.AND);
        where.setValue("3");
        Where[] wheres = {where};

        List<Object> query = query(list, wheres, null, null, null);
        for (Object o : query) {
            System.out.println(o);
        }

    }

    /**
     * 大于逻辑测试
     */
    @Test
    public void test2() {
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Student student = new Student();
            student.setAge(i + 1);
            student.setName("张三" + i);
            list.add(student);
        }
        Where where = new Where();
        where.setColumn("age");
        where.setExpr(ExprEnum.GT);
        where.setLogic(LogicEnum.AND);
        where.setValue("3");
        Where[] wheres = {where};

        List<Object> query = query(list, wheres, null, null, null);
        for (Object o : query) {
            System.out.println(o);
        }
    }

    /**
     * 小于逻辑测试
     */
    @Test
    public void test3() {
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Student student = new Student();
            student.setAge(i + 1);
            student.setName("张三" + i);
            list.add(student);
        }
        Where where = new Where();
        where.setColumn("age");
        where.setExpr(ExprEnum.LT);
        where.setLogic(LogicEnum.AND);
        where.setValue("3");
        Where[] wheres = {where};

        List<Object> query = query(list, wheres, null, null, null);
        for (Object o : query) {
            System.out.println(o);
        }
    }

    /**
     * and or测试
     */
    @Test
    public void test4() {
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Student student = new Student();
            student.setAge(i + 1);
            student.setName("张三" + i);
            list.add(student);
        }
        Where where = new Where();
        where.setColumn("name");
        where.setExpr(ExprEnum.EQ);
        where.setLogic(LogicEnum.AND);
        where.setValue("张三1");

        Where where1 = new Where();
        where1.setColumn("age");
        where1.setExpr(ExprEnum.EQ);
        where1.setLogic(LogicEnum.AND);
        where1.setValue("2");

        Where where2 = new Where();
        where2.setColumn("name");
        where2.setExpr(ExprEnum.EQ);
        where2.setLogic(LogicEnum.OR);
        where2.setValue("张三0");
        Where[] wheres = {where, where1, where2};

        List<Object> query = query(list, wheres, null, null, null);
        for (Object o : query) {
            System.out.println(o);
        }
    }

    /**
     * orderBy测试
     */
    @Test
    public void test5() {
        Order order1 = new Order("张三", 23, 15, 1);
        Order order2 = new Order("李四", 13, 11, 2);
        Order order3 = new Order("王五", 23, 15, 3);
        Order order4 = new Order("赵六", 23, 12, 4);
        Order order5 = new Order("钱七", 11, 12, 5);

        List<Object> lists = new ArrayList<>();
        lists.add(order1);
        lists.add(order2);
        lists.add(order3);
        lists.add(order4);
        lists.add(order5);

        OrderBy orderBy = new OrderBy();
        orderBy.setSort("asc");
        orderBy.setColumn(new String[]{"age", "order", "sort"});

        List<Object> query = query(lists, null, orderBy, null, null);
        for (Object o : query) {
            System.out.println(o);
        }
    }

    /**
     * limit测试
     */
    @Test
    public void test6() {
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Student student = new Student();
            student.setAge(i + 1);
            student.setName("张三" + i);
            list.add(student);
        }

        Limit limit = new Limit();
        limit.setOffset(2);
        limit.setMaxSize(5);

        List<Object> query = query(list, null, null, null, limit);
        for (Object o : query) {
            System.out.println(o);
        }
    }

    /**
     * groupBy测试
     */
    @Test
    public void test7() {
        Order order1 = new Order("张三", 23, 1553, 1);
        Order order2 = new Order("李四", 14, 1556, 2);
        Order order3 = new Order("王五", 23, 1553, 3);
        Order order4 = new Order("赵六", 14, 1557, 4);
        Order order5 = new Order("钱七", 14, 1557, 5);
        Order order6 = new Order("吴八", 23, 1558, 6);
        Order order7 = new Order("孙九", 23, 1558, 7);
        Order order8 = new Order("刘十", 11, 1661, 8);

        List<Object> lists = new ArrayList<>();
        lists.add(order1);
        lists.add(order2);
        lists.add(order3);
        lists.add(order4);
        lists.add(order5);
        lists.add(order6);
        lists.add(order7);
        lists.add(order8);

        GroupBy groupBy = new GroupBy();
        groupBy.setColumn(new String[]{"age","order"});

        List<Object> query = query(lists, null, null, groupBy, null);
        for (Object o : query) {
            System.out.println(o);
        }
    }


    public List<Object> query(List<Object> data, Where[] wheres, OrderBy orderBy, GroupBy groupBy, Limit limit) {
        Stream dataStream = data.stream();
        if (wheres != null && wheres.length > 0)
            dataStream = where(dataStream, wheres);
        if (groupBy != null && groupBy.getColumn().length > 0)
            dataStream = groupBy(dataStream, groupBy);
        if (orderBy != null && orderBy.getColumn().length > 0)
            dataStream = orderBy(dataStream, orderBy);
        if (limit != null)
            dataStream = dataStream.skip(limit.getOffset()).limit(limit.getMaxSize());

        List collect = (List) dataStream.collect(Collectors.toList());
        return collect;
    }

    /**
     * where条件链生成
     *
     * @param wheres
     * @return
     */
    public LogicPipelineContext pipelineBuilder(Where[] wheres) {
        LogicPipelineContext logicPipelineContext = new LogicPipelineContext();
        //建立where查询链，or最前，and最后，因为or只要有一个为true直接返回
        for (Where where : wheres) {
            ExprStrategy strategy = null;
            //找到> < = 对应的处理handler
            for (ExprStrategy exprStrategy : strategyList) {
                if (exprStrategy.support(where.getExpr())) {
                    strategy = exprStrategy;
                    break;
                }
            }

            //and/or处理类查询
            for (LogicStrategy logicStrategy : logicStrategies) {
                if (logicStrategy.support(where.getLogic())) {
                    logicStrategy.handler(where, logicPipelineContext, strategy);
                }
            }
        }
        return logicPipelineContext;
    }

    /**
     * where条件查询处理
     *
     * @param stream
     * @param wheres
     * @return
     */
    public Stream where(Stream stream, Where[] wheres) {
        LogicPipelineContext logicPipelineContext = pipelineBuilder(wheres);

        Stream<Object> newStream = stream
                .filter(data -> {
                    int and = 0;
                    for (LogicPipeline pipeline : logicPipelineContext.pipelines) {
                        boolean judge = pipeline.judge(data);
                        //or为true不用继续向下判断
                        if (judge && pipeline instanceof OrLogicPipeline)
                            return true;

                        //and只要一个为false就不用继续判断
                        if (!judge && pipeline instanceof AndLogicPipeline)
                            return false;

                        if (judge && pipeline instanceof AndLogicPipeline)
                            and++;

                        //要所有and为true才真的满足条件
                        if (pipeline == logicPipelineContext.pipelines.getLast() && and == logicPipelineContext.andCount)
                            return true;
                    }
                    return false;
                });
        return newStream;
    }

    public Stream orderBy(Stream datas, OrderBy orderBy) {
        OrderByComparator orderByComparator = new OrderByComparator();
        orderByComparator.setOrderBy(orderBy);
        Stream sorted = datas.sorted(orderByComparator);
        return sorted;
    }

    public Stream groupBy(Stream datas, GroupBy groupBy) {
        List lists = (List) datas.collect(Collectors.toList());
        //存分组的结果
        Map<String, GroupObject> groupObjs = new HashMap<>();

        for (Object list : lists) {
            StringBuilder builder = new StringBuilder();
            //组装要分组的字段为一个key，根据key进行分组
            for (String s : groupBy.getColumn()) {
                try {
                    Field field = list.getClass().getDeclaredField(s);
                    field.setAccessible(true);
                    String str = field.get(list).toString();
                    builder.append(str);
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            if (groupObjs.containsKey(builder.toString())) {
                GroupObject groupObject = groupObjs.get(builder.toString());
                groupObject.setCount(groupObject.getCount() + 1);
            } else {
                GroupObject groupObject = new GroupObject();
                groupObject.setCount(1);
                groupObject.setObject(list);
                groupObjs.put(builder.toString(), groupObject);
            }
        }
        return groupObjs.values().stream();
    }


}
