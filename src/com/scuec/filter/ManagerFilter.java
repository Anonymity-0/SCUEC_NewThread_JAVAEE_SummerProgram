package com.scuec.filter;

import com.scuec.pojo.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ManagerFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        Object user = httpServletRequest.getSession().getAttribute("user");

        if (user != null) {
            User user1 = (User) user;
            System.out.println(user1.getUsername());
            if (user1.getUsername().equals("administrator")){
                filterChain.doFilter(servletRequest,servletResponse);
            }else {
                httpServletRequest.getRequestDispatcher("/pages/client/index.jsp").forward(servletRequest,servletResponse);
            }
        } else {
            httpServletRequest.getRequestDispatcher("/pages/user/login.jsp").forward(servletRequest,servletResponse);
        }


    }

    @Override
    public void destroy() {

    }
}
