package com.cqupt.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ThreeServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print("<center>");
        out.print("<font style='color:red;font-size:40px'>菜已上全，请您慢慢享用</font>");
        out.print("</center>");
        System.out.println(" ThreeServlet.......菜已上全，请您慢慢享用");
    }
}
