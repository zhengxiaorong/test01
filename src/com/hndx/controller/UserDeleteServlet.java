package com.hndx.controller;

import com.hndx.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserDeleteServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId;
        UserDao dao = new UserDao();
        PrintWriter out;
        userId = request.getParameter("userId");
        response.setContentType("text/html ;charset=utf-8");
        out = response.getWriter();
        out.print(dao.delete(userId) ? "删除成功" : "删除失败");
    }
}
