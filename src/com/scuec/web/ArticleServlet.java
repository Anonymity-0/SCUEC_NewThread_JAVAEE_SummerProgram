package com.scuec.web;

import com.scuec.pojo.Article;
import com.scuec.service.ArticleService;
import com.scuec.service.impl.ArticleServiceImpl;
import com.scuec.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ArticleServlet extends BaseServlet{

    private ArticleService articleService = new ArticleServiceImpl();


    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Article article = WebUtils.copyParamToBean(req.getParameterMap(),new Article());
        System.out.println(article);
        articleService.addArtical(article);

        resp.sendRedirect(req.getContextPath() + "/manager/ArticleServlet?action=list");

    }



    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        articleService.deleteArticalById(id);
        resp.sendRedirect(req.getContextPath() + "/manager/ArticleServlet?action=list");
    }



    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        System.out.println(id);
        Article article = WebUtils.copyParamToBean(req.getParameterMap(),new Article());
        articleService.updateArtical(article);
        resp.sendRedirect(req.getContextPath() + "/manager/ArticleServlet?action=list");
    }



    protected void getArtical(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Article article = articleService.queryArticalById(id);
        req.setAttribute("article", article) ;
        req.getRequestDispatcher("/pages/manager/article_edit.jsp").forward(req,resp);
    }



    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Article> articles = articleService.queryArticals();
        req.setAttribute("articles", articles);
        long count=articleService.countArticle();
        req.setAttribute("count",count);
        req.getRequestDispatcher("/pages/manager/article_manager.jsp").forward(req,resp);
    }

    protected void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String header=req.getParameter("header");
        System.out.println(header);
        String author=req.getParameter("author");
        Integer id= WebUtils.parseInt(req.getParameter("id"),0);
        List<Article> articles = articleService.queryArticalsByItem(author,header,id);
        req.setAttribute("header",header);
        req.setAttribute("author",author);
        req.setAttribute("id",id);
        req.setAttribute("articles", articles);
        req.getRequestDispatcher("/pages/manager/article_manager.jsp").forward(req,resp);
    }


}
