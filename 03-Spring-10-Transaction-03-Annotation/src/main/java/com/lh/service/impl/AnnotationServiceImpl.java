package com.lh.service.impl;

import com.lh.dao.AccountDao;
import com.lh.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class AnnotationServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;


    @Override
    public void transfer(Integer from, Integer to, Long money) {

        accountDao.decreaseMoney(from, money);
        accountDao.increaseMoney(to, money);

    }

}
