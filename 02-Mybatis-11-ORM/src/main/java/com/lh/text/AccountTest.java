package com.lh.text;


import com.lh.dao.AccountDao;
import com.lh.entity.Account;
import com.lh.utils.MyBatisUtils;
import org.junit.Test;

import java.util.List;

public class AccountTest {
@Test
    public void fidAll(){
    AccountDao mapper = MyBatisUtils.getMapper(AccountDao.class);
    List<Account> accounts = mapper.fidAll();
    for (Account account : accounts) {
        System.out.println(account);
    }
    MyBatisUtils.commit();
}
}
