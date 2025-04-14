package com.example.accountbook.api.auth.controller;

import com.example.accountbook.api.auth.request.SignUpRequest;
import com.example.accountbook.api.auth.response.SignUpResponse;
import com.example.accountbook.application.auth.dto.SignUpResult;
import com.example.accountbook.application.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public SignUpResponse signUp(@RequestBody SignUpRequest request) {
        SignUpResult result = authService.signUp(request.toCommand());
        return new SignUpResponse(result.id(), result.email(), result.nickname());
    }
}
