package com.rapoo.store.handler;

import java.sql.ResultSet;

public class CountHandler implements IResultSetHandler<Long>{
    @Override
    public Long handle(ResultSet rs) throws Exception {
        if(rs.next()){
            return rs.getLong(1);
        }
        return 0L;
    }
}
