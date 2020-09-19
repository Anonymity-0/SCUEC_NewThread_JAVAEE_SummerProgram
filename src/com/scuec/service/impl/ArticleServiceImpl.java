package com.scuec.service.impl;

import com.scuec.dao.ArticleDao;
import com.scuec.dao.impl.ArticleDaoImpl;
import com.scuec.pojo.Article;
import com.scuec.service.ArticleService;

import java.util.List;

public class ArticleServiceImpl implements ArticleService {

    private ArticleDao articleDao = new ArticleDaoImpl() {
    };

    @Override
    public void addArtical(Article article) {
        articleDao.addArticle(article);
    }

    @Override
    public void deleteArticalById(String id) {
        articleDao.deleteByid(id);
    }

    @Override
    public void updateArtical(Article article) {
        articleDao.updateArtical(article);
    }

    @Override
    public Article queryArticalById(Integer id) {
        return articleDao.queryArticleById(id);
    }

    @Override
    public Long countArticle() {
        return articleDao.countArtical();
    }

    public Article queryArticalById(String id) {
        return articleDao.queryArticleById(id);
    }

    @Override
    public List<Article> queryArticals() {
        return articleDao.queryArticals();
    }

    @Override
    public List<Article> queryArticalsByAuthor(String author) {
        return articleDao.queryArticalsByAuthor(author);
    }



    @Override
    public List<Article> queryArticalsByItem(String author, String header, Integer id) {
        return articleDao.queryArticalsByItem(author,header,id);
    }

    @Override
    public void save(List<Article> articles) {
        articleDao.save(articles);
    }
}
