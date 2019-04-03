package com.atguigu.test;

import com.atguigu.bean.Employee;
import com.atguigu.dao.BasicDao;

/**
 * @program: javaweb
 * @description:
 * @author: wangtian
 * @create: 2019-04-03 19:32
 **/
public class Test1 {
    public static void main(String[] args) {
        BasicDao basicDao = new BasicDao();
        String sql="select * from employees where id=?";
        Employee bean = basicDao.getBean(Employee.class, sql, "1");
        System.out.println(bean);
    }
}
