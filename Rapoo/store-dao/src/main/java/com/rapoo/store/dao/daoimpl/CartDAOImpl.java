package com.rapoo.store.dao.daoimpl;

import com.rapoo.store.Cart;
import com.rapoo.store.Commodity;
import com.rapoo.store.dao.ICartDAO;
import com.rapoo.store.handler.BeanHandler;
import com.rapoo.store.handler.BeanListHandler;
import com.rapoo.store.util.JdbcTemplate;

import java.util.List;

public class CartDAOImpl implements ICartDAO {
    @Override
    public void add(Long cartid, Commodity commodity) {
        String sql = "INSERT INTO cart (cartid,cid,cName,cPrice,count) VALUES(?,?,?,?,?)";
        Object[] params = {cartid, commodity.getCid(), commodity.getCName(), commodity.getCPrice(),commodity.getCount()};
        JdbcTemplate.update(sql, params);
    }

    @Override
    public void update(Long cartid, Long cid, Integer count) {
        String sql = "UPDATE cart SET count = ? WHERE cartid = ? AND cid = ?";
        Object[] params = {count, cartid, cid};
        JdbcTemplate.update(sql, params);
    }

    @Override
    public void delete(Long cartid, Long cid) {
        String sql = "DELETE FROM cart WHERE cartid = ? AND cid = ?";
        Object[] params = {cartid,cid};
        JdbcTemplate.update(sql, params);
    }

    @Override
    public Cart get(Long cartid, Long cid) {
        String sql = "SELECT * FROM cart WHERE cartid = ? AND cid = ?";
        return JdbcTemplate.query(sql,new BeanHandler<>(Cart.class), cartid, cid);
    }

    @Override
    public List<Cart> query(Long cartid) {
        String sql = "SELECT * FROM cart WHERE cartid = ?";
        return JdbcTemplate.query(sql, new BeanListHandler<>(Cart.class), cartid);
    }
}
