package com.cqupt.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OneServlet extends HttpServlet {

    /*
    用户需求：用户去饭馆吃饭
        OneServlet负责用户点餐
        TwoServlet负责炒菜
        ThreeServlet负责上菜
     */
    //这种方式处理，地址栏的请求地址不会发生改变
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("OneServlet.....顾客点了一份青椒肉丝盖饭");
        //1.通过当前请求对象生成资源文件申请报告对象
        RequestDispatcher report = request.getRequestDispatcher("/two");
        //2.将申请报告对象发送给Tomcat服务器
        report.forward(request,response);
    }
}
