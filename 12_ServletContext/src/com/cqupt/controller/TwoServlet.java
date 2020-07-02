package com.cqupt.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TwoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //需要先运行OneServlet将数据放进去
        //索要全局作用域对象ServletContext
        ServletContext application = request.getServletContext();
        //读取数据
        Integer data = (Integer)application.getAttribute("key1");//强制类型转换
        System.out.println("TwoServlet...."+data);

    }
}
