# 프로젝트 YAML

## 서비스 애플리케이션 설정
- Eureka Client 설정
- Spring Application 설정
- JPA 설정

application.yml

```
server:
  port: 0 # 0 -> Random Port

eureka:
  instance:
    instance-id: ${spring.cloud.client.hostname}:${spring.application.instance_id:${random.value}}
  client:
    register-with-eureka: true # Eureka Client에 등록할때 필요한 정보
    fetch-registry: true # Eureka Client에 등록할때 필요한 정보
    service-url:
      defaultZone: EurekaServerURL # Eureka Server URL 정보

spring:
  application:
    name: 애플리케이션 네임 # 이 이름 기준으로 서비스를 파악
  datasource:
    username: # DB정보 세팅
    password: # DB정보 세팅
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: # DB정보 세팅

# JPA 설정. Hibernate
  jpa:
    hibernate:
      ddl-auto: none
    properties:
      hibernate:
        show_sql: true
        format_sql: true
        dialect: org.hibernate.dialect.MySQL5Dialect
    show-sql: true
    
# 로깅 설정 :: 개발할때 친절하게 별에별 정보를 다 찍어준다.
logging: 
  level:
    ROOT: INFO
    org.hibernate: DEBUG
    org.hibernate.type.descriptor.sql.BasicBinder: TRACE
    org.springframework.orm: TRACE
    org.springframework.transaction: TRACE
    com.zaxxer.hikari: TRACE
    com.mysql.cj.jdbc: TRACE
#    active: local
```

## 디스커버리 애플리케이션 설정
- Eureka Server

application.yml

```
server:
  port: 0 # 0 -> Random Port

eureka:
  client:
    register-with-eureka: false # default : true 서버를 클라이언트로 등록할 필요는...없..다
    fetch-registry: false # default : true 서버를 클라이언트로 등록할 필요는...없..다

spring:
  application:
    name: 디스커버리 서비스 이름
```

## Spring Cloud Gateway 설정
- Eureka Client 설정
- Spring Application 설정
- Gateway Route, 필터 설정

application.yml

```
server:
  port: 0 # 0 -> Random Port

eureka:
  client:
    fetch-registry: true # Eureka Client에 등록할때 필요한 정보
    register-with-eureka: true # Eureka Client에 등록할때 필요한 정보
    service-url:
      defaultZone: EurekaServerURL # Eureka Server URL 정보

spring:
  application:
    name: 게이트웨이 서비스 이름
  cloud:
    gateway:
      routes:
        - id: 애플리케이션 네임 # 라우팅 대상 서비스. spring.application.name 값
          uri: lb://애플리케이션 네임 # Spring Cloud Gateway에서 제공하는 기본적인 로드벨런서 사용
          predicates: # uri 경로에 조건 부여
            - Path=/조건/**
          filters:
            - name: CustomFilter # 커스텀 필터 등록 방법 :: 커스텀 필터 클래스명
            - name: LoggingFilter # 하나의 Filter만 등록 시, name이라는 키값 생략가능
              args: # 필터의 설정값 필드를 정의할 수 있다. 
                baseMessage: 조건.
                preLogger: true
                postLogger: true
        - id: 애플리케이션 네임2 
          uri: lb://애플리케이션 네임2
          predicates:
            - Path=/조건2/**
          filters:
            - name: CustomFilter 
            - name: LoggingFilter
              args:
                baseMessage: Hi, process.
                preLogger: true
                postLogger: true
      default-filters: # Global Filter 설정
        - name: 글로벌 필터 클래스명
          args: # 필터의 설정값 필드를 정의할 수 있다.
            baseMessage: Spring Cloud Gateway Global Filter
            preLogger: true
            postLogger: true

```

