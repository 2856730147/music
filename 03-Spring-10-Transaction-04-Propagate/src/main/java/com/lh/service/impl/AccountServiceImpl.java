package com.lh.service.impl;

import com.lh.dao.AccountDao;
import com.lh.service.AccountService;
import com.lh.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Autowired
    private LocationService locationService;
    @Override
    public void addAccount(String name,String  location) {
        accountDao.addAccount(name);

        locationService.addLication(location);
    }
}
