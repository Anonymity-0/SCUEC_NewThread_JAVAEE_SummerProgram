package com.scuec.service.impl;

import com.scuec.dao.AttentionDao;
import com.scuec.dao.impl.AttentionDaoImpl;
import com.scuec.pojo.Attention;
import com.scuec.service.AttentionService;

import java.util.List;

/**
 * @author anonymity-0
 * @date 2020/9/3 - 11:34
 */
public class AttentionServiceImpl implements AttentionService {
    AttentionDao attentionDao =new AttentionDaoImpl();
    @Override
    public int addAttention(Attention attention) {
        return attentionDao.addAttention(attention);
    }

    @Override
    public int deleteByid(Integer id) {
        return attentionDao.deleteByid(id);
    }

    @Override
    public int updateAttention(Attention attention) {
        return 0;
    }

    @Override
    public Attention queryAttentionByid(Integer id) {
        return attentionDao.queryAttentionByid(id);
    }

    @Override
    public List<Attention> queryAttention() {
        return attentionDao.queryAttention();
    }

    @Override
    public List<Attention> getAttentionByUsertId(Integer id) {
        return attentionDao.getAttentionByUsertId(id);
    }

    @Override
    public Attention queryAttentionByUsername(String username) {
        return attentionDao.queryAttentionByUsername(username);
    }

    @Override
    public int deleteByName(String username) {
        return attentionDao.deleteByName(username);
    }
}
