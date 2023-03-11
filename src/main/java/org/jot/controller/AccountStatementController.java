package org.jot.controller;

import org.jot.domain.AccountStatement;
import org.jot.service.AccountStatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/accountstatements")
public class AccountStatementController {

    @Autowired
    private AccountStatementService accountStatementService;

    @GetMapping(path = "/document/{accountStatementId}")
    public AccountStatement getAccountStatementById(Long accountStatementId){
        return accountStatementService.getAccountStatementById(accountStatementId);
    }

    @GetMapping(path = "/{accountId}")
    public List<AccountStatement> getAccountStatementByAccountId(Long accountId){
        return accountStatementService.getAccountStatementByAccountId(accountId);
    }

    @PostMapping
    public AccountStatement postAccountStatement(AccountStatement accountStatement){
        return accountStatementService.postAccountStatement(accountStatement);
    }
}
