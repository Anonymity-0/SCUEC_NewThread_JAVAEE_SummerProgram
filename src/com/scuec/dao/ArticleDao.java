package com.scuec.dao;

import com.scuec.pojo.Article;

import java.util.List;

/**
 * @author anonymity-0
 * @date 2020/8/28 - 17:42
 */
public interface ArticleDao {
    public int addArticle(Article article);
    public int deleteByid(String id);
    public int updateArtical(Article article);
    public Long countArtical();
    public Article queryArticleById(Integer id);
    public List<Article> queryArticals();
    public List<Article> getContentByArticleId(Integer id);
    public List<Article> queryArticalsBesides(String author);
    public List<Article> queryArticalsByAuthor(String author);
    public List<Article> queryArticalsByItem(String author,String header,Integer id);
    public void save(List<Article> articles);
    public Article queryArticleById(String id);
}

