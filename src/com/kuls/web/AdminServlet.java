package com.kuls.web;

import com.kuls.bean.Tb_admin;
import com.kuls.service.AdminUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AdminServlet", urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // servlet的抽取
        String method = request.getParameter("method");
        if ("login".equals(method)){
            login(request,response);
        }
    }
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("a_user");
        String password = request.getParameter("a_pass");
        AdminUserService adminUserService = new AdminUserService();
        Tb_admin tb_admin = null;
        try {
            tb_admin = adminUserService.login(username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String remember = request.getParameter("remember");
        if (tb_admin!=null){
            if ("remember".equals(remember)){
                Cookie namecookie = new Cookie("name",username);
                Cookie passcookie = new Cookie("password",password);
                namecookie.setMaxAge(60*10);
                passcookie.setMaxAge(60*10);
                response.addCookie(namecookie);
                response.addCookie(passcookie);

            }
            request.getSession().setAttribute("user",tb_admin);
            // 登陆成功，跳转至管理界面
            response.sendRedirect(request.getContextPath()+"/getStudents?currentPage=1&currentCount=10");
        }else {
            //登录失败提示
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("登录失败！");
        }
    }
}
