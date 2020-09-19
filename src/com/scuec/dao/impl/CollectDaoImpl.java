package com.scuec.dao.impl;

import com.scuec.dao.CollectDao;
import com.scuec.pojo.Collect;

import java.util.List;

/**
 * @author anonymity-0
 * @date 2020/9/2 - 21:13
 */
public class CollectDaoImpl extends BaseDao implements CollectDao {
    @Override
    public int addCollect(Collect collect) {
        if(queryCollectById(collect.getCollect_id())==null){
            System.out.println("add");
            String sql = "REPLACE INTO t_collect(collect_id,author,user_id,header"
                    + ") VALUES (?,?,?,?) ";
            return update(sql,collect.getCollect_id(),collect.getAuthor(),collect.getUser_id(),collect.getHeader());
        }
        else {
            System.out.println("delete");
            deleteByid(collect.getCollect_id()+"");
            return 0;
        }
    }

    @Override
    public int deleteByid(String id) {
        String sql = "delete from t_collect where collect_id = ?";
        return update(sql,id);
    }

    @Override
    public int updateCollect(Collect collect) {
        return 0;
    }

    @Override
    public Collect queryCollectById(Integer id) {
        String sql="select collect_id,author,user_id,header from t_collect" +
                " where user_id = ?";
        return queryForOne(Collect.class,sql,id);
    }

    @Override
    public List<Collect> queryCollect() {
        String sql="select collect_id,author,user_id,header from t_collect";
        return queryForList(Collect.class,sql);
    }

    @Override
    public List<Collect> getContentByCollectId(Integer id) {
        String sql="select collect_id,author,user_id,header from t_collect where collect_id = "+id;
        return queryForList(Collect.class,sql,id);
    }

    @Override
    public List<Collect> queryCollectsByUser(Integer author) {
        String sql="select collect_id,author,user_id,header from t_collect" +
                " where user_id = ?";
        return queryForList(Collect.class,sql,author);
    }

    @Override
    public List<Collect> queryCollectByItem(String author, String header, Integer id) {
        return null;
    }

    @Override
    public void save(List<Collect> collects) {

    }

    @Override
    public Collect queryCollectById(String id) {
        String sql="select collect_id,author,user_id,header" +
                "from t_collect where collect_id = ?";
        return queryForOne(Collect.class,sql,id);
    }

    @Override
    public Collect queryArticalsByUserId(Integer id) {
        String sql="select collect_id,author,user_id,header from t_collect" +
                " where user_id = ?";
        return queryForOne(Collect.class,sql,id);
    }
}
