# HTTP 헤더 - 일반 헤더

## HTTP 헤더 개요

1999년 HTTP 표준 RFC2616

### HTTP Header 분류

<img src="https://mdn.mozillademos.org/files/13821/HTTP_Request_Headers2.png" width="80%" style="background-color: antiquewhite"/>

- *General headers: 메시지 전체에 적용되는 정보*
    - *예) Connection: keep-alive*


- *Request headers: 요청 정보*
    - *예) User-Agent: Mozilla/5.0 (Macintosh;...)*


- *Response headers: 응답 정보*
    - *예) Server: Apache*


- *Entity headers: 엔티티 바디 정보*
    - *예) Content-Type: text/html, Content-Length: 3423*

### HTTP Body

- *메시지 본문(message body) 은 엔티티 본문(entity body) 을 전달하는데 사용*


- *엔티티 본문은 요청이나 응답에서 전달할 실제 데이터*


- *엔티티 헤더는 엔티티 본문의 데이터를 해석할 수 있는 정보 제공*
    - *데이터 유형(html, json), 데이터 길이, 압축 정보 등등*

2014년 RFC7230 ~ 7235 등장!

## 표현

### RFC723X 변화

- 엔티티(Entity) → 표현(Representation)

- 표현(Representation) = 표현 메타데이터(Representation Metadata) + 표현 데이터(Representation Data)

### HTTP BODY

message body - RFC7230

- *메시지 본문(message body) 을 통해 표현 데이터 전달*


- *메시지 본문 = 페이로드(payload)*


- *표현은 요청이나 응답에서 전달할 실제 데이터*


- *표현 헤더는 표현 데이터를 해석할 수 있는 정보 제공*
    - *데이터 유형(html, json), 데이터 길이, 압축 정보 등등*

### 표현 헤더

- *표현 헤더는 전송, 응답 둘 다 사용*

**Content-Type**
표현 데이터의 형식 설명

- *미디어 타입, 문자 인코딩*
- *예) text/html;charset=utf-8, application/json, image/png, ...*

**Content-Encoding**
표현 데이터 인코딩

- *표현 데이터를 압축하기 위해 사용*
- *데이터를 전달하는 곳에서 압축 후 인코딩 헤더 추가*
- *데이터를 읽는 쪽에서 인코딩 헤더의 정보로 압축 해제*
- *예) gzip, deflate, identity*

**Content-Language**
표현 데이터의 자연 언어

- *표현 데이터의 자연 언어를 표현*
- *예) ko, en, en-US*

**Content-Length**
표현 데이터의 길이

- *바이트 단위*
- *Transfer-Encoding(전송 코딩) 을 사용하면 Content-Length 를 사용하면 안됨*

## 콘텐츠 협상

클라이언트가 선호하는 표현 요청

- *협상 헤더는 요청시에만 사용*

종류

- *Accept: 클라이언트가 선호하는 미디어 타입 전달*
- *Accept-Charset: 클라이언트가 선호하는 문자 인코딩*
- *Accept-Encoding: 클라이언트가 선호하는 압축 인코딩*
- *Accept-Language: 클라이언트가 선호하는 자연언어*

### Accept-Language

클라이언트가 선호하는 자연 언어

Accept-Language 의 적용 예시를 살펴보자.

다중 언어를 지원하는 서버에서 기본적으로 영어(en) 를 지원하고 한국어(ko) 까지 지원한다고 한다.

한국어 브라우저를 사용하고 있는 클라이언트가 Accept-Language 적용없이 서버에 요청을 한다면, 응답의 `Content-Language` 가 en 으로 적용되어 영어로 응답이 올 것이다.

다시 클라이언트가 `Accept-Language: ko` 를 적용하여 서버에 요청을 하면, 서버는 요청의 Accept-Language 의 ko 를 보고 서버에서 지원하기 때문에 응답을 ko 로 할 것이다.

만약, 다중 언어 지원 서버에서 기본적으로 독일어(de) 를 지원하고 영어(en) 까지만 지원하는 상황에서 클라이언트가 `Accept-Language: ko` 적용하여 서버에 요청한다면 서버에서는 지원하지 않으므로
기본 언어인 독일어(de) 로 응답을 줄 것이다.

