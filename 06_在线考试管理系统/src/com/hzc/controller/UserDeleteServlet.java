package com.hzc.controller;

import com.hzc.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserDeleteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.调用【请求对象】读取【请求体】中的请求参数信息【用户编号】
        String userId = request.getParameter("userId");
        //2.调用【dao】类将delete命令发送给数据库服务器
        UserDao dao = new UserDao();
        int result = 0;
        result = dao.delete(userId);
        //3.调用【响应对象】将执行结果写入【响应体】
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //根据result的值来输出不同的语句
        if (result == 1){
            out.print("<font style='color:red;font-size:20px'>用户信息删除成功</font>");
        }else{
            out.print("<font style='color:red;font-size:20px'>用户信息删除失败</font>");
        }
    }
}
