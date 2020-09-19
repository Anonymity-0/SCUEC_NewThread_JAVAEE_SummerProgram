package com.scuec.test;

import com.scuec.dao.ArticleDao;
import com.scuec.dao.impl.ArticleDaoImpl;
import com.scuec.pojo.Article;

/**
 * @author anonymity-0
 * @date 2020/8/29 - 2:35
 */
class ArticleDaoTest {

    private ArticleDao articleDao = new ArticleDaoImpl();
    @org.junit.jupiter.api.Test
    void addArticle() {
        articleDao.addArticle(new Article(null,"header","content","author"
                ));
    }

    @org.junit.jupiter.api.Test
    void deleteByid() {
    }

    @org.junit.jupiter.api.Test
    void updateArtical() {
        articleDao.updateArtical(new Article(null,"header","content","author"
                ));
    }

    @org.junit.jupiter.api.Test
    void queryArticleById() {
        System.out.println(articleDao.queryArticleById("1"));
    }

    @org.junit.jupiter.api.Test
    void queryArticals() {
        for (Article article:articleDao.queryArticals()){
            System.out.println(article);
        }
    }
    @org.junit.jupiter.api.Test
    void getContentByArticleId() {
    }
}