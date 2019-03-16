package com.kuls.web;

import com.kuls.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DeleteServlet",urlPatterns = "/delete")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            System.out.println("id:"+id);
            StudentService studentService = new StudentService();
            boolean b = studentService.delete(id);
            if (b){
                response.sendRedirect(request.getContextPath()+"/getStudents?currentPage=1&currentCount=10");
            }else{
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("删除失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
