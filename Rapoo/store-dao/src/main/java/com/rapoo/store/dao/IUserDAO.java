package com.rapoo.store.dao;

import com.rapoo.store.User;

public interface IUserDAO {
    /**
     * 通过用户名得到user对象
     * @param username 登录的用户名
     * @return 返回一个user对象
     */
    User getUserByUsername(String username);
}
