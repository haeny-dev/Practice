// @ts-check

const express = require('express')

const bodyParser = require('body-parser')

const fs = require('fs')

const app = express()
app.use(bodyParser.json())

const PORT = 4000

const userRouter = express.Router()

/**
 * /users 와 같은 prefix 가 반복되는 경우
 * - 라우터를 활용할 수 있다
 * - 라우터는 미니프로그램이라고 생각하면 되며, 라우터 또한 미들웨어다
 */
userRouter.get('/', (req, res) => {
  res.send('User list')
})

const USERS = {
  15: {
    nickname: 'foo',
  },
}

userRouter.param('id', (req, res, next, value) => {
  console.log(`id parameter`, value)
  // @ts-ignore
  req.user = USERS[value]
  next()
})

userRouter.get('/:id', (req, res) => {
  console.log('userRouter get ID')
  // @ts-ignore
  res.send(req.user)
})

userRouter.post('/', (req, res) => {
  // Register User
  res.send('User Registered')
})

userRouter.post('/:id/nickname', (req, res) => {
  // req.body => {"nickname": "bar"}
  // @ts-ignore
  const { user } = req
  const { nickname } = req.body

  user.nickname = nickname
  res.send(`User nickname updated: ${user}`)
})

app.use('/users', userRouter)

/**
 * Path
 * - Path
 * - Path pattern
 * - Path regex
 * - Path array
 */
app.post('/ab?cd', (req, res) => {
  res.send('Root - POST')
})

app.listen(PORT, () => {
  console.log(`The Express server is listening at port : ${PORT}`)
})

/* Ch09. Express로 웹 사이트 만들기 > 02.미들웨어 개념 이해하고 만들어보기
app.use('/', async (req, res, next) => {
  console.log('Middleware 1')

  const fileContent = await fs.promises.readFile('.prettierrc')

  const requestedAt = new Date()
  // @ts-ignore
  req.requestedAt = requestedAt
  // @ts-ignore
  req.fileContent = fileContent
  next()
})

// 수많은 Middleware ... 

app.use((req, res) => {
  console.log('Middleware 2')
  // @ts-ignore
  res.send(`Requested at ${req.requestedAt}, ${req.fileContent}`)
})
*/
