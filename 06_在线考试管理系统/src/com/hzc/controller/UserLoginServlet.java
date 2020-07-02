package com.hzc.controller;

import com.hzc.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserLoginServlet extends HttpServlet {
    //用户登录时，请求方式应为post，所以需要调用doPost方法
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.调用请求对象对请求体中的请求参数使用utf-8进行重新编译
        //都doPost方法需要先进行这个步骤，因为其默认的编码方式是【ISO-8859-1】
        request.setCharacterEncoding("utf-8");

        //2.调用【请求对象】获取【请求体】中的请求参数信息【用户名】和【密码】
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        //3.调用【dao】将请求参数对应查询命令发送到数据库服务器进行查询（返回1或0）
        UserDao dao = new UserDao();
        int userCount = 0;
        userCount = dao.login(userName,password);

        //4.调用【响应对象】根据执行结果将不同资源文件执写入【响应头】中
        //我们要实现的功能是用户存在则跳转到用户注册页面，如果失败则跳转到新的用户登录页面
        //此时则需要用到【响应头】的location属性
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        if(userCount == 1){
            response.sendRedirect("/myWeb/index.html");
        }else{
            response.sendRedirect("/myWeb/login_error.html");
        }

    }

}
