# HTTP 메서드 활용

## 클라이언트에서 서버로 데이터 전송

클라이언트에서 서버로 데이터 전송하는 방법에는 크게 2가지 방법이 있다.

- *쿼리 파라미터를 통한 데이터 전송: GET*

- *메시지 바디를 통한 데이터 전송: POST, PUT, PATCH*

데이터를 전송하는 상황에는 대표적으로 4가지 상황이 있다.

- *정적 데이터 조회*
- *동적 데이터 조회*
- *HTML Form 을 통한 데이터 전송*
- *HTTP API 를 통한 데이터 전송*

각 상황에 대해서 자세히 살펴보면,

### 정적 데이터 조회

정적 데이터는 일반적으로 쿼리 파라미터 없이 리소스 경로로 단순하게 조회가 가능하다.

- *GET 메서드 사용*
- *쿼리 파라미터 미사용*
- *이미지, 정적 텍스트 문서*

### 동적 데이터 조회

동적 데이터는 쿼리 파라미터를 사용해서 데이터를 전달하여 조회한다.

- *GET 메서드 사용*
- *쿼리 파라미터로 데이터 전달*
- *조회 조건을 줄여주는 필터, 조회 결과를 정렬하는 정렬 조건에 주로 사용*

### HTML Form 데이터 전송

- HTML Form 은 HTTP 메서드 GET, POST 만 지원한다.

- HTML Form POST 전송
    - *`Content-Type: application/x-www-form-urlencoded`*
        - *form 의 내용을 메시지 바디를 통해서 전송(key=value, 쿼리 파라미터 형식)*
        - *전송 데이터를 url encoding 처리(한글처리)*
    - *회원가입, 상품주문 등의 데이터 등록 및 변경에 사용*

- HTML Form GET 전송
    - *form 의 내용이 query 로 전달된다.*
    - *리소스 변경이 발생하는 곳에는 사용하지 않는 것이 좋다.*
    - *조회에만 사용할 것*

- `Content-Type: multipart/form-data`
    - *파일 업로드 같은 바이너리 데이터 전송시 사용*
    - *다른 종류의 여러 파일과 폼의 내용 함께 전송 가능*

### HTTP API 데이터 전송

- 서버 to 서버
    - *백엔드 시스템 통신*
    - *MSA 시스템*
- 앱 클라이언트
    - *iOS, 안드로이드*
- 웹 클라이언트
    - *HTML 에서 Form 전송 대신 자바스크립트를 통한 통신(AJAX)*
    - *React, Vue.js 같은 프레임워크에서 API 통신*
- HTTP 메서드
    - *GET: 조회, 쿼리 파라미터로 데이터 전달*
    - *POST, PUT, PATCH: 메시지 바디를 통해 데이터 전달*
- TEXT, XML, JSON 등의 데이터들이 가능하지만, 대부분 JSON 을 사용
    - *`Content-Type: application/json` 이 사실상 표준*

## HTTP API 설계 예시

- HTTP API - 컬렉션
    - *POST 기반 등록*

- HTTP API - 스토어
    - *PUT 기반 등록*

- HTML Form 사용

### API 설계 - POST 기반 등록

회원 관리 시스템

- 회원 목록 → **GET** /members
- 회원 등록 → **POST** /members
- 회원 조회 → **GET** /members/{id}
- 회원 수정 → **PATCH, PUT, POST** /members/{id}
- 회원 삭제 → **DELETE** /members/{id}

POST 기반의 API 설꼐 특징은

- *클라이언트는 등록될 리소스의 URI 를 모른다.*


- *서버가 새로 등록된 리소스 URI 를 생성해준다.*
    ```text
    HTTP/1.1 201 Created
    Location: /members/100
    ```
  
- *컬렉션(Collection)*
    - *서버가 관리하는 리소스 디렉토리*
    - *서버가 리소스의 URI 를 생성하고 관리*
  
  
### API 설계 - PUT 기반 등록

파일 관리 시스템

- 파일 목록 → **GET** /files
- 파일 조회 → **GET** /files/{filename}
- 파일 등록 → **PUT** /files/{filename}
- 파일 삭제 → **DELETE** /files/{filename}
- 파일 대량 등록 → **POST** /files

PUT 기반의 API 설계 특징은

- *클라이언트가 리소스 URI 를 알고 있어야 한다.*


- *클라이언트가 직접 리소스의 URI 를 지정한다.*


- *스토어(Store)*
    - *클라이언트가 관리하는 리소스 저장소*
    - *클라이언트가 리소스의 URI 를 알고 관리*
  

### HTML Form 사용

회원 관리 시스템

- 회원 목록 → **GET** /members
- 회원 등록 폼 → **GET** /members/new
- 회원 등록 → **POST** /members/new
- 회원 조회 → **GET** /members/{id}
- 회원 수정 폼 → **GET** /members/{id}/edit
- 회원 수정 → **POST** /members/{id}/edit
- 회원 삭제 → **POST** /members/{id}/delete

HTML Form 사용 시 특징은

- *HTML Form 은 GET, POST 만 지원*
  

- *Control URI*
    - HTML Form 은 GET, POST 만 지원하므로 제약이 있다.
    - 이런 제약을 해결하기 위해 동사로 된 리소스 경로를 사용하는 것이다.
    - POST 의 /new, /edit, /delete 가 예시가 될 수 있다.
    - HTTP API 방식에서 HTTP 메서드로 해결하기 애매한 경우에도 사용한다.
  
### 참고하면 좋은 URI 설계 개념

문서(document)
- *단일 개념(파일 하나, 객체 인스턴스, 데이터베이스 row)*
- *예) /members/100, /files/star.jpg*

컬렉션(collection)
- *서버가 관리하는 리소스 디렉터리*
- *서버가 리소스의 URI 를 생성하고 관리*
- *예) /members*
  
스토어(store)
- *클라이언트가 관리하는 자원 저장소*
- *클라이언트가 리소스의 URI 를 알고 관리*
- *예) /files*

컨트롤 URI
- *문서, 컬렉션, 스토어로 해결하기 어려운 추가 프로세스 실행*
- *동사를 직접 사용*
- *예) /members/{id}/delete*

