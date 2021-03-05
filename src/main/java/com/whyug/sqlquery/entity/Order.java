package com.whyug.sqlquery.entity;

public class Order {
    private String name;
    private Integer age;
    private Integer order;
    private Integer sort;

    public Order(String name, Integer age, Integer order, Integer sort) {
        this.name = name;
        this.age = age;
        this.order = order;
        this.sort = sort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", order=" + order +
                ", sort=" + sort +
                '}';
    }
}
