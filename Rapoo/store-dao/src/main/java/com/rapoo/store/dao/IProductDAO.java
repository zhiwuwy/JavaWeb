package com.rapoo.store.dao;

import com.rapoo.store.PageResult;
import com.rapoo.store.Product;
import com.rapoo.store.ProductQuery;
import com.rapoo.store.Query;

import java.util.List;

public interface IProductDAO {
    /**
     * 新增产品
     * @param product 产品信息
     */
    public void add(Product product);

    /**
     * 通过产品id删除产品
     * @param id 指定删除的产品id
     */
    public void delete(Long id);

    /**
     * 通过产品id和新的产品信息修改原有的产品信息
     * @param product 新的产品信息
     */
    public void update(Product product);

    /**
     * 通过产品id查找某个产品
     * @param id 指定要查找的产品id
     * @return 返回查询到的商品对象
     */
    public Product get(Long id);

    /**
     * 通过封装了查询信息的商品查询对象来查询商品
     * @param pq 商品查询对象
     * @return 返回商品列表
     */
    public PageResult query(ProductQuery pq);
}
