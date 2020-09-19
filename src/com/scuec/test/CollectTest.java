package com.scuec.test;

import com.scuec.dao.CollectDao;
import com.scuec.dao.impl.CollectDaoImpl;
import com.scuec.service.CollectService;
import com.scuec.service.impl.CollectServiceImpl;
import org.junit.Test;

public class CollectTest {

    @Test
    public void addItem() {
         CollectService collectService =new CollectServiceImpl();
        System.out.println(collectService.queryCollectById(11));
    }

    @Test
    public void delete() {
        CollectDao collectDao =new CollectDaoImpl();
        System.out.println(collectDao.queryCollect());

    }


}