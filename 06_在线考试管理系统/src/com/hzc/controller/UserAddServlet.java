package com.hzc.controller;

import com.hzc.dao.UserDao;
import com.hzc.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserAddServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName;
        String password;
        String sex;
        String email;
        Integer userId = null;
        Users user = null;
        int result;
        //1.调用【请求对象】读取【请求头】中的请求参数信息
       userName =  request.getParameter("userName");
       password =  request.getParameter("password");
       sex = request.getParameter("sex");
       email = request.getParameter("email");
        //2.调用【Userdao】类将用户信息添加到insert命令，并通过jdbc规范发送给数据库
        UserDao dao = new UserDao();
        user = new Users(userId,userName,password,sex,email);
        result = dao.add(user);
        //3.调用【响应对象】将【处理结果】以二进制的形式写入到响应体中
        //向浏览器所要输出流
        //通知浏览器使用对应的编译器进行解析
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //根据result的值来提示用户不同的显示信息
        if(result == 1){
            out.print("<font style='color:red;font-size:40'>用户信息注册成功</font>");
        }else{
            out.print("<font style='color:red;font-size:40'>用户信息注册失败</font>");
        }
        //Tocmat负责销毁【请求对象】和【响应对象】
        //Tomcat负责将Http响应协议包推送到发起请求的浏览器上
        //浏览器根据响应头content-type指定编译器对响应体二进制内容编辑
        //浏览器将编辑后结果在窗口中展示给用户【结束】
    }
}
