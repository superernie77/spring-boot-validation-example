package org.jot.domain;

import jakarta.validation.constraints.NotNull;

public class Account {

    private Long accountId;

    private Long customerId;

    @NotNull( message = "phone number cannot be null")
    private PhoneNumber phoneNumber;

    @NotNull( message = "email cannot be null")
    private EmailAddress emailAddress;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public EmailAddress getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(EmailAddress emailAddress) {
        this.emailAddress = emailAddress;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
