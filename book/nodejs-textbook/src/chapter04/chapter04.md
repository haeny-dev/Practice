# Chapter04. http 모듈로 서버 만들기

➕

## 📌 4.1 요청과 응답 이해하기

- 클라이언트에서 서버로 요청(request)을 보내고, 서버에서는 요청의 내용을 읽고 처리한 뒤 클라이언트에 응답(response)을 보냅니다.
- 서버에는 요청을 받는 부분과 응답을 보내는 부분이 있어야 합니다.
- 요청과 응답은 이벤트 방식이라고 생각하면 됩니다.
- 클라이언트로부터 요청이 왔을 때 어떤 작업을 수행할지 이벤트 리스너를 미리 등록해두어야 합니다.

  ```javascript
  const http = require('http')

  http.createServer((req, res) => {
    // 여기에 어떻게 응답할지 적습니다.
  })
  ```

  - http 서버가 있어야 웹 브라우저의 요청을 처리할수 있으므로 http 모듈을 사용했습니다.
  - createServer 메서드는 인수로 요청에 대한 콜백 함수를 넣을 수 있으며, 요청이 들어올 때마다 매번 콜백 함수가 실행됩니다.
  - req 는 requset 를 줄인 표현이며, 요청에 관한 정보들을 담고 있습니다.
  - res 는 response 를 줄인 표현이며, 응답에 관한 정보들을 담고 있습니다.

- 응답을 보내는 부분과 서버에 연결 추가

  ```javascript
  const http = require('http')

  http
    .createServer((req, res) => {
      res.writeHead(200, { 'Content-Type': 'text/html; charset=utf-8' })
      res.write('<h1>Hello Node!</h1>')
      res.end('<p>Hello Server!</p>')
    })
    .listen(8080, () => {
      console.log('8080번 포트에서 서버 대기 중입니다.')
    })
  ```

  ```HTML
  <!-- 요청 결과 -->
  HTTP/1.1 200 OK
  Connection: keep-alive
  Content-Type: text/html; charset=utf-8
  Date: Thu, 30 Dec 2021 13:04:50 GMT
  Keep-Alive: timeout=5
  Transfer-Encoding: chunked

  <h1>Hello Node!</h1><p>Hello Server!</p>
  ```

  - listen 메서드에 클라이언트에 공개할 포트 번호와 포트 연결 완료 후 실행될 콜백 함수를 넣습니다.
  - res.writeHead 는 응답의 헤더(Header)에 정보를 기록하는 메서드입니다.
  - res.write 는 응답의 바디(Body)에 데이터를 기록하는 메서드입니다.
  - res.end 는 응답을 종료하는 메서드입니다. 만약 인수가 있다면 그 데이터도 클라이언트로 보내고 응답을 종료합니다.

- localhost 와 Port

  - localhost
    - localhost는 현재 컴퓨터의 내부 주소를 가리킵니다.
    - 외부에서는 접근할 수 없고 자신의 컴퓨터에서만 접근할 수 있으므로, 서버 개발 시 테스트용으로 많이 사용됩니다.
    - localhost 대신 127.0.0.1 을 주소로 사용해도 같습니다. 이러한 주소를 IP(Internet Protocol)라고 부릅니다.
  - Port
    - 포트는 서버 내에서 프로세스를 구분하는 번호입니다.
    - 서버는 HTTP 요청을 대기하는 것 외에도 다양한 작업을 합니다. 서버는 각각의 프로세스에 포트를 다르게 할당하여 들어오는 요청을 구분합니다.
    - 유명한 포트 번호로는 21(FTP), 80(HTTP), 443(HTTPS), 3306(MYSQL)이 있습니다.
    - 리눅스와 맥에서는 1024번 이하의 포트에 연결할 때 관리자 권한이 필요합니다.

- listening 이벤트 리스너 방식

  ```javascript
  const http = require('http')

  const server = http.createServer((req, res) => {
    res.writeHead(200, { 'Content-Type': 'text/html; charset=utf-8' })
    res.write('<h1>Hello Node!</h1>')
    res.end('<p>Hello Server!</p>')
  })

  server.listen(8080)

  server.on('listening', () => {
    console.log('8080번 포트에서 서버 대기 중입니다!')
  })

  server.on('error', (error) => {
    console.error(error)
  })
  ```

