package com.kuls.web;

import com.kuls.bean.Page;
import com.kuls.bean.Tb_student_info;
import com.kuls.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "GetStudentServlet", urlPatterns = "/getStudents")
public class GetStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StudentService studentService = new StudentService();
        try {
            System.out.println(request.getParameter("currentPage"));
            int currentPage = Integer.parseInt(request.getParameter("currentPage"));
            int currentCount = Integer.parseInt(request.getParameter("currentCount"));
            if (currentPage==0){
                currentPage=1;
            }
            if (currentCount==0){
                currentPage=10;
            }
            Page page = studentService.getPageStudents(currentPage,currentCount);
            System.out.println(page.getTotalPage());
            if (page!=null){
                request.setAttribute("page",page);
                request.getRequestDispatcher("/student-list.jsp").forward(request,response);
            }else {
                request.getRequestDispatcher("/student-list.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
