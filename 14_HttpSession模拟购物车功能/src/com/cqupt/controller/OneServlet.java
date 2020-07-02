package com.cqupt.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class OneServlet extends HttpServlet {

    //HttpSession模拟购物车功能
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.读取请求头中的请求参数
        String goodsName = request.getParameter("goodsName");
        //2.通过请求对象想Tomcat服务器索要HttpSession【会话作用域对象】对象
        HttpSession session = request.getSession();
        //3.将共享数据写入服务器
        //session.setAttribute(goodsName,1);
        /*
        不能直接将数据写入，需要进行判断，如果已经存在了，则商品数量加1！！！
         */
        //我丢累啊，不是request.getAttribute(),而是session.getAttribute
        //Integer goodsNum = (Integer)request.getAttribute(goodsName);//Integer可以防止空指针异常
        Integer goodsNum = (Integer)session.getAttribute(goodsName);//Integer可以防止空指针异常
        if(goodsNum == null){
            session.setAttribute(goodsName,1);
        }else{
            session.setAttribute(goodsName,goodsNum+1);
        }

    }
}
