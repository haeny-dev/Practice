// @ts-check

const express = require('express')
const fs = require('fs')

const app = express()

const PORT = 4000

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

/* 수많은 Middleware ... */

app.use((req, res) => {
  console.log('Middleware 2')
  // @ts-ignore
  res.send(`Requested at ${req.requestedAt}, ${req.fileContent}`)
})

app.listen(PORT, () => {
  console.log(`The Express server is listening at port : ${PORT}`)
})
