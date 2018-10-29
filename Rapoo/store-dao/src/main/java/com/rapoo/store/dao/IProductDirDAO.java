package com.rapoo.store.dao;

import com.rapoo.store.*;

import java.util.List;

public interface IProductDirDAO {
    /**
     * 新增产品分类
     * @param productDir 产品分类信息
     */
    public void add(ProductDir productDir);

    /**
     * 通过产品did删除产品分类
     * @param did 指定删除的产品分类id
     */
    public void delete(Long did);

    /**
     * 通过产品id和新的产品信息修改原有的产品分类信息
     * @param did 指定修改的产品分类id
     * @param productDir 新的产品分类信息
     */
    public void update(Long did, ProductDir productDir);

    /**
     * 通过产品id查找某个产品分类
     * @param did 指定要查找的产品分类id
     * @return 返回查询到的产品分类对象
     */
    public ProductDir get(Long did);

    /**
     * 查询商品分类列表
     * @return 返回商品分类列表
     */
    public List<ProductDir> query();
}
