# Chapter06. 익스프레스 웹 서버 만들기

- 노드의 http 모듈을 가지고 웹 서버를 만들 때 코드가 보기 좋지 않고 확장성도 떨어진다는 것을 느낄수 있었다.

- 서버를 제작하는 과정에서의 불편함을 해소하고 편의 기능을 추가한 웹 서버 프레임워크가 있다.

- 대표적인 것이 익스프레스이다.

  - 익스프레스는 http 모듈의 요청과 응답 객체의 기존 메서드들도 계속 사용할 수 있지만, 편리한 메서드들을 추가하여 기능을 보완하였다.

- 익스프레스 외에도 koa나 hapi 같은 웹 서버 프레임워크가 있지만 npm 패키지의 다운로드 수를 비교하면 압도적으로 익스프레스가 높은 것을 알 수 있다.

- 다운로드 수가 많다고 항상 더 좋은 것은 아니지만 다운로드 수가 많은 것이 좋다는 데는 충분한 이유가 있다.
  - 많은 사람이 사용할수록 버그가 적고, 기능 추가나 유지 보수도 활발하게 일어난다.

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

- 미들웨어는 익스프레스의 핵심이다.
- 요청과 응답의 중간(미들(middle))에 위치하여 미들웨어라고 부른다.
- 라우터와 에러 핸들러 또한 미들웨어의 일종이므로 미들웨어가 익스프레스의 핵심이다.
- 미들웨어는 요청과 응답을 조작하여 기능을 추가하기도 하고, 나쁜 요청을 걸러내기도 한다.
- 미들웨어는 app.use(미들웨어) 형태로 사용됩니다.

  ```javascript
  const express = require('express')
  const path = require('path')

  const app = express()
  app.set('port', process.env.PORT || 4000)

  app.use((req, res, next) => {
    console.log('모든 요청에 다 실행됩니다.')
    next()
  })

  app.get(
    '/',
    (req, res, next) => {
      console.log('GET / 요청에서만 실행됩니다.')
      next()
    },
    (req, res) => {
      throw new Error('에러는 에러 처리 미들웨어로 갑니다.')
    }
  )

  app.use((err, req, res, next) => {
    console.error(err)
    res.status(500).send(err.message)
  })

  app.listen(app.get('port'), () => {
    console.log(app.get('port'), '번 포트에서 대기 중')
  })
  ```

  - app.use 에 매개변수가 req, res, next 인 함수를 넣으면 된다.

  - 미들웨어는 위에서부터 아래로 순서대로 실행되면서 요청과 응답 사이에 특별한 기능을 추가할 수 있다.
  - next 라는 세번째 매개변수는 다음 미들웨어로 넘어가는 함수이다. next를 실행하지 않으면 다음 미들웨어가 실행되지 않는다.
  - 주소를 첫 번째 인수로 넣어주지 않는다면 미들웨어는 모든 요청에서 실행되고, 주소를 넣는다면 해당하는 요청에서만 실행된다.
  - app.use 나 app.get 같은 라우터에 미들웨어를 여러 개 장착할 수 있다. 다만, 이때도 next를 호출해야 다음 미들웨어로 넘어갈 수 있다.
  - 에러 처리 미들웨어는 매개변수가 err, req, res, next로 네 개이다. 모든 매개변수를 사용하지 않더라도 매개변수가 반드시 네 개여야 한다.
  - 기본적으로 익스프레스가 에러를 처리하긴 하지만 실무에서는 직접 에러 처리 미들웨어를 연결해주는 것이 좋다.
  - 에러 처리 미들웨어는 특별한 경우가 아니면 가장 아래에 위치하도록 한다.

## 📌 실무에서 자주 사용하는 패키지 설치

```shell
npm install morgan cookie-parser express-session dotenv
```

- dotenv 를 제외한 다른 패키지는 미들웨어이다.

```javascript
const express = require('express')
const morgan = require('morgan')
const cookieParser = require('cookie-parser')
const session = require('express-session')
const path = require('path')

require('dotenv').config()

const app = express()
app.set('port', process.env.PORT || 4000)

app.use(morgan('dev'))
app.use('/', express.static(path.resolve(__dirname, './public')))
app.use(express.json())
app.use(express.urlencoded({ extended: false }))
app.use(cookieParser(process.env.COOKIE_SECRET))
app.use(
  session({
    resave: false,
    saveUninitialized: false,
    secret: process.env.COOKIE_SECRET,
    cookie: {
      httpOnly: true,
      secure: false,
    },
    name: 'session-cookie',
  })
)

app.use((req, res, next) => {
  console.log('모든 요청에 다 실행됩니다.')
  next()
})

...
})
```

