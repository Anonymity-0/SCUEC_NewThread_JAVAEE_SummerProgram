package com.scuec.dao.impl;

import com.scuec.dao.AttentionDao;
import com.scuec.pojo.Attention;

import java.util.List;

/**
 * @author anonymity-0
 * @date 2020/9/3 - 11:23
 */
public class AttentionDaoImpl extends BaseDao implements AttentionDao {
    @Override
    public int addAttention(Attention attention) {
        if(queryAttentionByUsername(attention.getUsername())==null){
            String sql = "REPLACE INTO t_attention(id,username,userid"
                    + ") VALUES (?,?,?) ";
            return update(sql,attention.getId(),attention.getUsername(),attention.getUserid());
        }
        else {
            deleteByName(attention.getUsername());
            return 0;
        }
    }

    public int deleteByName(String username) {
        String sql = "delete from t_attention where username = ?";
        return update(sql,username);
    }

    @Override
    public int deleteByid(Integer id) {
        String sql = "delete from t_attention where userid = ?";
        return update(sql,id);
    }

    @Override
    public int updateAttention(Attention attention) {
        return 0;
    }

    @Override
    public Attention queryAttentionByid(Integer id) {
    String sql="select id,username,userid from t_attention" +
                " where id = ?";
        return queryForOne(Attention.class,sql,id);
    }

    @Override
    public List<Attention> queryAttention() {
        String sql="select id,username,userid from t_attention";
        return queryForList(Attention.class,sql);
    }

    @Override
    public List<Attention> getAttentionByUsertId(Integer id) {
        String sql="select id,username,userid from t_attention where userid = ?";
        return queryForList(Attention.class,sql,id);
    }

    @Override
    public Attention queryAttentionByUsername(String username) {
        String sql="select id,username,userid" +
                " from t_attention where username = ?";
        return queryForOne(Attention.class,sql,username);
    }
}
