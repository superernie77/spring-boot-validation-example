package org.jot.service;

import org.jot.domain.Account;
import org.jot.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account getAccountByCustomerId(Long customerId){
        return accountRepository.getAccountByCustomerId(customerId);
    }

    public Account postAccount(Account account){
        return accountRepository.postAccount(account);
    }
}