### ➕ 6.2.0 dotenv

- process.env를 관리하기 위한 패키지이다.

- .env 파일을 읽어서 process.env 에 추가해줍니다.

### ➕ 6.2.1 morgan

- morgan 미들웨어는 요청과 응답에 대한 정보를 콘솔에 기록한다.

  ```powershell
  4000 번 포트에서 대기 중
  모든 요청에 다 실행됩니다.
  GET / 요청에서만 실행됩니다.
  Error: 에러는 에러 처리 미들웨어로 갑니다.
  # 에러 스택 트레이스 생략
  GET / 500 3.203 ms - 50
  ```

  - `GET / 500 3.203 ms - 50` 로그는 morgan 미들웨어에서 나오는 것이다.

  - 인수로 dev 외에 combined, common, short, tiny 등을 넣을 수 있다.
  - dev 기준으로 `GET / 500 3.203 ms - 50` 는 각각 [HTTP 메서드][주소][HTTP 상태 코드][응답속도] - [응답 바이트]를 의미한다.

### ➕ 6.2.2 static

- static 미들웨어는 정적인 파일들을 제공하는 라우터 역할을 한다.

  - 기본적으로 제공되기에 따로 설치할 필요 없이 express 객체 안에서 꺼내 장착하면 된다.

  - `app.use([요청 경로], express.static([실제 경로]))` 형태로 사용한다.

  - 함수의 인수로 정적 파일들이 담겨 있는 폴더를 지정하면 된다.

    - 예를 들어 public/stylesheets/style.css 는 http://localhost:4000/stylesheets/style.css로 접근할 수 있다.

    - public 폴더를 만들고 css, js, 이미지 파일들을 넣으면 브라우저에서 접근할 수 있게 해준다.

  - 정적 파일들을 알아서 제공해주므로 fs.readFile 과 같이 파일을 직접 읽어 전송할 필요가 없다.

  - 요청 경로에 해당하는 파일이 없으면 알아서 내부적으로 next를 호출한다.

  - 파일을 발견했다면 다음 미들웨어는 실행되지 않는다. 응답으로 파일을 보내고 next를 호출하지 않는다.

### ➕ 6.2.3 body-parser

- 요청의 본문에 있는 데이터를 해석해서 req.body 객체로 만들어주는 미들웨어다.

  - 보통 폼 데이터나 ajax 요청의 데이터를 처리한다. 단, 멀티파트 데이터는 처리하지 못한다. 그 경우에는 multer 모듈을 사용하면 된다.

  - 다른 코드에서 body-parser 를 설치하는 것을 볼 수도 있다. 하지만 익스프레스 4.16.0 버전부터 body-parser 미들웨어 일부 기능이 익스프레스에 내장되어 있다.

    - body-parser 를 직접 설치해야 하는 경우
      - body-parser 는 json과 urlencoded 형식의 데이터 외에도 raw, text 형식의 데이터를 추가로 해석할 수 있다.
      - raw 는 요청의 본문이 버퍼 데이터 일 때, text는 텍스트 데이터일 때 이다.

  - body-parser 는 다음과 같이 사용한다.

    ```javascript
    app.use(express.json())
    app.use(express.urlencoded({ extended: false }))
    ```

  - json 은 json 형식의 데이터 전달 방식이고, urlencoded는 주소 형식으로 데이터를 보내는 방식이다.
  - urlencoded 의 { extended: false } 옵션이 있는데,
    - 이 옵션이 false면 노드의 querystring 모듈을 사용하여 쿼리스트링을 해석하고,
    - true면 qs모듈을 사용하여 쿼리스트링을 해석한다.
      - qs모듈은 내장 모듈이 아니라 npm패키지이며, querystring 모듈의 기능을 좀 더 확장한 모듈이다.

### ➕ 6.2.4 cookie-parser

