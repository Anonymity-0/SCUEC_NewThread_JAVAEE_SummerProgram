package com.scuec.web;

import com.scuec.pojo.User;
import com.scuec.service.UserService;
import com.scuec.service.impl.UserServiceImpl;
import com.scuec.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet1 extends BaseServlet {

UserService userService=new UserServiceImpl();
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        System.out.println(id);
        User user = WebUtils.copyParamToBean(req.getParameterMap(),new User());
        userService.updateUser(user);
        resp.sendRedirect(req.getContextPath() + "/pages/client/index.jsp");
    }



    protected void getUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        User user = userService.queryUserById(id);
        req.setAttribute("user", user) ;
        req.getRequestDispatcher("/pages/user/user_edit.jsp").forward(req,resp);
    }
}
