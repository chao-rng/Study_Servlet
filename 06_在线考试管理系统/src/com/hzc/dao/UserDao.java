package com.hzc.dao;

import com.hzc.entity.Users;
import com.hzc.util.JdbcUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLRecoverableException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    //创建工具类对象
    JdbcUtil util = new JdbcUtil();

    //1.用户信息注册
    public int add(Users user) {
        //可以使用4个占位符，也可以直接写变量名
        //String sql = "insert into users(userName,password,sex,email)" + "values(?,?,?,?)";
        String sql ="insert into users(userName,password,sex,email)" +
                " values(?,?,?,?)";
        PreparedStatement ps = util.createStatement(sql);
        int result = 0;
        try {
            //这里必须使用get方法来获取对应的属性
            ps.setString(1,user.getUserName());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getSex());
            ps.setString(4,user.getEmail());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close();
        }
        return result;
    }
    //2.用户信息查询
    public List findAll(){
        String sql = "select * from users";
        PreparedStatement ps = util.createStatement(sql);
        ResultSet rs = null;
        List <Users> userList = new ArrayList<>();
        try {
            rs = ps.executeQuery();
            while(rs.next()){
                Integer userId = rs.getInt("userId");
                String userName = rs.getString("userName");
                String password = rs.getString("password");
                String sex = rs.getString("sex");
                String email = rs.getString("email");
                Users users = new Users(userId,userName,password,sex,email);
                userList.add(users);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(rs);
        }
        return userList;
    }
    //3.用户信息删除
    public int delete(String userId){
        //学会使用占位符?
        String sql = "delete from users where userId = ?";
        PreparedStatement ps = util.createStatement(sql);
        int result = 0;
        try {
            ps.setInt(1,Integer.valueOf(userId));
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close();
        }
        return result;
    }
    //4.用户登录
    public int login(String userName,String password){
        String sql = "select count(*) as userCount from users where userName = ? and password = ?";
        PreparedStatement ps = util.createStatement(sql);
        ResultSet rs = null;
        int result = 0;
        try {
            ps.setString(1,userName);
            ps.setString(2,password);
            rs = ps.executeQuery();
            //遍历结果集，取出count的值将其赋给result
            //将userCount的值赋给result
            while(rs.next()){
                result = rs.getInt("userCount");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(rs);
        }
        return result;

    }
}
