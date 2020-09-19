package com.scuec.dao.impl;

import com.scuec.dao.ArticleDao;
import com.scuec.pojo.Article;

import java.util.List;

/**
 * @author anonymity-0
 * @date 2020/8/28 - 17:52
 */
public class ArticleDaoImpl extends BaseDao implements ArticleDao {

    @Override
    public int addArticle(Article article) {
        String sql = "INSERT INTO t_article(id,header,content,author"
                + ") VALUES (?,?,?,?) ";
        return update(sql,article.getId(),article.getHeader(),article.getContent(),article.getAuthor()
        );
    }

    @Override
    public int deleteByid(String id) {
        String sql = "delete from t_article where id = ?";
        return update(sql,id);
    }

    @Override
    public int updateArtical(Article article) {
        String sql = "update t_article set header=?,content=?,author=?" +
                " where id =?";
        return update(sql,article.getHeader(),article.getContent(),article.getAuthor()
                ,article.getId());
    }

    @Override
    public Long countArtical() {
        String sql ="select count(*) from t_article";
        return (Long) queryForSingleValue(sql);
    }

    @Override
    public Article queryArticleById(Integer id) {
        String sql="select id,header,content,author" +
                " from t_article where id = ?";
        return queryForOne(Article.class,sql,id);
    }
    public Article queryArticleById(String id){
        String sql="select id,header,content,author" +
                " from t_article where id = ?";
        return queryForOne(Article.class,sql,id);
    }
    @Override
    public List<Article> queryArticals() {
        String sql="select id,header,content,author" +
                " from t_article";
        return queryForList(Article.class,sql);
    }

    @Override
        public List<Article> getContentByArticleId(Integer id){
            String sql = "select content from t_article where id = ?";
            return queryForList(Article.class,sql,id);
        }

    @Override
    public List<Article> queryArticalsBesides(String author) {
        String sql="select id,header,content,author" +
                " from t_article where author = ?";
        return queryForList(Article.class,sql,author);
    }


    @Override
    public List<Article> queryArticalsByAuthor(String author) {
        String sql="select id,header,content,author" +
                " from t_article where author = ?";
        return queryForList(Article.class,sql,author);
    }


    /**
     * 通过类别获取文章列表
     * @param categoryId
     * @param start
     * @param end
     * @return
     */
    public List<Article> getArticlesByCategoryId(Integer categoryId, Integer start, Integer end){
        String sql = "select id,header,name,author,"
                + "description from t_article where 1 = 1 "
                + " and category_id = ?"
                + "  order by update_time desc limit ?,?";
        return queryForList(Article.class,sql, categoryId,start,end);
    }
    public int deleteByid(Integer id) {
        String sql = "delete from t_article where id = ?";
        return update(sql,id);
    }
    public List<Article> queryArticalsByItem(String author,String header,Integer id) {
        String sql="select *from t_article where header like '%"+header+"%' and "+"author like '%"+author+"%'";
        if (id!=0)
            sql = "select *from t_article where header like '%"+header+"%' and "+"author like '%"+author+"%'and "+"id like '%"+id+"%'";
        System.out.println(sql);
        return queryForList(Article.class,sql);
    }

    @Override
    public void save(List<Article> articles) {
        String sql = "insert into t_article(`header`,`author`) values(?,?)";
        for (int i = 0; i < articles.size(); i++){
            update(sql, articles.get(i).getHeader(),articles.get(i).getAuthor());
        }
    }
}
