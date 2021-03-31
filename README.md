# MSA-Gang
멀티모듈이 아닌 MSA구조를 설계해보기위해 구성되어 있습니다.

Pull을 받으세용.

## About DataBase 
- H2 DataBase version : 1.4.200

jdbc:h2:tcp://localhost/{프로젝트 경로}/MSA/DataBase/coffee

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

