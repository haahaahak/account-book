# 📘 API 명세서

이 문서는 가계부 API 프로젝트의 엔드포인트와 요청/응답 스펙을 정의합니다.

---

## ✅ 인증 (Auth)

### 🔹 회원가입
- **URL**: `POST /api/auth/signup`
- **요청**:
```json
{
  "email": "blog0810@gmail.com",
  "password": "password1234",
  "nickname": "정현학"
}
```
- **응답**: `201 Created`
```json
{
  "id": 1,
  "email": "blog0810@gmail.com",
  "nickname": "정현학"
}
```

### 🔹 로그인
- **URL**: `POST /api/auth/login`
- **요청**:
```json
{
  "email": "blog0810@gmail.com",
  "password": "password1234"
}
```
- **응답**: `200 OK`
```json
{
  "accessToken": "jwt-token-string"
}
```

---

## ✅ 카테고리 (Category)

### 🔹 카테고리 등록
- **URL**: `POST /api/categories`
- **요청**:
```json
{
  "name": "식비",
  "type": "EXPENSE"
}
```
- **응답**: `201 Created`

### 🔹 카테고리 목록 조회
- **URL**: `GET /api/categories`
- **응답**:
```json
[
  { "id": 1, "name": "식비", "type": "EXPENSE" },
  { "id": 2, "name": "월급", "type": "INCOME" }
]
```

---

## ✅ 내역 (Ledger)

### 🔹 수입/지출 내역 등록
- **URL**: `POST /api/ledgers`
- **요청**:
```json
{
  "categoryId": 1,
  "amount": 50000,
  "transactionDate": "2025-03-26",
  "memo": "점심 식사"
}
```
- **응답**: `201 Created`

### 🔹 내역 목록 조회
- **URL**: `GET /api/ledgers?year=2025&month=03`
- **응답**:
```json
[
  {
    "id": 1,
    "category": "식비",
    "type": "EXPENSE",
    "amount": 50000,
    "transactionDate": "2025-03-26",
    "memo": "점심 식사"
  }
]
```

---

## ✅ 통계 (Statistics)

### 🔹 월별 수입/지출 합계
- **URL**: `GET /api/statistics/monthly?year=2025&month=03`
- **응답**:
```json
{
  "totalIncome": 1500000,
  "totalExpense": 980000
}
```

### 🔹 카테고리별 통계
- **URL**: `GET /api/statistics/category?year=2025&month=03`
- **응답**:
```json
[
  { "category": "식비", "amount": 350000 },
  { "category": "교통", "amount": 120000 }
]
```

### 🔹 최근 7일 통계
- **URL**: `GET /api/statistics/weekly`
- **응답**:
```json
[
  { "date": "2025-03-20", "income": 0, "expense": 25000 },
  { "date": "2025-03-21", "income": 50000, "expense": 12000 }
]
```

### 🔹 잔액 추이
- **URL**: `GET /api/statistics/balance`
- **응답**:
```json
[
  { "date": "2025-03-01", "balance": 1000000 },
  { "date": "2025-03-02", "balance": 980000 }
]
```

---

이 문서는 `/docs/api/API.md`에 위치하며, 개발자와 협업 시 API의 기준이 되는 명세서입니다.

