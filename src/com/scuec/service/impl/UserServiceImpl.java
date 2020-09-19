package com.scuec.service.impl;

import com.scuec.dao.UserDao;
import com.scuec.dao.impl.UserDaoImpl;
import com.scuec.pojo.User;
import com.scuec.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {

        if (userDao.queryUserByUsername(username) == null) {
           // 等于null,说明没查到，没查到表示可用
           return false;
        }

        return true;

    }

    @Override
    public List<User> queryusers() {
        return userDao.queryUsers();
    }

    @Override
    public void deleteUserById(Integer id) {
        userDao.deleteByid(id);
    }


    @Override
    public int updateUser(User user) {
        return  userDao.updateUser(user);
    }

    @Override
    public User queryUserById(Integer id) {
        return userDao.queryUserById(id);
    }

    @Override
    public User queryUserByUsername(String username) {
        return userDao.queryUserByUsername(username);
    }

    @Override
    public List<User> queryUsersByUsernameAndId(Integer id,String username) {
        return userDao.queryUsersByUsernameAndId(id,username);
    }

}
