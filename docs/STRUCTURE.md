# 🏗 프로젝트 구조 및 설계 개요

이 문서는 본 프로젝트의 전체 아키텍처와 디렉토리 구조, 각 계층의 책임과 설계 의도를 설명합니다.

---

## 📂 디렉토리 구조

```
src/main/java/com/example/accountbook
├── api/              # 외부 요청을 받는 계층 (Controller, Request/Response DTO)
│   ├── user/
│   ├── category/
│   └── ledger/
│
├── application/      # 유스케이스(서비스) 계층 - 도메인 로직 호출 및 흐름 제어
│   ├── user/
│   ├── category/
│   └── ledger/
│
├── domain/           # 핵심 비즈니스 모델 (Entity, Repository Interface, VO 등)
│   ├── user/
│   ├── category/
│   └── ledger/
│
└── infra/   # 실제 구현체 (JPA, 외부 연동 등)
    └── persistence/
        ├── user/
        ├── category/
        └── ledger/
```

---

## 🧱 계층별 책임

### 🔹 `api`
- 외부 요청을 받는 Controller 계층
- Request → DTO로 받고, Response → DTO로 반환
- 비즈니스 흐름 자체는 처리하지 않고, application 계층으로 위임

### 🔹 `application`
- 유스케이스 중심의 서비스 계층
- 트랜잭션 단위의 흐름 관리
- 도메인 모델을 호출하고 결과를 리턴
- 비즈니스 규칙은 되도록 도메인에 위임

### 🔹 `domain`
- 프로젝트의 핵심 모델 (Entity, ValueObject, Enum 등)
- 도메인 규칙, 제약조건, 연관 로직을 포함
- 기술 의존 없이 순수 Java 객체로 구성
- Repository 인터페이스 정의

### 🔹 `infra`
- JPA 등 기술적인 구현을 담당
- 도메인의 Repository를 실제로 구현
- 외부 API, 파일 시스템, DB 등 기술 세부사항 포함

---

## 🎯 설계 의도 및 기준

- **DDD 패턴 기반 설계**: 도메인 중심으로 계층을 분리하여 유지보수성과 유연성 확보
- **TDD 학습 목표 반영**: 각 계층이 분리되어 있어 테스트 단위가 명확함
- **책임에 따라 나눈 구조**: 관심사 분리(SOC) 원칙에 따라 각 계층은 자신이 맡은 역할에 집중
- **확장 용이성 고려**: 새로운 도메인이나 기능이 생겨도 구조 변경 없이 확장 가능

---

> 이 문서는 `/docs/STRUCTURE.md`에 위치하며, 프로젝트 구조 설계의 기준으로 사용됩니다.