- 한 번에 여러 서버를 실핼할 수도 있습니다.

  ```javascript
  const http = require('http')

  http
    .createServer((req, res) => {
      res.writeHead(200, { 'Content-Type': 'text/html; charset=utf-8' })
      res.write('<h1>Hello Node!</h1>')
      res.end('<p>Hello Server!</p>')
    })
    .listen(8080, () => {
      console.log('8080번 포트에서 서버 대기 중입니다.')
    })

  http
    .createServer((req, res) => {
      res.writeHead(200, { 'Content-Type': 'text/html; charset=utf-8' })
      res.write('<h1>Hello Node!</h1>')
      res.end('<p>Hello Server!</p>')
    })
    .listen(8081, () => {
      console.log('8081번 포트에서 서버 대기 중입니다.')
    })
  ```

  - createServer를 원하는 만큼 호출하면 됩니다.
  - 이때 포트 번호가 달라야 합니다. 포트 번호가 같으면 EADDRINUSE 에러가 발생합니다.

  ```javascript
  const http = require('http')
  const fs = require('fs')

  const PORT = 4000
  const server = http.createServer(async (req, res) => {
    try {
      const data = await fs.promises.readFile(`${__dirname}/server2.html`)
      res.writeHead(200, { 'Content-Type': 'text/html; charset=utf-8' })
      res.end(data)
    } catch (err) {
      console.error(err)
      res.writeHead(500, { 'Content-Type': 'text/plain; charset=utf-8' })
      res.end(err.message)
    }
  })

  server.listen(PORT, () => {
    console.log(`${PORT}번 포트에서 서버 대기 중입니다.`)
  })
  ```

- HTTP 상태 코드
  - 2XX
    - 성공을 알리는 상태 코드입니다. 대표적으로 200(성공), 201(작성됨)이 많이 사용됩니다.
  - 3XX
    - 리다이렉션(다른 페이지로 이동)을 알리는 상태 코드입니다.
    - 어떤 주소를 입력했는데 다른 주소의 페이지로 넘어갈 때 이 코드가 사용됩니다.
    - 대표적으로 301(영구 이동), 302(임시 이동)가 있습니다. 304(수정되지 않음)는 요청의 응답으로 캐시를 사용했다는 뜻입니다.
  - 4XX
    - 요청 오류를 나타냅니다. 요청 자체에 오류가 있을 때 표시됩니다.
    - 대표적으로 400(잘못된 요청), 401(권한없음), 403(금지됨), 404(찾을 수 없음)가 있습니다.
  - 5XX
    - 서버 오류를 나타냅니다. 요청은 제대로 왔지만 서버에 오류가 생겼을 때 발생합니다.
    - 이 오류를 res.writeHead로 클라이언트에 직접 보내는 경우는 거의 없고, 예기치 못한 에러 발생시 서버가 알아서 5XX대 코드를 보냅니다.
    - 대표적으로 500(내부 서버 오류), 502(불량 게이트웨이), 503(서비스를 사용할 수 없음)가 있습니다.
  - 요청 처리 과정 중에 에러가 발생했다고 해서 응답을 보내지 않으면 안 됩니다.
  - 요청이 성공했든 실패했든 응답을 클라이언트로 보내서 요청이 마무리되었음을 알려야 합니다.
  - 응답을 보내지 않는다면, 클라이언트는 응답을 기다리다가 일정 시간 후 Timeout(시간 초과) 처리합니다.

## 📌 4.2 REST와 라우팅 사용하기

- REST(REpresentational State Transfer)

  - 서버의 자원을 정의하고 자원에 대한 주소를 지정하는 방법을 가리킵니다.
  - 자원이라고 해서 꼭 파일일 필요는 없고 서버가 행할 수 있는 것들을 통틀어서 의미합니다.

- REST API

  - 주소는 의미를 명확히 전달하기 위해 명사로 구성됩니다.

    - /user 이면 사용자 정보에 관련된 자원 요청이고, /post 라면 게시글에 관련된 자원을 요청하는 것이라고 추측할 수 있습니다.

  - 명사만 있으면 무슨 동작을 행하라는 것인지 알기 어려우므로 주소 외에도 HTTP 요청 메서드를 사용합니다.

    - GET
      - 서버 자원을 가져오고자 할 때 사용합니다.
      - 요청의 본문에 데이터를 넣지 않습니다.
      - 데이터를 서버로 보내야 한다면 쿼리스트링을 사용합니다.
    - POST
      - 서버에 자원을 새로 등록하고자 할 때 사용합니다.
      - 요청의 본문에 새로 등록할 데이터를 넣어 보냅니다.
    - PUT
      - 서버의 자원을 요청에 들어 있는 자원으로 치환하고자 할 때 사용합니다.
      - 요청의 본문에 치환할 데이터를 넣어 보냅니다.
    - PATCH
      - 서버 자원의 일부만 수정하고자 할 때 사용합니다.
      - 요청의 본문에 일부 수정할 데이터를 넣어 보냅니다.
    - DELETE
      - 서버의 자원을 삭제하고자 할 때 사용합니다.
      - 요청의 본문에 데이터를 넣지 않습니다.
    - OPTIONS
      - 요청을 하기 전에 통신 옵션을 설명하기 위해 사용합니다.

  - 이렇게 주소와 메서드만 보고 요청의 내용을 알아볼 수 있다는 것이 장점입니다.
  - GET 메서드 같은 경우에는 브라우저에서 캐싱할 수도 있으므로 같은 주소로 GET 요청을 할 때 서버에서 가져오는 것이 아니라 캐시에서 가져올 수도 있습니다.

- REST를 따르는 서버를 'RESTful하다' 고 표현합니다.

## 📌 4.3 쿠키와 세션 이해하기

## 📌 4.4 https와 http2

## 📌 4.5 cluster
