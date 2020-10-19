package com.hndx.controller;

import com.hndx.dao.UserDao;
import com.hndx.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserAddServlet")
public class UserAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName,password,sex,email;
        UserDao dao = new UserDao();
        Users user = null;
        int result = 0;
        PrintWriter out = null;
        //1.调用【请求对象】读取【请求头】参数信息，得到用户信息
        userName = request.getParameter("userName");
        password = request.getParameter("password");
        sex = request.getParameter("sex");
        email = request.getParameter("email");
        user = new Users(null,userName,password,sex,email);

        //2.调用【UserDao】将用户参数信息填充到数据库
        result = dao.add(user);

        //3.调用【响应对象】将处理结果以二进制写入响应体
        response.setContentType("text/html;charset = utf-8");
        out = response.getWriter();
        out.print(result==0 ? "<font style='color:red'>用户信息注册失败" : "用户信息注册成功");

    }
}
