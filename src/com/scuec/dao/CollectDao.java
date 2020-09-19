package com.scuec.dao;

import com.scuec.pojo.Collect;

import java.util.List;

public interface CollectDao {
    public int addCollect(Collect collect);
    public int deleteByid(String id);
    public int updateCollect(Collect collect);
    public Collect queryCollectById(Integer id);
    public List<Collect> queryCollect();
    public List<Collect> getContentByCollectId(Integer id);
    public List<Collect> queryCollectsByUser(Integer author);
    public List<Collect> queryCollectByItem(String author, String header, Integer id);
    public void save(List<Collect> collects);
    public Collect queryCollectById(String id);
    Collect queryArticalsByUserId(Integer id);
}
