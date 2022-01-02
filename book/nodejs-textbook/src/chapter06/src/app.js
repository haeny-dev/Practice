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
