package com.example.ss10.service;

import com.example.ss10.model.Account;
import com.example.ss10.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImp implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public boolean createAccount(Account account) {
        return accountRepository.createAccount(account);
    }
}
