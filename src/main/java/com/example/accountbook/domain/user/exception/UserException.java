package com.example.accountbook.domain.user.exception;

import com.example.accountbook.global.error.BaseException;

public class UserException extends BaseException {

    private final UserErrorCode errorCode;

    public UserException(UserErrorCode errorCode) {
        super(errorCode);
        this.errorCode = errorCode;
    }

    @Override
    public UserErrorCode getErrorCode() {
        return errorCode;
    }
}
