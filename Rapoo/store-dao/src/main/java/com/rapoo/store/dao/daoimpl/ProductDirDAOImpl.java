package com.rapoo.store.dao.daoimpl;

import com.rapoo.store.PageResult;
import com.rapoo.store.ProductDir;
import com.rapoo.store.ProductDirQuery;
import com.rapoo.store.dao.IProductDirDAO;
import com.rapoo.store.handler.BeanHandler;
import com.rapoo.store.handler.BeanListHandler;
import com.rapoo.store.util.JdbcTemplate;

import java.util.List;

public class ProductDirDAOImpl implements IProductDirDAO {
    @Override
    public void add(ProductDir productDir) {
        String sql = "INSERT INTO productdir (did,dirName,parent_id) VALUES(?,?,?)";
        Object[] params = {productDir.getDirName(),productDir.getParent_id(),productDir.getParent_id()};
        JdbcTemplate.update(sql, params);
    }

    @Override
    public void delete(Long did) {
        String sql = "DELETE FROM productdir WHERE did = ?";
        JdbcTemplate.update(sql, did);
    }

    @Override
    public void update(Long did, ProductDir productDir) {
        String sql = "UPDATE productdir SET productName = ?, Parent_id = ? WHERE did = ?";
        JdbcTemplate.update(sql,productDir.getDirName(),productDir.getParent_id(),did);
    }

    @Override
    public ProductDir get(Long did) {
        String sql = "SELECT * FROM productdir WHERE did = ?";
        return JdbcTemplate.query(sql, new BeanHandler<>(ProductDir.class), did);
    }

    @Override
    public List<ProductDir> query() {
        String sql = "SELECT * FROM productdir";
        return JdbcTemplate.query(sql,new BeanListHandler<>(ProductDir.class));
    }


}
