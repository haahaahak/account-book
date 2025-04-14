package com.example.accountbook.application.auth.dto;

public record SignUpCommand(
        String email,
        String password,
        String nickname
) {}
