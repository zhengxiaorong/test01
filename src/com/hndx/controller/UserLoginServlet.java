package com.hndx.controller;

import com.hndx.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName,password;
        UserDao dao = new UserDao();

        request.setCharacterEncoding("utf-8");
        userName = request.getParameter("userName");
        password = request.getParameter("password");
        String s = dao.login(userName,password) ? "/myWeb/index.html" : "/myWeb/login_error.html";
        response.sendRedirect(s);
    }
}
