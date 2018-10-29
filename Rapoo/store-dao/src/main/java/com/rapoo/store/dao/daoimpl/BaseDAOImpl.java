package com.rapoo.store.dao.daoimpl;

import com.rapoo.store.PageResult;
import com.rapoo.store.ProductQuery;
import com.rapoo.store.Query;
import com.rapoo.store.handler.BeanListHandler;
import com.rapoo.store.handler.CountHandler;
import com.rapoo.store.util.JdbcTemplate;

import java.util.List;

public class BaseDAOImpl {
    public  <T> PageResult query(Class<T> classType, ProductQuery pq){
        //把类名当做表名
        String tableName = classType.getSimpleName();
        //通过注解获得表名
        //得到结果总数totalCount
        String countSql = "SELECT COUNT(*) FROM product " + pq.getQuery();
        Integer totalCount  = JdbcTemplate.query(countSql, new CountHandler(), pq.getParameters().toArray()).intValue();
        if(totalCount == 0){
            return PageResult.empty(pq.getPageSize());
        }
        //查询结果集
        String querySql = "SELECT * FROM product "  + pq.getQuery() + " LIMIT ? , ?";
        pq.getParameters().add((pq.getCurrentPage() - 1) * pq.getPageSize());
        pq.getParameters().add(pq.getPageSize());
        List listDate = JdbcTemplate.query(querySql, new BeanListHandler<>(classType), pq.getParameters().toArray());
        return new PageResult(pq.getCurrentPage(),pq.getPageSize(),listDate,totalCount);
    }
}