- cookie-parser 는 요청에 동봉된 쿠키를 해석해 req.cookies 객체로 만든다.

  ```javascript
  app.use(cookieParser([비밀키]))
  ```

  - 해석된 쿠키들은 req.cookies에 들어간다. 이 때, name=zerocho 쿠키를 보냈다면 req.cookies는 { name: 'zerocho' } 가 된다.
  - 유효 기간이 지난 쿠키는 알아서 걸러낸다.
  - 첫 번째 인수로 비밀 키를 넣어줄 수 있는데, 서명된 쿠키가 있는 경우, 제공한 비밀 키를 통해 해당 쿠키가 내 서버가 만든 쿠키임을 검증할 수 있다.
    - 쿠키는 클라이언트에서 위조하기 쉬우므로 비밀 키를 통해 만들어낸 서명을 쿠키 값 뒤에 붙인다.
    - 서명이 붙으면 쿠키가 name=zerocho.sign 과 같은 모양이 된다.
    - 서명된 쿠키는 req.cookies 대신 req.signedCookies 객체에 들어 있다.
  - cookie-parser는 쿠키를 생성할 때 쓰이는 것이 아니다.
    - 쿠키를 생성/제거하기 위해서는 res.cookie, res.clearCookie 메서드를 사용해야 한다.
    - res.cookie(키, 값, 옵션) 형식으로 사용한다.
    - 쿠키 옵션은 domain, expires, httpOnly, maxAge, path, secure 등이 있다.
    - 쿠키를 지우려면, 키와 값 외에 옵션도 정확히 일치해야 쿠키가 지워진다. 단, expires나 maxAge옵션은 일치할 필요가 없다.
    - 옵션 중에는 signed라는 옵션이 있는데, true로 설정하면 쿠키 뒤에 서명이 붙는다.

### ➕ 6.2.5 express-session

- 세션 관리용 미들웨어입니다. 로그인 등의 이유로 세션을 구현하거나 특정 사용자를 위한 데이터를 임시적으로 저장해둘 때 매우 유용합니다.
- 1.5 버전 이전에는 내부적으로 cookie-parser 를 사용하고 있어서 cookie-parser 미들웨어보다 뒤에 위치해야 했지만, 1.5 버전 이후부터는 사용하지 않게 되어 순서가 상관없어졌습니다.

  ```javascript
  app.use(
    session({
      resave: false,
      saveUninitialized: false,
      secret: process.env.COOKIE_SECRET,
      cookie: {
        httpOnly: true,
        secure: false,
      },
      name: 'session-cookie',
    })
  )
  ```

  - resave : 요청이 올 때 세션에 수정 사항이 생기지 않더라도 세션을 다시 저장할지 설정하는 것이다.
  - saveUninitialized : 세션에 저장할 내역이 없더라도 처음부터 세션을 생성할지 설정하는 것이다.
  - express-session은 세션 관리 시 클라이언트에 쿠키를 보낸다. 이것이 세션 쿠키이다.
    - 안정하게 쿠키를 전송하려면 쿠키에 서명을 추가해야 하고, 쿠키를 서명하는 데 secret의 값이 필요하다.
    - cookie-parser의 secret과 같게 설정하는 것이 좋다.
    - 세션 쿠키의 이름은 name 옵션으로 정한다. 기본 이름은 connect.sid 이다.
    - cookie 옵션은 세션 쿠키에 대한 설정이다. maxAge, domain, path, expires, sameSite, httpOnly, secure 등 일반적인 쿠키 옵션이 모두 제공된다.
  - store 라는 옵션도 있다.
    - 현재는 메모리에 세션을 저장하도록 되어 있다.
    - 문제는 서버를 재시작하면 메모리가 초기화되어 세션이 모두 사라진다는 것이다.
    - 배포 시에는 store에 데이터베이스를 연결하여 세션을 유지하는 것이 좋다. 보통 레디스가 자주 쓰인다.

### ➕ 6.2.6 미들웨어의 특성 활용하기

- 미들웨어는 req, res, next를 매개변수로 가지는 함수로서 app.use나 app.get, app.post 등으로 장착한다.

- 특정한 주소의 요청에만 미들웨어가 실행되게 하려면 첫 번째 인수로 주소를 넣으면 된다.
- 동시에 여러 개의 미들우에어를 장착할 수도 있으며, 다음 미들웨어로 넘어가려면 next함수를 호출해야 한다.
- next 함수에 인수를 넣을 수도 있습니다.

  - route 라는 문자열을 넣으면 다음 라우터의 미들웨어로 바로 이동하고, 그 외의 인수를 넣는다면 바로 에러 처리 미들웨어로 이동한다.
  - 이때의 인수는 에러 처리 미들웨어의 err 매개변수가 된다.

