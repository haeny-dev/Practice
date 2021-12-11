// @ts-check

const { rejects } = require('assert')
const https = require('https')

/**
 * @typedef Character
 * @property {string} slug
 */

/**
 * @typedef House
 * @property {string} slug
 * @property {Character[]} members
 */

const GOTAPI_PREFIX = 'https://game-of-thrones-quotes.herokuapp.com/v1'

/**
 * @param {string} url
 * @returns {*}
 */
async function getHttpsJson(url) {
  return new Promise((resolve, reject) => {
    https.get(url, (res) => {
      let jsonStr = ''
      res.setEncoding('utf-8')
      res.on('data', (data) => {
        jsonStr += data
      })
      res.on('end', () => {
        try {
          const parsed = JSON.parse(jsonStr)
          resolve(parsed)
        } catch {
          reject(
            new Error('The server response was not a valid JSON document.')
          )
        }
      })
    })
  })
}

/**
 * @returns {Promise<House[]>}
 */
async function getHouses() {
  return getHttpsJson(`${GOTAPI_PREFIX}/houses`)
}

/**
 * 
 * @param {string} quote 
 * @returns {string}
 */
function sanitizeQuote(quote){
  return quote.replace(/[^a-zA-Z0-9., ]/g, '')
}

/**
 *
 * @param {string} slug
 * @returns {Promise<string>}
 */
async function getMergedQuotesOfCharacter(slug) {
  const character = await getHttpsJson(`${GOTAPI_PREFIX}/character/${slug}`)
  return sanitizeQuote(character[0].quotes.join(' '))

async function main() {
  const houses = await getHouses()
  houses.forEach((house) => {
    house.members.forEach((member) => {
      getMergedQuotesOfCharacter(member.slug).then((quotes) =>
        console.log(house.slug, member.slug, quotes)
      )
    })
  })
}

main()
