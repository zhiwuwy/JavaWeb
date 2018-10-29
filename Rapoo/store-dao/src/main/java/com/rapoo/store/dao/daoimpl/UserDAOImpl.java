package com.rapoo.store.dao.daoimpl;

import com.rapoo.store.User;
import com.rapoo.store.dao.IUserDAO;
import com.rapoo.store.handler.BeanHandler;
import com.rapoo.store.handler.IResultSetHandler;
import com.rapoo.store.util.JdbcTemplate;

import java.sql.ResultSet;

public class UserDAOImpl implements IUserDAO {

    @Override
    public User getUserByUsername(String username) {
        String sql = "SELECT * FROM user WHERE username = ?";
        return JdbcTemplate.query(sql, new IResultSetHandler<User>() {
            @Override
            public User handle(ResultSet rs) throws Exception {
                if(rs.next()){
                    User user = new User();
                    user.setUid(rs.getLong("uid"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setIdentity(rs.getString("identity"));
                    user.setCartid(rs.getLong("cartid"));
                    return user;
                }
                return null;
            }
        }, username);
    }
}