- 미들웨어 간에 데이터를 전달하는 방법도 있다.

  - 세션을 사용한다면 req.session 객체에 데이터를 넣어도 되지만, 세션이 유지되는 동안에 데이터도 계속 유지된다는 단점이 있다.
  - 만약 요청이 끝날 때까지만 데이터를 유지하고 싶다면 req 객체에 데이터를 넣어두면 된다.
  - 요청이 처리되는 동안 req.data를 통해 미들웨어 간에 데이터를 공유할 수 있다.
  - 새로운 요청이 오면 req.data는 초기화된다.
  - app.set과의 차이
    - app.set은 익스프레스 전역적으로 사용되므로 사용자 개개인의 값을 넣기에는 부적절하며, 앱 전체의 설정을 공유할 때 사용하면 된다.

- 미들웨어를 사용할 때 유용한 패턴 - 미들웨어 안에 미들웨어를 넣는 방식

  ```javascript
  app.use(morgan('dev'))
  // or
  app.use((req, res, next) => {
    morgan('dev')(req, res, next)
  })
  ```

  - 위 두 방식은 같은 기능을 한다. 이 패턴이 유용한 이유는 기존 미들웨어의 기능을 확장할 수 있기 때문이다.
  - 예를 들어 조건에 따라 분기 처리를 할 수도 있다.

    ```javascript
    app.use((req, res, next) => {
      if (process.env.NODE_ENV === 'production') {
        morgan('combined')(req, res, next)
      } else {
        morgan('dev')(req, res, next)
      }
    })
    ```

### ➕ 6.2.7 multer

- 이미지, 동영상 등을 비롯한 여러 가지 파일들을 멀티파트 형식으로 업로드할 때 사용하는 미들웨어이다.

  ```javascript
  const multer = require('multer')
  const path = require('path')

  const upload = multer({
    storage: multer.diskStorage({
      destination(req, file, done) {
        done(null, 'uploads/')
      },
      filename(req, file, done) {
        const ext = path.extname(file.originalname)
        done(null, path.basename(file.originalname, ext) + Date.now() + ext)
      },
    }),
    limits: {
      fileSize: 5 * 1024 * 1024,
    },
  })
  ```

  - storage

    - 어디에(destination) 어떤 이름으로(filename) 저장할지를 넣는다.
    - req 객체에는 요청에 대한 정보, file 객체에는 업로드한 파일에 대한 정보가 있고, done 매개변수는 함수이다.
    - done 함수의 첫 번째 인수에는 에러가 있다면 에러를 넣고, 두 번째 인수에는 실제 경로나 파일 이름을 넣어주면 된다.
    - req, file의 데이터를 가공해서 done으로 넘기는 형식이다.

  - limits
    - 업로드에 제한 사항을 설정할 수 있다.

- 위에서 생성한 upload 에는 다양한 종류의 미들웨어가 들어있다.

  - 파일을 하나만 업로드 하는 경우에는 single 미들웨어를 사용한다.

    ```javascript
    app.post('/upload', upload.single('image'), (req, res) => {
      console.log(req.file, req.body)
      res.send('ok')
    })
    ```

  - 여러 파일을 업로드 하는 경우

    - HTML 에는 multiple 을 적용한다.

      ```html
      <form
        action="/upload-multiple"
        method="post"
        ,
        enctype="multipart/form-data"
      >
        <input type="file" name="many" multiple />
        <input type="text" name="title" />
        <button type="submit">업로드</button>
      </form>
      ```

    - 미들웨어는 single이 아닌 array를 사용한다.

      ```javascript
      app.post('/upload-multiple', upload.array('many'), (req, res) => {
        console.log(req.files, req.body)
        res.send('ok')
      })
      ```

  - 파일을 여러 개 업로드하지만 input 태그나 폼 데이터의 키가 다른 경우에는 fields 미들웨어를 사용한다.

    ```html
    <form action="/upload-fields" method="post" , enctype="multipart/form-data">
      <input type="file" name="image1" />
      <input type="file" name="image2" />
      <input type="text" name="title" />
      <button type="submit">업로드</button>
    </form>
    ```

    ```javascript
    app.post(
      '/upload-fields',
      upload.fields([{ name: 'image1' }, { name: 'image2' }]),
      (req, res) => {
        console.log(req.files, req.body)
        res.send('ok')
      }
    )
    ```

  - 특수한 경우지만, 파일을 업로드하지 않고도 멀티파트 형식으로 업로드하는 경우가 있다. 그럴 때는 none 미들웨어를 사용한다.

    ```javascript
    app.post('/upload-none', upload.none(), (req, res) => {
      console.log(req.body)
      res.send('ok')
    })
    ```

## 📌 6.3 Router 객체로 라우팅 분리하기

## 📌 6.4 req, res 객체 살펴보기

## 📌 6.5 템플릿 엔진 사용하기
