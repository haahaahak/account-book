package com.example.accountbook.api.auth.response;

public record SignUpResponse(
        Long id,
        String email,
        String nickname
) {}
