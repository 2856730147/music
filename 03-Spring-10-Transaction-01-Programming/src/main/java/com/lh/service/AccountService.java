package com.lh.service;

public interface AccountService {
    //转帐
    void transfer(Integer from,Integer to,Long money);
}
