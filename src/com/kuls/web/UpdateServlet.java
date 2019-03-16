package com.kuls.web;

import com.kuls.bean.Tb_student_info;
import com.kuls.service.StudentService;
import com.mchange.v2.beans.BeansUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet(name = "UpdateServlet",urlPatterns = "/update")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
       doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Map<String, String[]> map = request.getParameterMap();
            Tb_student_info student_info = new Tb_student_info();
            BeanUtils.populate(student_info,map);
            StudentService studentService = new StudentService();
            boolean b = studentService.update(student_info);
            if (b){
                // 修改成功，重定向至管理界面
                response.sendRedirect(request.getContextPath()+"/getStudents?currentPage=1&currentCount=10");
            }else{
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("修改失败！");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
