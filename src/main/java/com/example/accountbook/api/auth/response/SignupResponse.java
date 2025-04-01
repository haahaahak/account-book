package com.example.accountbook.api.auth.response;

public record SignupResponse(
        Long id,
        String email,
        String nickname
) {}
