package com.rapoo.store.handler;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;

public class BeanHandler<T> implements IResultSetHandler<T>{
    private Class<T> classType;

    public BeanHandler(Class<T> classType) {
        this.classType = classType;
    }

    @Override
    public T handle(ResultSet rs) throws Exception{
        T obj = classType.newInstance();
        BeanInfo beanInfo = Introspector.getBeanInfo(classType,Object.class);
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        if(rs.next()){
            for (PropertyDescriptor pd : pds) {
                String columnName = pd.getName();
                Object val = rs.getObject(columnName);
                pd.getWriteMethod().invoke(obj, val);
            }
        }
        return obj;
    }
}
