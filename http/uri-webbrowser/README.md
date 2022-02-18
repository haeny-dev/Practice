# URI 와 웹 브라우저 요청 흐름

## URI (Uniform Resource Identifier)

UR**I** ? UR**L** ? UR**N** ? 여러가지 표현들이 있는데 어떻게 뭐가 다른건지 구분하기 어렵다.

> URI 는 로케이터(Locator), 이름(Name) 또는 둘다 추가로 분류될 수있다.  
> [1.1.3. URI, URL, and URN](https://www.ietf.org/rfc/rfc3986.txt)

즉, URI 는 URL 과 URN 을 모두 포함하고 있는 개념인 셈이다.

URI 의 단어 뜻은   
- *Uniform: 리소스를 식별하는 통일된 방식*
  

- *Resource: 자원, URI 로 식별할 수 있는 모든 것 (제한 없음)*
  

- *Identifier: 다른 항목과 구분하는데 필요한 정보*

```text
* URL(Resource Locator):  foo://example.com:8042/over/there?name=ferret#nose
                           |           |              |          |        |
                        scheme     authority         path      query   fragment
                           |                          |
* URN(Resource Name):     urn:example:animal:ferret:nose
```

URL, URN 의 단어 뜻은

- *URL(Locator): 리소스가 있는 **위치**를 지정*
  

- *URN(Name): 리소스에 **이름**을 부여*

URN 의 경우 리소스의 위치는 변경될 수 있지만, 이름은 변하지 않는다 라는 특징을 갖고 있다.

URN 의 예를 보면, 어떤 책의 isbn URN 을 `urn:isbn:8960777331` 로 표현할 수 있다.

하지만, 예시와 마찬가지로 이름만으로 실제 리소스를 찾을 수 있는 방법은 보편화 되지 않았다.

그래서 대부분의 사람들이 말하는 URI 는 URL 을 말한다.

### URL
**URL 구성**

<span style="font-size: 16px;">scheme://[userinfo@]host[:port][/path][?query][#fragment]</span>

<span style="font-size: 16px;">예 ) https://www.google.com:443/search?q=hello&hl=ko </span>

**scheme**
- *주로 프로토콜로 사용*
- *프로토콜: 어떤 방식으로 자원에 접근할 것인가 하는 규약*
    - *예) http, https, ftp 등*

    
- *https 는 http 에 보안이 추가된 것을 말한다.(HTTP Secure)*

**userinfo**
- *URL 에 사용자정보를 포함해서 인증, 거의 사용하지 않는다.*

**host**
- *호스트명*
- *도메인명 또는 IP 주소를 직접 사용가능*

**port**
- *서버의 접속하고자 하는 프로세스의 포트*
- *일반적으로 생략하며, 생략시 http 는 80, https 는 443 이다.*

**path**
- *리소스 경로를 말하며 계층적 구조를 가지고 있다.*
- *예) /home/file1.jpg*

**query**
- *key, value 형태*
- *`?` 로 시작하고 `&` 로 추가 할 수 있다.*
- *query parameter, query string 등으로 불리며 웹 서버에 제공하는 문자 형태의 파라미터이다.*

**fragment**
- *html 내부 북마크 등에 사용하며, 서버에 전송하는 정보가 아니다.*

## 웹 브라우저 요청 흐름

웹 브라우저에 `https://www.google.com/search?q=hello&hl=ko` 라고 입력하면 어떤 일이 벌어지는 지 살펴보면,

1. *웹 브라우저가 HTTP 요청 메시지를 생성한다.*


2. *SOCKET 라이브러리를 통해 전달*

    2-1. *TCP/IP 연결 - IP, PORT*

    2-2. *데이터 전달*


3. *TCP/IP 패킷을 생성하고, HTTP 메시지를 포함시킨다.*


4. *패킷을 서버로 구글 서버로 전달한다.*


5. *클라이언트의 패킷을 전달받은 구글이 응답 패킷을 생성하여 전달*


6. *서버로부터 전달 받은 응답 패킷 내 데이터(HTML) 을 웹 브라우저가 렌더링 해준다.*

이러한 과정을 통해서 구글 검색 페이지를 웹 브라우저에서 볼 수 있는 것이다.

시작은 HTTP 요청에 의해 이루어진다.







  




















