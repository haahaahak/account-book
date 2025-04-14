package com.example.accountbook.application.auth.dto;

public record SignUpResult(
        Long id,
        String email,
        String nickname
) {}
