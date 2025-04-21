package com.example.accountbook.application.auth.service;

import com.example.accountbook.api.auth.request.SignUpRequest;
import com.example.accountbook.application.auth.dto.SignUpCommand;
import com.example.accountbook.application.auth.dto.SignUpResult;
import com.example.accountbook.domain.user.entity.User;
import com.example.accountbook.domain.user.exception.UserException;
import com.example.accountbook.domain.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.*;

public class AuthServiceTest {

    private UserRepository userRepository;
    private AuthService authService;

    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);
        authService = new AuthService(userRepository, new BCryptPasswordEncoder());
    }

    @Test
    @DisplayName("회원가입 성공")
    void signUpSuccess() {
        // given
        SignUpRequest request = new SignUpRequest("test@email.com", "1234", "테스트");
        SignUpCommand command = request.toCommand();

        given(userRepository.existsByEmail(command.email())).willReturn(false);
        given(userRepository.save(any(User.class)))
                .willAnswer(invocation -> invocation.getArgument(0));

        // when
        SignUpResult result = authService.signUp(command);

        // then
        assertThat(result).isNotNull();
        assertThat(result.email()).isEqualTo(command.email());
        assertThat(result.nickname()).isEqualTo(command.nickname());
    }

    @Test
    @DisplayName("회원가입 실패_이메일 중복")
    void signUpFail_duplicateEmail() {
        // given
        SignUpRequest request = new SignUpRequest("test@email.com", "1234", "테스트");
        SignUpCommand command = request.toCommand();

        given(userRepository.existsByEmail(command.email())).willReturn(true);

        // when & then
        assertThrows(UserException.class, () -> authService.signUp(command));
    }
}