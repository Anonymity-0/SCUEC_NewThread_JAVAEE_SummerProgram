package com.scuec.web;

import com.scuec.pojo.Article;
import com.scuec.pojo.Attention;
import com.scuec.pojo.Collect;
import com.scuec.pojo.User;
import com.scuec.service.ArticleService;
import com.scuec.service.AttentionService;
import com.scuec.service.impl.ArticleServiceImpl;
import com.scuec.service.impl.AttentionServiceImpl;
import com.scuec.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AttentionServlet extends BaseServlet {

    private ArticleService articleService = new ArticleServiceImpl();
    private AttentionService attentionService = new AttentionServiceImpl();



/**
     * 删除
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String username = req.getParameter("username");
        attentionService.deleteByName(username);
        resp.sendRedirect(req.getContextPath() + "/attentionServlet?action=list");

    }
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user =(User) req.getSession().getAttribute("user");
        Integer id = user.getId();
        List<Attention> attentions = attentionService.getAttentionByUsertId(id);
        req.setAttribute("attention", attentions);
        req.getRequestDispatcher("/pages/user/attention.jsp").forward(req,resp);
    }


/**
     * 加入购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        System.out.println(user);
        String username = req.getParameter("username");
        Integer id = WebUtils.parseInt(req.getParameter("id"),0);
        System.out.println(attentionService.addAttention(new Attention(id,username,user.getId())));
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
      //  collect.addItem(collectItem);

        System.out.println(collect);

        Map<String,Object> resultMap = new HashMap<String,Object>();

        Gson gson = new Gson();
        String resultMapJsonString = gson.toJson(resultMap);

        resp.getWriter().write(resultMapJsonString);
}
}
