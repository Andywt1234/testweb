package com.atguigu.dao;

import com.atguigu.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @program: javaweb
 * @description:
 * @author: wangtian
 * @create: 2019-04-03 19:30
 **/
public class BasicDao {
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * 通用的增删改的方法
     *
     * @param sql
     * @param params
     * @return
     */
    public int update(String sql, Object... params) {
        // 获取连接
        Connection connection = JDBCUtils.getConnection();
        int count = 0;
        try {
            count = queryRunner.update(connection, sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.releaseConnection(connection);
        }
        return count;
    }

    /**
     * 获取一个对象的方法
     * @param type
     * @param sql
     * @param params
     * @return
     */
    public <T> T getBean(Class<T> type, String sql, Object... params) {
        //获取连接
        Connection connection = JDBCUtils.getConnection();
        T t = null;
        try {
            t = queryRunner.query(connection, sql, new BeanHandler<T>(type), params);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.releaseConnection(connection);
        }
        return t;
    }

    /**
     * 获取一个集合的方法
     * @param type
     * @param sql
     * @param params
     * @return
     */
    public <T> List<T> getBeanList(Class<T> type, String sql, Object... params) {
        //获取连接
        Connection connection = JDBCUtils.getConnection();
        List<T> list = null;
        try {
            list = queryRunner.query(connection, sql, new BeanListHandler<T>(type), params);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.releaseConnection(connection);
        }
        return list;
    }

}
