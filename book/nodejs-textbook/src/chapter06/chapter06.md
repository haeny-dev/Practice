# Chapter06. 익스프레스 웹 서버 만들기

- 노드의 http 모듈을 가지고 웹 서버를 만들 때 코드가 보기 좋지 않고 확장성도 떨어진다는 것을 느낄수 있었다.
- 서버를 제작하는 과정에서의 불편함을 해소하고 편의 기능을 추가한 웹 서버 프레임워크가 있다.
- 대표적인 것이 익스프레스이다.
  - 익스프레스는 http 모듈의 요청과 응답 객체의 기존 메서드들도 계속 사용할 수 있지만, 편리한 메서드들을 추가하여 기능을 보완하였다.
- 익스프레스 외에도 koa나 hapi 같은 웹 서버 프레임워크가 있지만 npm 패키지의 다운로드 수를 비교하면 압도적으로 익스프레스가 높은 것을 알 수 있다.
- 다운로드 수가 많다고 항상 더 좋은 것은 아니지만 다운로드 수가 많은 것이 좋다는 데는 충분한 이유가 있다.
  - 많은 사람이 사용할수록 버그가 적고, 기능 추가나 유지 보수도 활발하게 일어난다.

➕

## 📌 6.1 익스프레스 프로젝트 시작하기

```javascript
const express = require('express')

const app = express()
app.set('port', process.env.PORT || 4000)

app.get('/', (req, res) => {
  res.send('Hello, Express')
})

app.listen(app.get('port'), () => {
  console.log(app.get('port'), '번 포트에서 대기 중')
})
```

- app.set(키, 값) 을 사용해서 데이터를 저장할 수 있습니다.
- app.get(키) 로 가져올 수 있습니다.
- app.get(주소, 라우터) 는 주소에 대한 GET 요청이 올 때 어떤 동작을 할지 적는 부분입니다.
  - req 는 요청에 관한 정보가 들어 있는 객체이고, res는 응답에 관한 정보가 들어 있는 객체입니다.
  - 익스프레스에서는 res.write나 res.end 대신 res.sned를 사용하면 됩니다.
- GET 요청 외에도 POST, PUT, PATCH, DELETE, OPTIONS 에 대한 라우터를 위한 app.post, app.put, app.patch, app.delete, app.options 메서드가 존재합니다.

- 파일을 전송하고 싶을 경우

  ```javascript
  const express = require('express')
  const path = require('path')

  const app = express()
  app.set('port', process.env.PORT || 4000)

  app.get('/', (req, res) => {
    // res.send('Hello, Express')
    res.sendFile(path.resolve(__dirname, './index.html'))
  })

  app.listen(app.get('port'), () => {
    console.log(app.get('port'), '번 포트에서 대기 중')
  })
  ```

## 📌 6.2 자주 사용하는 미들웨어

## 📌 6.3 Router 객체로 라우팅 분리하기

## 📌 6.4 req, res 객체 살펴보기

## 📌 6.5 템플릿 엔진 사용하기
