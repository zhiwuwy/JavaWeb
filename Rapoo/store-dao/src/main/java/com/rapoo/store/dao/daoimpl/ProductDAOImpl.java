package com.rapoo.store.dao.daoimpl;

import com.rapoo.store.PageResult;
import com.rapoo.store.Product;
import com.rapoo.store.ProductQuery;
import com.rapoo.store.Query;
import com.rapoo.store.dao.IProductDAO;
import com.rapoo.store.handler.BeanHandler;
import com.rapoo.store.util.JdbcTemplate;

import java.util.List;

public class ProductDAOImpl extends BaseDAOImpl implements IProductDAO {
    @Override
    public void add(Product product) {
        String sql = "INSERT INTO product (productName, supplier, " +
                "brand, salePrice,costPrice,cutoff,dir_id) VALUES(?,?,?,?,?,?,?)";
        Object[] objects = {product.getProductName(), product.getSupplier(), product.getBrand()
                , product.getSalePrice(), product.getSalePrice(), product.getCostPrice(), product.getCutoff(), product.getDir_id()};
        JdbcTemplate.update(sql, objects);

    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FORM product WHERE id = ?";
        JdbcTemplate.update(sql, id);
    }

    @Override
    public void update(Product product) {
        String sql = "UPDATE product SET productName=?, supplier=?,brand=?, salePrice=?" +
                ",costPrice=?,cutoff=?,dir_id=? WHERE id = ?";
        Object[] objects = {product.getProductName(), product.getSupplier(), product.getBrand()
                , product.getSalePrice(), product.getCostPrice(), product.getCutoff(), product.getDir_id(), product.getId()};
        JdbcTemplate.update(sql, objects);
    }

    @Override
    public Product get(Long id) {
        String sql = "SELECT * FROM product WHERE id = ?";
        return JdbcTemplate.query(sql, new BeanHandler<>(Product.class), id);
    }

    @Override
    public PageResult query(ProductQuery pq) {
        return super.query(Product.class, pq);
    }


}
