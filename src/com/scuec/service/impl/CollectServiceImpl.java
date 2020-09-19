package com.scuec.service.impl;

import com.scuec.dao.CollectDao;
import com.scuec.dao.impl.CollectDaoImpl;
import com.scuec.pojo.Collect;
import com.scuec.service.CollectService;

import java.util.List;

/**
 * @author anonymity-0
 * @date 2020/9/2 - 21:25
 */
public class CollectServiceImpl implements CollectService {
    CollectDao collectDao= new CollectDaoImpl();
    @Override
    public String createOrder(Collect collect, Integer userId) {
        return null;
    }

    @Override
    public int addCollect(Collect collect) {
       return collectDao.addCollect(collect);
    }

    @Override
    public int deleteByid(String id) {
        return collectDao.deleteByid(id);
    }

    @Override
    public int updateCollect(Collect collect) {
        return 0;
    }

    @Override
    public Collect queryCollectById(Integer id) {
        return collectDao.queryCollectById(id);
    }

    @Override
    public List<Collect> queryCollect() {
        return collectDao.queryCollect();
    }

    @Override
    public List<Collect> getContentById(Integer id){
        List<Collect> collects= collectDao.queryCollectsByUser(id);
        System.out.println(collects);
        return collects;
    }

    @Override
    public List<Collect> queryArticalsByUser(String author) {
        return collectDao.queryCollectsByUser(Integer.valueOf(author));
    }

    @Override
    public List<Collect> queryArticalsByItem(String author, String header, Integer id) {
        return null;
    }

    @Override
    public void save(List<Collect> collects) {

    }

    @Override
    public Collect queryCollectById(String id) {
        return null;
    }
}
