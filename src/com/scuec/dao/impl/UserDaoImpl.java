package com.scuec.dao.impl;

import com.scuec.dao.UserDao;
import com.scuec.pojo.User;

import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(String username) {
        String sql = "select `id`,`username`,`password` from user where username = ?";
        return queryForOne(User.class, sql, username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select `id`,`username`,`password` from user where username = ? and password = ?";
        return queryForOne(User.class, sql, username,password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into user(`username`,`password`) values(?,?)";
        return update(sql, user.getUsername(),user.getPassword());
    }

    @Override
    public List<User> queryUsers() {
        String sql="select id,username,password from user";
        return queryForList(User.class,sql);
    }
    @Override
    public List<User> queryUsersByUsernameAndId(Integer id,String username) {
        String sql="select *from user where username like '%"+username+"%'";
        if(id!=0)
        sql="select *from user where username like '%"+username+"%' and "+"id like '%"+id+"%'";
        return queryForList(User.class,sql);
    }

    @Override
    public int deleteByid(String id) {
        String sql = "delete from user where id = ?";
        return update(sql,id);
    }

    @Override
    public int updateUser(User user) {
        String sql = "update user set username=?,password=? where id =?";
        return update(sql,user.getUsername(),user.getPassword(),user.getId());
    }

    @Override
    public int deleteByid(Integer id) {
        String sql = "delete from user where id = ?";
        return update(sql,id);
    }

    @Override
    public User queryUserById(Integer id) {
        String sql="select id,username,password from user where id = ?";
        return queryForOne(User.class,sql,id);
    }

}
