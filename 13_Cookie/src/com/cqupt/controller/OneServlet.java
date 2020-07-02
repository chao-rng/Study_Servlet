package com.cqupt.controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.PrinterGraphics;
import java.io.IOException;
import java.io.PrintWriter;

public class OneServlet extends HttpServlet {

    //OneServlet负责为客户开卡
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.获取请求头中的参数信息
        String userName = request.getParameter("userName");
        String money = request.getParameter("money");
        //2.创建两个Cookie对象
        Cookie card1 = new Cookie("userName",userName);
        Cookie card2 = new Cookie("money",money);

        //3.手动设置Cookie的存活时间(card2将在计算机硬盘中存活1分钟，而card1则存储在内存中，关闭浏览器后card1消失)
        card2.setMaxAge(60);//括号里单位是秒s
        //4.将两个Cookie对象写入响应体中
        response.addCookie(card1);
        response.addCookie(card2);
        //5.将点餐页面写入响应体
        //重定向中请求地址格式：/网站名/资源文件名
        response.sendRedirect("/myWeb/index_2.html");
        //第4步还可以使用请求转发解决方案
        //请求转发中请求地址格式：/资源文件名；
    }
}
