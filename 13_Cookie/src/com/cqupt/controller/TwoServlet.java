package com.cqupt.controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TwoServlet extends HttpServlet {

    //TwoServlet负责满足客户点餐需求
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int jiaozi_money = 20;
        int chaomian_money = 15;
        int gaifan_money = 20;
        String userName = null;
        int money = 0,xiaofei=0,balance=0;
        Cookie newCard = null;
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //1.获取请求头中的请求参数
        String food = request.getParameter("food");
        //2.读取请求头中Cookie，获取用户会员卡
        //getCookies()方法可以获得请求头中所有cookie，并返回一个cookie数组
        Cookie[] cookies = request.getCookies();
        //3.根据事务类型进行不同处理
        //取的时候使用if进行判断就好了啊！！！！！！！！！！！！！！
        for (Cookie card:cookies) {
            String key = card.getName();
            String value = card.getValue();
            if("userName".equals(key)){
                userName = value;
            }else if("money".equals(key)){
                money = Integer.valueOf(value);
                if("饺子".equals(food)){
                    if(money < jiaozi_money){
                        out.print("用户"+userName+"卡中余额不足，请充值！");
                    }else{
                        xiaofei = jiaozi_money;
                        balance = money - jiaozi_money;
                        newCard = new Cookie("money",balance+"");//巧妙的使用了字符串拼接功能
                    }
                }
                if("炒面".equals(food)){
                    if(money < chaomian_money){
                        out.print("用户"+userName+"卡中余额不足，请充值！");
                    }else{
                        xiaofei = chaomian_money;
                        balance = money - chaomian_money;
                        newCard = new Cookie("money",balance+"");//巧妙的使用了字符串拼接功能
                    }
                }
                if("盖饭".equals(food)){
                    if(money < gaifan_money){
                        out.print("用户"+userName+"卡中余额不足，请充值！");
                    }else{
                        xiaofei = gaifan_money;
                        balance = money - gaifan_money;
                        newCard = new Cookie("money",balance+"");//巧妙的使用了字符串拼接功能

                    }
                }
            }
        }
        //4.将Cookie返回给浏览器
        response.addCookie(newCard);
        //5.将执行结果写入到响应体中
        out.print(userName+"购买了一份"+food+"，本次消费："+xiaofei+"余额："+balance);
    }
}
