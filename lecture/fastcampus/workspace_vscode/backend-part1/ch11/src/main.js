// @ts-check

// Template engine: Pug
// CSS framework: Tailwind CSS

const Koa = require('koa')
const Pug = require('koa-pug')
const path = require('path')

const app = new Koa()

// @ts-ignore
// eslint-disable-next-line no-new
new Pug({
  viewPath: path.resolve(__dirname, './views'),
  app,
})

app.use(async (ctx) => {
  await ctx.render('main')
})

app.listen(4000)
