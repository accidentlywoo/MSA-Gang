# MSA-Gang
멀티모듈이 아닌 MSA구조를 설계해보기위해 구성되어 있습니다.

## 구성
### User :

회원 가입, 회원 유무 확인

- 주요기능 : 회원 정보 관리
    
- 
![JAVA ](https://img.shields.io/badge/JAVA_JDK-1.11-007396?Style=flat&logo=Java&logoColor=007396)
![SpringBoot](https://img.shields.io/badge/SpringBoot-2.4.3-6DB33F?Style=flat&logo=Spring&logoColor=6DB33F)
![spring-jpa](https://img.shields.io/badge/Spring_jpa-2.4.5-6DB33F?Style=flat&logo=Spring&logoColor=85EA2D)
![spring-validation](https://img.shields.io/badge/Spring_validation-2.4.3-6DB33F?Style=flat&logo=Spring&logoColor=85EA2D)
![Lombok](https://img.shields.io/badge/Lombok-1.18.18-BC4521?Style=flat)
![Gradle](https://img.shields.io/badge/gradle-gradle6.8.3-yellow?Style=flat)

### Order :
주문 접수, 조회 주문 메세지 Queue 발행

- 주요기능 : 커피 주문 및 주문 내역 전송

- 
![JAVA ](https://img.shields.io/badge/JAVA_JDK-1.11-007396?Style=flat&logo=Java&logoColor=007396)
![SpringBoot](https://img.shields.io/badge/SpringBoot-2.4.3-6DB33F?Style=flat&logo=Spring&logoColor=6DB33F)
![spring-jpa](https://img.shields.io/badge/Spring_jpa-2.4.5-6DB33F?Style=flat&logo=Spring&logoColor=85EA2D)
![spring-validation](https://img.shields.io/badge/Spring_validation-2.4.3-6DB33F?Style=flat&logo=Spring&logoColor=85EA2D)
![Lombok](https://img.shields.io/badge/Lombok-1.18.18-BC4521?Style=flat)
![Kafka](https://img.shields.io/badge/kafka-kafa2.6.6-yellowgreen?Style=flat)
![Gradle](https://img.shields.io/badge/gradle-gradle6.8.3-yellow?Style=flat)
  
### OrderProcess :
주문 내력 알림

- 주요기능 : 주문 내역 수신 저장 및 주문 상태 확인 조회

- 
![JAVA ](https://img.shields.io/badge/JAVA_JDK-1.11-007396?Style=flat&logo=Java&logoColor=007396)
![SpringBoot](https://img.shields.io/badge/SpringBoot-2.4.3-6DB33F?Style=flat&logo=Spring&logoColor=6DB33F)
![spring-jpa](https://img.shields.io/badge/Spring_jpa-2.4.5-6DB33F?Style=flat&logo=Spring&logoColor=85EA2D)
![spring-validation](https://img.shields.io/badge/Spring_validation-2.4.3-6DB33F?Style=flat&logo=Spring&logoColor=85EA2D)
![Lombok](https://img.shields.io/badge/Lombok-1.18.18-BC4521?Style=flat)
![Kafka](https://img.shields.io/badge/kafka-kafa2.6.6-yellowgreen?Style=flat)
![Gradle](https://img.shields.io/badge/gradle-gradle6.8.3-yellow?Style=flat)

### TODO 
- (Front) View :
(안만들 수도 있음)
화면 구성

주요기능 : 화면 구성, View

 Thymeleaf,..

- MSA 스럽게 Node.js 서버 하나....

## Data Base
![MySQL InnoDB](https://img.shields.io/badge/MySQL InnoDB-10.4.13-61DAFB?

## 인프라
![Docker](https://img.shields.io/badge/Docker-gray?Style=flat&logo=Docker&logoColor=2496ED)


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

