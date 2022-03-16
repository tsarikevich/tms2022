package com.tms.task6;

import lombok.Getter;


@Getter
public class EmailAddress {
    private String email;
    private String additionalInfo;

    public EmailAddress(String email) {
        this.email = email;
    }

    public EmailAddress(String email, String additionalInfo) {
        this.email = email;
        this.additionalInfo = additionalInfo;
    }
}
