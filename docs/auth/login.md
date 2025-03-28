# 🔐 로그인 - 플로우차트 및 시퀀스 다이어그램

이 문서는 사용자의 로그인 처리 로직을 시각적으로 이해하고, 책임 분리를 설계하기 위해 작성되었습니다.

---

## ✅ 로그인 플로우차트

```
[로그인 요청 (email, password)]
     ↓
[이메일로 사용자 조회]
     ↓
[사용자 존재 여부 확인]
 ┌──────────────┐
 │   없음 → 404 응답 │
 └──────────────┘
     ↓
[입력한 비밀번호와 저장된 비밀번호 비교]
     ↓
[일치 여부 확인]
 ┌──────────────┐
 │ 불일치 → 401 응답 │
 └──────────────┘
     ↓
[JWT 토큰 생성]
     ↓
[AccessToken 응답 반환 (200 OK)]
```

---

## ✅ 시퀀스 다이어그램

![login-sequence](http://www.plantuml.com/plantuml/proxy?src=https://raw.githubusercontent.com/haahaahak/account-book/main/docs/auth/login-sequence.puml)

---

## 💡 비고

- 비밀번호는 `BCryptPasswordEncoder.matches()`를 사용하여 암호화된 값과 비교합니다.
- JWT는 사용자 식별 정보 (ex. userId)를 포함하여 생성되며, 현재는 AccessToken만 발급합니다.
- 실패 시 적절한 예외 메시지와 함께 HTTP 상태코드를 반환합니다.
- 로그인 성공 시, 사용자 정보는 포함하지 않고 AccessToken만 응답합니다.