# 📝 프로젝트 소개

이 문서는 본 가계부 API 프로젝트의 개요와 목적, 그리고 기술적 방향성을 간략히 설명합니다.

---

## ✅ 프로젝트 목적

- 백엔드 API 개발 역량 강화를 위해 개인 사이드 프로젝트로 진행
- 프론트엔드 없이 Postman, Swagger 등으로 결과 확인 및 문서화
- 실무에서 사용하는 구조(Domain Layer, Application Layer 등)를 학습하며 DDD 기반으로 설계
- 테스트 코드 작성과 TDD 흐름을 연습해보기 위한 목적 포함

---

## 🧱 주요 기술 스택

- Java 17
- Spring Boot 3.4.4
- Gradle
- MySQL
- Spring Data JPA
- JWT (인증)
- Spring Security

---

## 🔍 핵심 기능

- 회원가입 / 로그인 (JWT 발급)
- 카테고리 등록 / 조회
- 수입/지출 등록 / 삭제
- 월별 통계, 카테고리별 통계, 잔액 추이 등 다양한 통계 API 제공

---

## 🔧 향후 개선 및 확장 고려 사항

- 사용자 정보 조회 / 수정 / 탈퇴 기능은 **단순 CRUD**로 판단되어 **후순위 개선 항목**으로 추후 기능 추가 예정
- 소셜 로그인 (Google, Kakao, Naver 등) 기능은 기본 로그인 구현 후 확장 형태로 고려
- Swagger, Spring REST Docs 등으로 문서 자동화 예정

---

본 프로젝트는 학습 및 이직 포트폴리오용으로 제작되었으며, 실제 서비스 배포 목적은 아닙니다.