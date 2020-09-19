package com.scuec.dao;

import com.scuec.pojo.Attention;

import java.util.List;

public interface AttentionDao {
    public int addAttention(Attention attention);
    public int deleteByid(Integer id);
    public int updateAttention(Attention attention);
    public Attention queryAttentionByid(Integer id);
    public List<Attention> queryAttention();
    public List<Attention> getAttentionByUsertId(Integer id);
    public Attention queryAttentionByUsername(String username);
    public int deleteByName(String username);
}
