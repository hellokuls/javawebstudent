package com.kuls.filter;

import com.kuls.bean.Tb_admin;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "UserFilter",urlPatterns = "")
public class UserFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
       // 获取session，校验用户信息
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        Tb_admin user = (Tb_admin) session.getAttribute("user");
        String url = request.getRequestURI();
        int idx = url.lastIndexOf("/");
        String endWith = url.substring(idx + 1);

        /*不是登录页面  进行拦截处理*/
        if (!endWith.equals("login.jsp")) {
            //判断user是否为空，如果为空，跳转至登录界面
            if (user==null){
                //重定向
                response.sendRedirect(request.getContextPath()+"/login.jsp");
                return;
            }else{
                chain.doFilter(req,resp);
            }
        } else {
                chain.doFilter(req,resp);
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
