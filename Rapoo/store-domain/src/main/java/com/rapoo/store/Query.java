package com.rapoo.store;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 封装了商品对象的查询条件
 */
public class Query {
    @Getter@Setter
    private Integer currentPage = 1;//当前页,用户传入
    @Getter@Setter
    private Integer pageSize = 5;//每页条数,用户传入

    private List<String> conditions = new ArrayList<>();//封装查询条件

    private List<Object> parameters = new ArrayList<>();//封装占位符参数

    private boolean isBuild = false;//查询对象是否已经构建

    /**
     * 初始化操作,根据查询对象的不同做定制化查询,避免多次查询
     */
    private void init(){
        if(!isBuild){
            customizedQuery();//构建自己的查询条件
            isBuild = true;
        }
    }

    /**
     * 获取查询条件的sql,如WHERE productName Like ? AND salePrice >= ?
     * @return 返回查询的sql语句
     */
    public String getQuery(){
        StringBuilder sql = new StringBuilder(80);
        init();
        if(conditions.size() == 0){
            return "";
        }
        String queryString = StringUtils.join(conditions," AND ");
        sql.append(" WHERE ").append(queryString);
        return sql.toString();
    }

    /**
     * 获取占位符参数的集合
     * @return 返回占位符参数的集合
     */
    public List<Object> getParameters(){
        return parameters;
    }

    /**
     * 定制查询
     */
    public void customizedQuery(){

    }

    /**
     * 添加查询条件和预编译语句占位符参数
     * @param condition 查询条件
     * @param paramater 预编译语句占位符参数
     */
    public void addQuery(String condition, Object...paramater){
        conditions.add(condition);
        parameters.addAll(Arrays.asList(paramater));
    }
}
