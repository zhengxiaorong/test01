package com.hndx.controller;

import com.hndx.dao.QuestionDao;
import com.hndx.entity.Question;
import com.hndx.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionAddServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title,optionA,optionB,optionC,optionD,answer;
        title = request.getParameter("answer");
        optionA = request.getParameter("optionA");
        optionB = request.getParameter("optionB");
        optionC = request.getParameter("optionC");
        optionD = request.getParameter("optionD");
        answer = request.getParameter("answer");
        Question question = new Question(null,title,optionA,optionB,optionC,optionD,answer);
        QuestionDao dao = new QuestionDao();
        boolean flag = dao.add(question);
        request.setAttribute("info",flag ? "试题添加成功" :"试题添加失败");
        request.getRequestDispatcher("/info.jsp").forward(request,response);
    }
}
