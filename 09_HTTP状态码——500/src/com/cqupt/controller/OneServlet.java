package com.cqupt.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OneServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String s = null;
    s.concat("a");
    //空指针异常了
    System.out.println("....................");
    /*
    浏览器显示：
    java.lang.NullPointerException
	com.cqupt.controller.OneServlet.doGet(OneServlet.java:14)
	javax.servlet.http.HttpServlet.service(HttpServlet.java:634)
	javax.servlet.http.HttpServlet.service(HttpServlet.java:741)
	org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53)
     */
    }
}
