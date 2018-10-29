package com.rapoo.store.dao;

import com.rapoo.store.Cart;
import com.rapoo.store.Commodity;

import java.util.List;

public interface ICartDAO {
    /**
     * 添加商品到购物车
     * @param cartid 当前用户的购物车cartid
     */
    public void add(Long cartid, Commodity commodity);
    /**
     *更新当前用户的购物车
     * @param cartid 当前用户的购物车cartid
     * @param cid 更新的商品信息
     */
    public void update(Long cartid, Long cid, Integer count);

    /**
     * 删除当前用户的指定cid的商品
     * @param cartid 当前用户的购物车cartid
     * @param cid 要删除的商品cid
     */
    public void delete(Long cartid, Long cid);

    /**
     * 查找当前用户购物车中指定cid的商品
     * @param cartid 当前用户的购物车cartid
     * @param cid 要查找的商品
     * @return
     */
    public Cart get(Long cartid, Long cid);

    public List<Cart> query(Long cartid);
}
