package com.quintus.ioc2;

public class UserService2 {
    private UserDao userDao;

    public UserService2(UserDao userDao) {
        this.userDao = userDao;
    }

    private int age;
    private String name;

    public UserService2(int age, String name, UserDao userDao){
        this.userDao = userDao;
        this.age = age;
        this.name = name;
    }
}
