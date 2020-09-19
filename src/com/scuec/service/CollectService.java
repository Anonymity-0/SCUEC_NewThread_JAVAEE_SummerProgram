package com.scuec.service;

import com.scuec.pojo.Collect;

import java.util.List;

public interface CollectService {
    public String createOrder(Collect collect,Integer userId);
    public int addCollect(Collect collect);
    public int deleteByid(String id);
    public int updateCollect(Collect collect);
    public Collect queryCollectById(Integer id);
    public List<Collect> queryCollect();
    public List<Collect> getContentById(Integer id);
    public List<Collect> queryArticalsByUser(String author);
    public List<Collect> queryArticalsByItem(String author,String header,Integer id);
    public void save(List<Collect> collects);
    public Collect queryCollectById(String id);
}
