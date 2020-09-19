package com.scuec.service;

import com.scuec.pojo.Article;

import java.util.List;

public interface ArticleService {

    public void addArtical(Article article);

    public void deleteArticalById(String id);

    public void updateArtical(Article article);

    public Article queryArticalById(Integer id);
    public Long countArticle();
    public List<Article> queryArticals();
    public List<Article> queryArticalsByAuthor(String author);
    public Article queryArticalById(String id);
    public List<Article> queryArticalsByItem(String author,String header,Integer id);
    public void save(List<Article> articles);
}
