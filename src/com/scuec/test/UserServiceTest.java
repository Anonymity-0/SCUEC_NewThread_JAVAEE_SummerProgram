package com.scuec.test;

import com.scuec.pojo.User;
import com.scuec.service.UserService;
import com.scuec.service.impl.UserServiceImpl;
import org.junit.Test;

public class UserServiceTest {

    UserService userService = new UserServiceImpl();

    @Test
    public void registUser() {
        userService.registUser(new User(null, "bbj168", "666666"));
        userService.registUser(new User(null, "abc168", "666666"));
    }

    @Test
    public void login() {
        System.out.println( userService.login(new User(null, "lkz886", "123456")) );
    }

    @Test
    public void existsUsername() {
        if (userService.existsUsername("wzg16888")) {
            System.out.println("用户名已存在！");
        } else {
            System.out.println("用户名可用！");
        }
    }
}