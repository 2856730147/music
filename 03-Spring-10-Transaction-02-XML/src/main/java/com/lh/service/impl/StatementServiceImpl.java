package com.lh.service.impl;

import com.lh.dao.AccountDao;
import com.lh.service.AccountService;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class StatementServiceImpl implements AccountService {
    private AccountDao accountDao;


    @Override
    public void transfer(Integer from, Integer to, Long money) {

        accountDao.decreaseMoney(from, money);
//        int num = 1 / 0;
        accountDao.increaseMoney(to, money);

    }


    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

}
