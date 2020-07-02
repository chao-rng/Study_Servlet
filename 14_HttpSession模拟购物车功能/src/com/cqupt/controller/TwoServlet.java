package com.cqupt.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

public class TwoServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.通过请求对象向Tomcat服务器索要会话作用域对象
        HttpSession session = request.getSession();
        //session.getAttribute("goodsName");
        /*
        不能直接读取数据，因为里边可能不止一个，你并不知道读取几次
         */
        Enumeration goodNames = session.getAttributeNames();
        while(goodNames.hasMoreElements()){
            //goodName相当于map中key
            String goodName = (String)goodNames.nextElement();
            //这里使用int不会出现空指针异常，因为上边的已经判断过
            //通过key获取value
            int goodsNum = (int)session.getAttribute(goodName);
            System.out.println("商品名称："+goodName+"\t商品数量："+goodsNum);
        }
    }
}