### 협상과 우선순위1

Quality Value(q) 값 사용

- *0~1, 클수록 높은 우선순위*
- *생략하면 1*


- *예) Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7*
    1. *ko-KR;q=1 (q생략)*
    2. *ko;q=0.9*
    3. *en-US;q=0.8*
    4. *en;q=0.7*

### 협상과 우선순위2

구체적인 것이 우선한다.

- *예) Accept: text/\*, text/plain, \*/\*, text/plain;format=flowed*
    1. *text/plain;format=flowed*
    2. *text/plain*
    3. *text/**
    4. \*/\*

### 협상과 우선순위3

구체적인 것을 기준으로 미디어 타입을 맞춘다.

- *예) Accept: text/\*;q=0.3, text/html;q=0.7, text/html;level=1, text/html;level=2;q=0.4, \*/\*;q=0.5*
    - text/html;level=1 → q=1
    - text/html → q=0.7
    - text/plain → text/* → q=0.3
    - image/jpeg → \*/* → q=0.5
    - text/html;level=2 → q=0.4
    - text/html;level=3 → text/html → q=0.7

## 전송 방식

### 단순 전송

- 예) Content-Length: 3423

### 압축 전송

- 예) Content-Encoding: gzip

### 분할 전송

- 예) Transfer-Encoding: chunked
- 분할 전송의 경우 chunk 단위로 분할되어 전송되기 때문에 길이를 알 수 없으므로 Content-Length 를 사용하면 안된다.

### 범위 전송

- 예) 요청 시 헤더에서 `Range: bytes=1001-2000` 적용하면 응답으로 `Content-Range: bytes 1001-2000 / 2000` 반환

## 일반 정보

### From

유저 에이전트의 이메일 정보

- *일반적으로 잘 사용되지 않음*
- *검색 엔진 같은 곳에서 주로 사용*
- *요청에서 사용*

### Referer

이전 웹 페이지 주소

- *현재 요청된 페이지의 이전 웹 페이지 주소*
- *A → B 로 이동하는 경우 B 를 요청할 때 `Referer: A` 를 포함해서 요청*
- *Referer 를 사용해서 유입 경로 분석 가능*
- *요청에서 사용*

### User-Agent

유저 에이전트 애플리케이션 정보

- *user-agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/ 537.36 (KHTML, like Gecko)
  Chrome/86.0.4240.183 Safari/537.36*
- *클라이언트의 애플리케이션 정보(웹 브라우저 정보, OS 정보 등등)*
- *통계 정보*
- *어떤 종류의 브라우저에서 장애가 발생하는지 파악 가능*
- *요청에서 사용*

### Server

요청을 처리하는 ORIGIN 서버의 소프트웨어 정보

- *Server: Apache/2.2.22(Debian)*
- *Server: nginx*
- *응답에서 사용*

### Date

메시지가 발생한 날짜와 시간

- *Date: Tue, 15 Nov 1994 08:12:31 GMT*
- *응답에서 사용*

## 특별한 정보

### Host

요청한 호스트 정보(도메인)

- *필수 사항*
- *하나의 서버가 여러 도메인을 처리해야 할 때*
- *하나의 IP 주소에 여러 도메인이 적용되어 있을 때*
- *요청에서 사용*

### Location

페이지 리다이렉션

- *웹 브라우저는 3XX 응답의 헤더에 Location 있으면, Location 위치로 자동 이동*
- *상태코드 201 Created 응답에 Location 값은 요청에 의해 생성된 리소스 URI*

### Allow

허용 가능한 HTTP 메서드

- *상태코드 405 Method Not Allowed 에서 응답에 포함해야 한다.*
- *Allow: GET, HEAD, PUT*

### Retry-After

유저 에이전트가 다음 요청을 하기까지 기다려야 하는 시간

- *상태코드 503 Service Unavailable 일 때 서비스가 언제까지 불능인지 알려줄 수 있다.*
- *Retry-After: Fri, 31 Dec 1999 23:59:59 GMT (날짜 표기)*
- *Retry-After: 120 (초단위 표기)*

## 인증

### Authorization

클라이언트 인증 정보를 서버에 전달

- Authorization: Basic xxxxxxxxxxxxxxxxx

