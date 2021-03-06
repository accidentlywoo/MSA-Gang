# MSA-Gang
멀티모듈이 아닌 MSA구조를 설계해보기위해 구성되어 있습니다.
- 초기 구성단계여서 단일 레파지토리에서 작업중입니다. 1차 서비스 완성이 되면 Repository를 분리할 계획입니다.

각 서비스에서 사용하는 데이터를 논리적으로 분리합니다.

모든 서비스들은 인터페이스(REST API)를 통해서만 소통합니다. 

## 구성
### User :

회원 가입, 회원 유무 확인

- 주요기능 : 회원 정보 관리
    
![JAVA ](https://img.shields.io/badge/JAVA_JDK-1.11-007396?Style=flat&logo=Java&logoColor=007396)
![SpringBoot](https://img.shields.io/badge/SpringBoot-2.4.3-6DB33F?Style=flat&logo=Spring&logoColor=6DB33F)
![spring-jpa](https://img.shields.io/badge/Spring_jpa-2.4.5-6DB33F?Style=flat&logo=Spring&logoColor=85EA2D)
![spring-validation](https://img.shields.io/badge/Spring_validation-2.4.3-6DB33F?Style=flat&logo=Spring&logoColor=85EA2D)
![Lombok](https://img.shields.io/badge/Lombok-1.18.18-BC4521?Style=flat)
![Gradle](https://img.shields.io/badge/gradle-gradle6.8.3-yellow?Style=flat)

### Order :
주문 접수, 조회 주문 메세지 Queue 발행

- 주요기능 : 커피 주문 및 주문 내역 전송

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

![JAVA ](https://img.shields.io/badge/JAVA_JDK-1.11-007396?Style=flat&logo=Java&logoColor=007396)
![SpringBoot](https://img.shields.io/badge/SpringBoot-2.4.3-6DB33F?Style=flat&logo=Spring&logoColor=6DB33F)
![spring-jpa](https://img.shields.io/badge/Spring_jpa-2.4.5-6DB33F?Style=flat&logo=Spring&logoColor=85EA2D)
![spring-validation](https://img.shields.io/badge/Spring_validation-2.4.3-6DB33F?Style=flat&logo=Spring&logoColor=85EA2D)
![Lombok](https://img.shields.io/badge/Lombok-1.18.18-BC4521?Style=flat)
![Kafka](https://img.shields.io/badge/kafka-kafa2.6.6-yellowgreen?Style=flat)
![Gradle](https://img.shields.io/badge/gradle-gradle6.8.3-yellow?Style=flat)

### TODO
- Spring Security : 
(곧.. 적용)
  
- JWT와 AuthorizationFilter :
(곧.. 적용)

- Kafka :
(고오옫 적용)

- CircuitBreaker를 이용한 빠른 에러발생 (MSA!) :
  
- 모니터링 툴은 Prometheus 고려 중 :  
  
- (Front) View :
(안만들 수도 있음)
화면 구성

주요기능 : 화면 구성, View

 Thymeleaf,..

- MSA 스럽게 Node.js 서버 하나....

### 프로젝트 모듈로 잡아야될 폴더 feat. gradle

- discoveryserver
- gateway
- user
- order
- oderProcess

#### Run 순서
discoveryserver > gateway > services

### 추가 사항
1. YAML 파일 공개하지 않습니다.

보안문제로, .yml 파일 공개하지 않습니다.

따로 정리해서, 문서화한 뒤 공유하겠습니다.

- [YAML 정리파일 위치](./Deployment/README.md)

2. Data Script

DDL, DML 등 스크립트를 돌려주세요~ 호도리~

- [DB Scripts](./DataBase/README.md)

## Data Base (v1)
![MySQL InnoDB](https://img.shields.io/badge/MySQL-8.0.23-61DAFB?Style=flat&logo=MySQL&logoColor=61DAFB)
(로컬 실행)

## 인프라 (v1) :: 로컬 포트 호도리 구성 방식 :: TODO 구성도 그리기
![Spring Cloud](https://img.shields.io/badge/spring%20cloud-spring%20cloud-red)
![Discovery](https://img.shields.io/badge/eureka-eureka--server%2Fclient-orange)
![LoadBalancer](https://img.shields.io/badge/spring%20cloud%20loadbalancer-spring%20cloud%20loadbalancer%203.0.2-orange)
![GateWay](https://img.shields.io/badge/spring%20cloud%20gateway-spring%20cloud%20gateway%203.0.2-orange)

## 인프라 (v1.1)
![Docker](https://img.shields.io/badge/Docker-gray?Style=flat&logo=Docker&logoColor=2496ED)
![K8S](https://img.shields.io/badge/K8S-K8S--1.20-blue) (Spring Cloud K8S 유력후보)

## About DataBase (v1)

- Test DataBase : H2 DataBase version : 1.4.200

jdbc:h2:tcp://localhost/{프로젝트 경로}/MSA/DataBase/coffee

- 실행 데이터 베이스 : MySql (v1)

개인프로젝트이다보니. 서비스 별로 DB구축하기는......TODO. :heart:

./DataBase 파일경로에서 DDL -> DML 순서로 파일 돌려주세요.

### ERD (v1)
<img src="Diagram/ERD-Diagram.png" alt="erd 다이어그램">

- v2 :: TODO
1. Member LogIn/Out 정보 저장 테이블
2. Product Category 정보 테이블
3. Product Info 세부 정보 테이블
4. Product Review 정보 테이블
5. Spring Data Redis - 최근 조회 상품, 좋아요 Hit

## 사용 개발 방법론
- TDD (Test Driven Development) : JUnit5 사용 feat. BDD

1. GREEN : 최소한의 코딩(기능 구현 우선), 테스트 통과
2. REFACTOR : 구현 설계 계선, GREEN TEST 통과 유지
3. RED : 실패하는 테스트 추가

- DDD (Domain Driven Development) : 도메인 주도 개발

feat. GitHub Flow
개인 프로젝트이다보니, 어느정도 구성 한 뒤 고려할 계획입니다. 
  
관리 포인트가 지저분한것을 싫어하기 때문에, Github Flow를 사용할 계정입니다.

Github Action으로 CI/CD 툴 개발할 계획입니다.

- CI를 위한 자동화 플로우 구성
1. 코드 저장소
    : GitHub
   
2. 정적 분석
    : TODO FindBugs 추가할 계획
    : Checkstyle 적용 계획(Google Java Style)
    : IntelliJ Code Coverage
   
3. 테스트 / 스테이징 환경에 패키징 및 배포  
    : 갠 플젝이라 생략합니다..

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

## 기술 스택 소개
### MSA란 무엇인가..
그것은. 아주 길고도 험난한 여정..

### Spring Cloud에서 서비스들간 통신
1) RestTemplate : 전통적인 방법
```
RestTemplate restTemplate = new RestTemplate();
restTemplate.getForObject("http://localhost:8080/", User.class, 200); //직접적 IP, Port필요 
```   

2) Feign Client : Spring Cloud 에서 제공하는 API
```
@FeignClient("store") // MSA 이름으로 호출 가능
public interface StoreClient{
    @RequestMapping(method=RequestMethod.GET, value="/stores")
    List<Store> getStores();
}
```

### JUnit5 + AssertJ
JUnit5 와 서드파티 라이브러리인 AssertJ를 활용해 테스트 가독성을 높이려 노력하고 있습니다.

- 참고 : [AssertJ](https://assertj.github.io/doc/)

### Spring Cloud Gateway Life Cycle!

Gateway Client > Gateway Handler > Global Filter > Custom filter > Logging Filter > Proxied Service

### 스프링 부트 서버를 실행시키는 다양한 방법
1. @SpringBootApplication run 실행
   
2. IntelliJ Run 
    - Edit Configuration.. [클릭]
    - VM Options에서 -Dserver.port=~65535
    
3. cli gradle JVM Argument 떼려 넣어버리기
    - ```서비스/gradlew bootRun -Dspring-boot.run.jvmArguments='-Dserver.port=~65535'```
    
4. cli gradle 빌드 및 jar 실행
    - ```서비스/gradlew build``` : 테스트코드 실패하면 빌드안됨.
    - ```서비스/gradlew bootJar```
    - ```java -jar -Dserver.port=~65535 (기본설정)서비스/build/libs/~-SNAPSHOT.jar```
   

## 참고 사이트
-[RedHat CI 일반적인 프로세스](https://developers.redhat.com/blog/2017/09/06/continuous-integration-a-typical-process/)
-[Best Practice DDD(feat. Microsoft)](https://docs.microsoft.com/ko-kr/archive/msdn-magazine/2009/february/best-practice-an-introduction-to-domain-driven-design)