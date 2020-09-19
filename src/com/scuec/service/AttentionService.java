package com.scuec.service;

import com.scuec.pojo.Attention;

import java.util.List;

/**
 * @author anonymity-0
 * @date 2020/9/3 - 11:34
 */
public interface AttentionService {
    public int addAttention(Attention attention);
    public int deleteByid(Integer id);
    public int updateAttention(Attention attention);
    public Attention queryAttentionByid(Integer id);
    public List<Attention> queryAttention();
    public List<Attention> getAttentionByUsertId(Integer id);
    public Attention queryAttentionByUsername(String username);
    public int deleteByName(String username);
}
