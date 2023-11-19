package org.jot.domain;

public class AccountStatement {

	/**
	 * Number of the account this statement belongs to
	 */
    private Long accountId;

    /**
     * ID of the account statement
     */
    private Long accountStatementId;

    /**
     * Id of the customer
     */
    private Long customerId;

    /**
     * Statement document as byte array.
     */
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
