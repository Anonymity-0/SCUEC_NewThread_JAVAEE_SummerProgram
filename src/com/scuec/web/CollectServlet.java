package com.scuec.web;

import com.scuec.pojo.Article;
import com.scuec.pojo.Collect;
import com.scuec.pojo.User;
import com.scuec.service.ArticleService;
import com.scuec.service.CollectService;
import com.scuec.service.impl.ArticleServiceImpl;
import com.scuec.service.impl.CollectServiceImpl;
import com.scuec.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectServlet extends BaseServlet {

    private ArticleService articleService = new ArticleServiceImpl();
    private CollectService collectService = new CollectServiceImpl();


/**
     * 删除
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String id = req.getParameter("id");
        System.out.println(id+"123");
        collectService.deleteByid(id);
        resp.sendRedirect(req.getContextPath() + "/collectServlet?action=list");

    }
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user =(User) req.getSession().getAttribute("user");
        Integer id = user.getId();
        List<Collect> collects = collectService.getContentById(id);
        req.setAttribute("collect", collects);
        req.getRequestDispatcher("/pages/user/collect.jsp").forward(req,resp);
    }




    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        Integer articleid = Integer.valueOf(req.getParameter("id"));
        String header = req.getParameter("header");
        String author =req.getParameter("username");
        System.out.println(header);
        System.out.println(articleid);
        System.out.println(collectService.addCollect(new Collect(articleid,user.getId(),header,author)));
        System.out.println("请求头Referer的值：" + req.getHeader("Referer"));
        resp.sendRedirect(req.getHeader("Referer"));
    }
    protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        Article article = articleService.queryArticalById(id+"");
        Collect collect = (Collect) req.getSession().getAttribute("collect");
        if (collect == null) {
            User user = (User) req.getSession().getAttribute("user");
            req.getSession().setAttribute("collect",collect);
        }

        System.out.println(collect);
        Map<String,Object> resultMap = new HashMap<String,Object>();

        Gson gson = new Gson();
        String resultMapJsonString = gson.toJson(resultMap);

        resp.getWriter().write(resultMapJsonString);
}
}
