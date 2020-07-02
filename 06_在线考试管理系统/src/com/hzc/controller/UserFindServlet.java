package com.hzc.controller;

import com.hzc.dao.UserDao;
import com.hzc.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class UserFindServlet extends HttpServlet {
    //用户查询功能
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.调用【dao】将查询命令发送到数据库服务器上，得到查询信息的list集合
        UserDao dao = new UserDao();
        List <Users> usersList = new ArrayList<>();
        usersList = dao.findAll();
        //2.调用【响应对象】将查询结果结合table标签以二进制形式写入响应体中
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print("<center>");
        out.print("<table border='2' align='center'>");
        out.print("<tr>");
        out.print("<td>用户编号</td>");
        out.print("<td>用户姓名</td>");
        out.print("<td>用户密码</td>");
        out.print("<td>用户性别</td>");
        out.print("<td>用户邮箱</td>");
        //添加用户删除操作功能
        out.print("<td>操作</td>");
        out.print("</tr>");
        for (Users users:usersList) {
            out.print("<tr>");
            out.print("<td>"+users.getUserId()+"</td>");
            out.print("<td>"+users.getUserName()+"</td>");
            //需要对用户的密码进行隐藏
            out.print("<td>*****</td>");
            out.print("<td>"+users.getSex()+"</td>");
            out.print("<td>"+users.getEmail()+"</td>");
            out.print("<td><a href= '/myWeb/user/delete?userId="+users.getUserId()+"'>删除用户</a></td>");

            out.print("</tr>");
        }
        out.print("</table>");
        out.print("</center>");

    }
}
