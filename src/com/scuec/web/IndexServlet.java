package com.scuec.web;

import com.scuec.pojo.Article;
import com.scuec.pojo.Collect;
import com.scuec.pojo.User;
import com.scuec.service.ArticleService;
import com.scuec.service.impl.ArticleServiceImpl;
import com.scuec.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IndexServlet extends BaseServlet {

    private ArticleService articleService = new ArticleServiceImpl();

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user =(User) req.getSession().getAttribute("user");
        if (user==null){
            req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
        }else {
            String username = user.getUsername();
            List<Article> articles = articleService.queryArticals();
            req.setAttribute("articles", articles);
            req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
        }
    }


    protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        Article article = articleService.queryArticalById(id+"");
        Collect collect = (Collect) req.getSession().getAttribute("collect");
        if (collect == null) {
            User user = (User) req.getSession().getAttribute("user");
            //collect = new Collect("123",new Date(),user.getId());
            req.getSession().setAttribute("collect",collect);
        }
      //  collect.addItem(collectItem);

        System.out.println(collect);
        Map<String,Object> resultMap = new HashMap<String,Object>();
        Gson gson = new Gson();
        String resultMapJsonString = gson.toJson(resultMap);

        resp.getWriter().write(resultMapJsonString);
}
    protected void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String header=req.getParameter("header");
        System.out.println(header);
        String author=req.getParameter("author");
        Integer id= WebUtils.parseInt(req.getParameter("id"),0);
        List<Article> articles = articleService.queryArticalsByItem(author,header,id);
        //保存到Request域中
        req.setAttribute("header",header);
        req.setAttribute("author",author);
        req.setAttribute("id",id);
        req.setAttribute("articles", articles);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }

}
