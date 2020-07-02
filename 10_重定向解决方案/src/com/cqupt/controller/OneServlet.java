package com.cqupt.controller;

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

    //这种方式的地址栏请求地址会发生改变，最后停留在最后一个服务器的地址
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("OneServlet 顾客点了一份番茄牛腩盖浇饭！");
        response.sendRedirect("/myWeb/two");

    }
}