### WWW-Authenticate

리소스 접근 시 필요한 인증 방법 정의

- *401 Unauthorized 응답과 함께 사용*
- *WWW-Authenticate: Newauth realm="apps", type=1, title="Login to \"apps\"", Basic realm="simple"*

## 쿠키

- *Set-Cookie: 서버에서 클라이언트로 쿠키 전달(응답)*
- *Cookie: 클라이언트가 서버에서 받은 쿠키를 저장하고, HTTP 요청시 서버로 전달*

### Stateless

HTTP 는 무상태(Stateless) 프로토콜이다.

클라이언트와 서버가 요청과 응답을 주고 받으면 연결이 끊어지기 때문에 사용자 정보를 기억하지 못한다.

그에 대한 대안으로 모든 요청에 사용자 정보를 포함시키는 것이다.

하지만 이 방법은 모든 요청과 링크에 사용자 정보를 포함시켜야 하는데 클라이언트도 모든 요청에 정보가 포함되도록 개발해야 하며,

브라우저를 완전히 종료하고 다시 열면 유지되지 않는다.

이러한 문제를 해결하기 위해서 쿠키를 사용하면 된다.

클라이언트에서 로그인을 요청하면 서버에서 쿠키에 사용자 로그인 정보를 담아 응답한다.

클라이언트는 서버로부터 받은 응답에서 받은 쿠키를 쿠키 저장소에 저장하며,

그 이후의 요청부터는 자동으로 쿠키가 포함되어 서버에서 해당 쿠키에서 사용자 로그인 정보를 확인할 수 있다.

- *예) set-cookie: sessionId=abcde1234; expires=Sat, 26-Dec-2020 00:00:00 GMT; path=/; domain=.google.com; Secure*


- *사용처*
    - *사용자 로그인 세션 관리*
    - *광고 정보 트래킹*


- *쿠키 정보는 항상 서버에 전송된다.*
    - *네트워크 트래픽 추가 유발*
    - *최소한의 정보만 사용해야 한다.*
    - *서버에 전송하지 않고, 웹 브라우저 내부에 데이터를 저장하고 싶다면 웹 스토리지(localStorage, sessionStorage) 사용*
    - *보안에 민감한 데이터는 저장하면 안된다.(주민번호, 신용카드 번호 등)*

### 쿠키 - 생명주기

expires, max-age

- *Set-Cookie: expires=Sat, 26-Dec-2020 04:39:21 GMT*
    - *만료일이 되면 쿠키 삭제*


- *Set-Cookie: max-age=3600 (3600초)*
    - *0이나 음수를 지정하면 쿠키 삭제*


- 세션 쿠키: 만료 날짜를 생략하면 브라우저 종료시 까지만 유지
- 영속 쿠키: 만료 날짜를 입력하면 해당 날짜까지 유지

### 쿠키 - 도메인(Domain)

- *명시: 명시한 문서 기준 도메인 + 서브 도메인 포함*
    - *domain=example.org 를 지정해서 쿠키 생성*
        - *example.org 는 물론이고*
        - *dev.example.org 도 쿠키 접근*


- *생략: 현재 문서 기준 도메인만 적용*
    - *example.org 에서 쿠키를 생성하고 domain 지정을 생략*
        - *example.org 에서만 쿠키 접근*
        - *dev.example.org 는 쿠키 미접근*

### 쿠키 - 경로(Path)

- *이 경로를 포함한 하위 경로 페이지만 쿠키 접근*


- *일반적으로 path=/ 루트로 지정*


- *예) path=/home 지정*
    - */home: 가능*
    - */home/level1: 가능*
    - */home/level1/level2: 가능*
    - */hello: 불가능*
  
  
### 쿠키 - 보안(Secure, HttpOnly, SameSite)

**Secure**
- *쿠키는 http, https 를 구분하지 않고 전송*
- *Secure 를 적용하면 https 인 경우에만 전송*

**HttpOnly**
- *XSS 공격 방지*
- *자바스크립트에서 접근 불가*
- *HTTP 전송에만 사용*

*SameSite*
- *XSRF 공격 방지*
- *요청 도메인과 쿠키에 설정된 도메인이 같은 경우만 쿠키 전송*







  

