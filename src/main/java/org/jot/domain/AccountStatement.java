package org.jot.domain;

public class AccountStatement {

    private Long accountId;

    private Long accountStatementId;

    private Long customerId;

    private byte[] statement;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccountStatementId() {
        return accountStatementId;
    }

    public void setAccountStatementId(Long accountStatementId) {
        this.accountStatementId = accountStatementId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public byte[] getStatement() {
        return statement;
    }

    public void setStatement(byte[] statement) {
        this.statement = statement;
    }
}
