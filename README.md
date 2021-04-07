# MSA-Gang
멀티모듈이 아닌 MSA구조를 설계해보기위해 구성되어 있습니다.

## 구성
### User :

회원 가입, 회원 유무 확인

- 주요기능 : 회원 정보 관리
    
- SpringBoot 2.4, Java11, JPA(Hibernate), REST API

### Order :
주문 접수, 조회 주문 메세지 Queue 발행

- 주요기능 : 커피 주문 및 주문 내역 전송

- SpringBoot 2.4, Java11, JPA(Hibernate), 카프카 메시지 발행, REST API
  
### OrderProcess :
주문 내력 알림

- 주요기능 : 주문 내역 수신 저장 및 주문 상태 확인 조회

- SpringBoot 2.4, Java11, JPA(Hibernate), 카프카 메시지 구독, REST API

### TODO 
- (Front) View :
(안만들 수도 있음)
화면 구성

주요기능 : 화면 구성, View

 Thymeleaf,..

- MSA 스럽게 Node.js 서버 하나....



## About DataBase 

- Test DataBase : H2 DataBase version : 1.4.200

jdbc:h2:tcp://localhost/{프로젝트 경로}/MSA/DataBase/coffee

- 실행 데이터 베이스 : MySql

./DataBase 파일경로에서 DDL -> DML 순서로 파일 돌려주세요.

### ERD
<img src="Diagram/ERD-Diagram.png" alt="erd 다이어그램">

## 사용 개발 방법론
- TDD (Test Driven Development) : JUnit5 사용

1. GREEN : 최소한의 코딩(기능 구현 우선), 테스트 통과
2. REFACTOR : 구현 설계 계선, GREEN TEST 통과 유지
3. RED : 실패하는 테스트 추가

- DDD (Domain Driven Development) : 도메인 주도 개발

## Commit message Convention
```
Allowed <type>
feat (feature)
fix (bug fix)
docs (documentation)
style (formatting, missing semi colons, …)
refactor
test (when adding missing tests)
chore (maintain)
```

