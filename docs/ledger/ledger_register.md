# 🧾 수입/지출(Ledger) 등록 - 플로우차트 및 시퀀스 다이어그램

이 문서는 사용자의 수입/지출(ledger) 등록 기능에 대한 흐름과 책임을 시각화하여 정리한 문서입니다.

---

## ✅ 플로우차트

```
[사용자 요청]
   ↓
[지출 등록 API 호출]
   ↓
[Access Token 인증 완료됨]
   ↓
[사용자 유효성 검증]
   ↓
[카테고리 존재 확인]
   ↓
[Ledger 도메인 생성 및 저장]
   ↓
[응답 반환 (Ledger ID)]
```

- 프론트엔드에서는 사용자의 입력값에 대해 1차 유효성 검사를 진행하나, 백엔드에서는 반드시 **도메인 무결성과 신뢰 경계를 위해 재검증**을 수행함.

---

## ✅ 시퀀스 다이어그램

다음 시퀀스 다이어그램은 예외 상황까지 고려하여 설계되었습니다.
![ledger_register-sequence](http://www.plantuml.com/plantuml/proxy?src=https://raw.githubusercontent.com/haahaahak/account-book/main/docs/ledger/ledger_register-sequence.puml)
---

## 💡 비고

- 이 다이어그램은 주요 내부 호출 관계와 예외 흐름을 보여주기 위함입니다.
- 인증 실패 등의 공통 예외는 본 문서의 범위에서 제외하고, 별도의 인증 흐름 설계에 포함시킬 수 있습니다.

