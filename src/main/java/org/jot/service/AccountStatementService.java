package org.jot.service;

import org.jot.domain.AccountStatement;
import org.jot.repository.AccountStatementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountStatementService {

    @Autowired
    private AccountStatementRepository accountStatementRepository;

    public AccountStatement getAccountStatementById(Long accountStatementId){
        return accountStatementRepository.getAccountStatementById(accountStatementId);
    }

    public List<AccountStatement> getAccountStatementByAccountId(Long accountId){
        return accountStatementRepository.getAccountStatementByAccountId(accountId);
    }

    public AccountStatement postAccountStatement(AccountStatement accountStatement){
        return accountStatementRepository.postAccountStatement(accountStatement);
    }
}
