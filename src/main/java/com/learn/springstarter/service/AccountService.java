package com.learn.springstarter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.springstarter.models.Account;
import com.learn.springstarter.repositories.AccountRepository;

@Service
public class AccountService  {
    @Autowired
    private AccountRepository accountRepository;

    public Account save(Account account){
        return accountRepository.save(account);
    }

}
