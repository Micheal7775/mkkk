package com.example.online.banking.system.Exception;

public class AccountIdNotFound extends Exception{
    public AccountIdNotFound() {
        super();
    }

    public AccountIdNotFound(String message) {
        super(message);
    }

    public AccountIdNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountIdNotFound(Throwable cause) {
        super(cause);
    }

    protected AccountIdNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
