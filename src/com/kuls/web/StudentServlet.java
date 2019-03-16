package com.kuls.web;

import com.kuls.bean.Tb_student_info;
import com.kuls.service.StudentService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "StudentServlet",urlPatterns = "/student")
public class StudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String method = request.getParameter("method");
        if ("addstudent".equals(method)){
            addstudent(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    public void addstudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        int xb = Integer.parseInt(request.getParameter("xb"));
        String data = request.getParameter("date");
        String minzu = request.getParameter("minzu");
        String zzmm = request.getParameter("zzmm");
        String zhiwu = request.getParameter("zhiwu");

        System.out.println(name);
        StudentService studentService = new StudentService();
        boolean b = false;
        try {
            b = studentService.add(name,xb,data,minzu,zzmm,zhiwu);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (b){
            response.setStatus(201);
            request.getRequestDispatcher("addstudent.jsp").forward(request,response);
        }else{
            response.setStatus(600);
            request.getRequestDispatcher("addstudent.jsp").forward(request,response);
        }

    }

}
