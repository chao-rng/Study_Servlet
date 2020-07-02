package com.cqupt.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OneServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //OneServlet将数据放进全局作用域对象中（键值对的方式存放）
        //1.调用【请求对象】想服务器索要全局作用域对象
        //习惯将该对象命名为application
        ServletContext application = request.getServletContext();
        application.setAttribute("key1",1000);
    }
}
