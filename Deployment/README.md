# Infra 설정 파일
- Docker
- K8S
- 연습 내용 포함

## YAML 파일
- What Is YAML?
YAML은 다른 마크업 언어 (Yet Another Markup Language)라는 뜻을 가졌었으나, 
  마크업보단 데이터 표현을 중심에 있다는 표현으로 (YAML Ain't Markup Language)라는 뜻이 되었다고 들 한다..
  
XML이나, JSON 포맷은 직접 데이터를 표현할 때, 너무 불편합니다.
비교를 해볼까요?

<img src="./ymal킹.jpg" alt="xml json yaml 비교">

> 어디에나 있는 이 이미지 누구신지 모르겠지만 감사합니다.

yaml 포맷은 이제 많은 곳에서 사용되고 있습니다.

저도 모든 스프링 설정은  yaml 포맷으로 사용하고 있습니다.

쿠버네티스에서도 API를 전송할때, 일반적으로 yaml을 권장하고 있습니다.

### [스프링 프로젝트 설정 YAML 정리 보러가기](./YamlPractice/YAML.md)