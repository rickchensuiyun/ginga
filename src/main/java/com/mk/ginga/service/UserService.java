package com.mk.ginga.service;

public interface UserService {

    /**
     * 注册用户
     * @param account
     * @param password
     * @return
     */
    public int addUser(String account,String password);
}
