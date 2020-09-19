package com.scuec.web;

import com.scuec.pojo.Article;
import com.scuec.pojo.User;
import com.scuec.service.ArticleService;
import com.scuec.service.impl.ArticleServiceImpl;
import com.scuec.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ArticleServlet1 extends BaseServlet{

    private ArticleService articleService = new ArticleServiceImpl();


    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Article article = WebUtils.copyParamToBean(req.getParameterMap(),new Article());
        System.out.println(article);
        articleService.addArtical(article);

        resp.sendRedirect(req.getContextPath() + "/user/ArticleServlet?action=list");

    }



    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        System.out.println(id);
        articleService.deleteArticalById(id);
        resp.sendRedirect(req.getContextPath() + "/user/ArticleServlet?action=list");
    }



    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        System.out.println(id);
        Article article = WebUtils.copyParamToBean(req.getParameterMap(),new Article());
        articleService.updateArtical(article);
        resp.sendRedirect(req.getContextPath() + "/user/ArticleServlet?action=list");
    }



    protected void getArtical(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Article article = articleService.queryArticalById(id);
        req.setAttribute("article", article) ;
        req.getRequestDispatcher("/pages/user/article_edit.jsp").forward(req,resp);
    }



    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user =(User) req.getSession().getAttribute("user");
        String author= user.getUsername();
        List<Article> articles = articleService.queryArticalsByAuthor(author);
        req.setAttribute("articles", articles);
        req.getRequestDispatcher("/pages/user/article_manager.jsp").forward(req,resp);
    }
    /**
     * 处理分页功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

    protected void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String header=req.getParameter("header");
        System.out.println(header);
        String author=req.getParameter("author");
        Integer id= WebUtils.parseInt(req.getParameter("id"),0);
        List<Article> articles = articleService.queryArticalsByItem(author,header,id);
        //2 把全部图书保存到Request域中
        req.setAttribute("header",header);
        req.setAttribute("author",author);
        req.setAttribute("id",id);
        req.setAttribute("articles", articles);
        //3、请求转发到/pages/manager/book_manager.jsp页
        req.getRequestDispatcher("/pages/user/article_manager.jsp").forward(req,resp);
    }
    protected void article(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id=WebUtils.parseInt(req.getParameter("id"),0);
        Article article = articleService.queryArticalById(id);
        req.setAttribute("article", article);
        req.getRequestDispatcher("/pages/client/article.jsp").forward(req,resp);
    }


}
