# 🧾 수입/지출(Ledger) 삭제 - 플로우차트 및 시퀀스 다이어그램

이 문서는 사용자의 수입/지출(ledger) 삭제 기능에 대한 흐름과 책임을 시각화하여 정리한 문서입니다.

---

## ✅ 플로우차트

```
[사용자 요청]
   ↓
[지출 삭제 API 호출]
   ↓
[Access Token 인증 완료됨]
   ↓
[Ledger ID로 내역 조회]
   ↓
[사용자 소유 확인]
   ↓
[Soft Delete 처리 (is_deleted = true)]
   ↓
[응답 반환 (삭제 완료)]
```

- 삭제는 실제 데이터를 제거하지 않고, `is_deleted` 플래그를 통한 **소프트 삭제 방식**으로 처리합니다.
- 요청자가 해당 Ledger의 소유자인지를 반드시 확인해야 합니다.

---

## ✅ 시퀀스 다이어그램

![ledger_delete-sequence](http://www.plantuml.com/plantuml/proxy?src=https://raw.githubusercontent.com/haahaahak/account-book/main/docs/ledger/ledger_delete-sequence.puml)

---

## 💡 비고

- 이 다이어그램은 주요 내부 호출 관계와 예외 흐름을 보여주기 위함입니다.
- 인증 실패 등의 공통 예외는 본 문서의 범위에서 제외하고, 별도의 인증 흐름 설계에 포함시킬 수 있습니다.
- 삭제 시 실제 데이터는 제거하지 않고 `soft delete` 처리됩니다.

---

## 🗃️ Ledger 테이블 컬럼 추가

- `is_deleted`: BOOLEAN (기본값 false)
    - true일 경우 해당 Ledger는 삭제된 것으로 간주
    - 조회 시 반드시 이 조건을 고려하여 필터링

> 위 컬럼은 [ERD 및 테이블 구조 문서](../ERD.md)에도 반영 필요

