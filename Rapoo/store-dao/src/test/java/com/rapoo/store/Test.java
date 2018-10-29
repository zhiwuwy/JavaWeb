package com.rapoo.store;


import com.rapoo.store.dao.daoimpl.ProductDAOImpl;
import com.rapoo.store.dao.daoimpl.ProductDirDAOImpl;
import com.rapoo.store.dao.daoimpl.UserDAOImpl;
import com.rapoo.store.handler.BeanHandler;
import com.rapoo.store.handler.IResultSetHandler;
import com.rapoo.store.util.JdbcTemplate;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        ProductQuery pq = new ProductQuery();
        pq.setProductName("雷柏");
        System.out.println(pq);
        System.out.println(pq.getQuery());
        System.out.println(pq.getParameters());
        PageResult pageResult = new ProductDAOImpl().query(pq);
        System.out.println(pageResult.getListData());
    }


}
