package org.jot.repository;

import static java.util.concurrent.ThreadLocalRandom.current;

import org.jot.domain.AccountStatement;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountStatementRepository {

    public AccountStatement getAccountStatementById(Long accountStatementId){
        AccountStatement accountStatement = new AccountStatement();
        accountStatement.setAccountStatementId(accountStatementId);
        accountStatement.setStatement(new byte[100]);
        return accountStatement;
    }

    public List<AccountStatement> getAccountStatementByAccountId(Long accountId){
        return List.of(getAccountStatementById(1l), getAccountStatementById(2l));
    }

    public AccountStatement postAccountStatement(AccountStatement accountStatement){
        accountStatement.setAccountStatementId(current().nextLong(100000));
        return accountStatement;
    }
}
