package com.scuec.web;

import com.scuec.pojo.User;
import com.scuec.service.UserService;
import com.scuec.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String code = req.getParameter("code");

//        2、检查 验证码是否正确
        if ("abcde".equalsIgnoreCase(code)) {
//        3、检查 用户名是否可用
            if (userService.existsUsername(username)) {
                req.setAttribute("msg","用户名已存在");
                req.setAttribute("username",username);
                System.out.println("用户名[" + username + "]已存在!");
//        跳回注册页面
                req.getRequestDispatcher("pages/user/regist.jsp").forward(req, resp);
            } else {
                //      可用
//                调用Service保存到数据库
                userService.registUser(new User(null, username, password));
//
//        跳到注册成功页面 regist_success.jsp

                req.getRequestDispatcher("pages/user/regist_success.jsp").forward(req, resp);
            }
        } else {
            System.out.println("验证码[" + code + "]错误");
            req.setAttribute("msg","验证码");
            req.setAttribute("username",username);
            req.getRequestDispatcher("pages/user/regist.jsp").forward(req, resp);
        }
    }
}
