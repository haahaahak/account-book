package com.example.accountbook.application.auth.service;

import com.example.accountbook.application.auth.dto.SignUpCommand;
import com.example.accountbook.application.auth.dto.SignUpResult;
import com.example.accountbook.domain.user.entity.User;
import com.example.accountbook.domain.user.exception.UserErrorCode;
import com.example.accountbook.domain.user.exception.UserException;
import com.example.accountbook.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public SignUpResult signUp(SignUpCommand command) {
        if (userRepository.existsByEmail(command.email())) {
            throw new UserException(UserErrorCode.DUPLICATED_EMAIL);
        }

        String encodedPassword = passwordEncoder.encode(command.password());

        User user = new User(command.email(), encodedPassword, command.nickname());
        User saved = userRepository.save(user);

        return new SignUpResult(saved.getId(), saved.getEmail(), saved.getNickname());
    }
}
