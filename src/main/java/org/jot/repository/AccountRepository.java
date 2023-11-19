package org.jot.repository;

import static java.util.concurrent.ThreadLocalRandom.current;

import org.jot.domain.Account;
import org.jot.domain.EmailAddress;
import org.jot.domain.PhoneNumber;
import org.springframework.stereotype.Repository;

/**
 * Mock implementation for the account repository
 */
@Repository
public class AccountRepository {

    public Account getAccountByCustomerId(Long customerId) {
        Account account = new Account();
        account.setAccountId(current().nextLong(100000));
        account.setCustomerId(customerId);
        account.setEmailAddress(new EmailAddress());
        account.setPhoneNumber(new PhoneNumber());
        return account;
    }

    public Account postAccount(Account account){
        account.setAccountId(current().nextLong(100000));
        return account;
    }
}
