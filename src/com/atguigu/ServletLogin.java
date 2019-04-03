package com.atguigu;

import com.alibaba.druid.util.JdbcUtils;
import com.atguigu.bean.Employee;
import com.atguigu.dao.BasicDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletLogin",urlPatterns = "/login")
public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter writer = response.getWriter();
        writer.write(password);
        System.out.println(password);
        BasicDao basicDao = new BasicDao();
        String sql="select id,last_name,dept from employees where id=?";
        Employee bean = basicDao.getBean(Employee.class, sql, username);
        writer.println(bean);
        System.out.println(bean);
    }
}
