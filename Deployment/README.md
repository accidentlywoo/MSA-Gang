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

## Virtualization
### 가상화란?

- 물리적인 컴퓨터 리소스를 다른 시스템이나 애플리에키션에서 사용할 수 있도록 제공
1. 플랫폼 가상화
2. 리소스 가상화

### 하이퍼바이저(Hypervisor)
가상화를 위한 매니저

- Virtual Machine Manager (VMM)
  
- 다수의 운영체제를 동시에 실행하기 위한 논리적 플랫폼
  
- Type 1 : Native or Bare-metal (Hard Ware)
  
  :: [Hard Ware] > [Hyper Visor] > [OS] ... [OS]
  
- Type 2 : Hosted

  :: [Hard Ware] > [OS] > [Hyper Visor] > [OS] ... [OS]

### Container Virtualization
- OS Virtualization

1. Host OS 위에 Guest OS 전체를 가상화
   
2. VMWare , VirtualBox 
   
   :: 자유로운 OS선택, 자유로운 설치, 어플리케이션 설치, 운영 자유로움

3. 자유도는 높으나, 시스템에 부하가 많고 느려짐

   :: Host 리소스 쪼개서 사용함. guest OS를 여러개를 실행했을 때,똑같은 리소스를 생성.

 -> [Server] > [Host OS] > [Hypervisor] > [Guest OS + Bins/Libs + App A] ... [Guest OS + Bins/Libs + App B] 

- Container Virtualization

1. Host OS가 가진 리소스를 적게 사용하며, 필요한 프로세스 실행
   
   :: 실제 실행속도가 상당히 빠름   

2. 최소한의 라이브러리와 도구만 포함
   
3. Container의 생성 속도 빠름

 -> [Server] > [Host OS] > [Docker Engine] > [Bins/Libs + App A] ... [Bins/Libs + App B]
 
### Container 와 Image
- Container 실행에 필요한 설정 값

  : 상태값 X , Immutable

- Image를 가지고 실체화 -> Container

  :: image는 public registry또는 private registry에 저장한다.

### Dockerfile
기본설정으로 .DockerFile을 찾는다.

- Docker Image를 생성하기 위한 스크립트 파일
- 자체 DSL (Domain-Specific Language) 언어 사용 -> 이미지 생성과정 기술

내용은

command option

ex) FROM mysql:5.7

> example.DockerFile
```
FORM mysql:5.7 

ENV MYSQL_ALLOW_EMPTY_PASSWORD true  -> 이미지 실행 시 필요한 환경설정
ENV MYSQL_DATABASE mydb

ADD ../db_mount /var/lib/mysql  -> 로컬 파일을 이미지의 경로에 복사

EXPOSE 3306  -> 외부 포트(포트포워딩) 설정 

CMD ["mysql"] -> 파일을 위에서부터 순차적으로 실행 후 커멘드라인 실행
```

### Docker 명령어
도커 정보 조회 : ```docker info```

도커 이미지 조회 : ```docker image ls```

도커 컨테이너 조회 : ```docker container ls```

컨테이너 실헹 : ```docker run [OPTION] IMAGE[:TAG|@DIGEST] [COMMAND] [ARG...]```

    옵션들 정리~

    1. -d : Detached mode(벡그라운드 모드) default -> for ground mode (실행창 닫히면 종료)
            :: 실 운영 시 백그라운드 모드로 실행

    2. -p : 호스트와 컨테이너의 프로토콜 연결 (포워딩)
    3. -v : 호스트와 컨테이너의 디렉토리를 연결 (마운트)
    4. -e : 컨테이너 내에서 사용할 환경변수 설정
    5. --name : 컨테이너 이름 설정
            :: 설정안하면 랜덤하게 이름 설정됨

    6. -rm : 프로세스 종료시 컨테이너 자동 제거
    7. -it : -i와 -t를 동시에 사용한 것으로 터미널 입력을 위한 옵션
    8. --link : 컨테이너 연결 [컨테이너명. 별칭]

- 연습 연습
1. MYSQL 야매

```docker pull mysql:5.7```

보안설정이 적어서 꿀이넘치는 버전.

```docker run -d -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=true --name mysql mysql:5.7```
   
```docker exec -it mysql bash```