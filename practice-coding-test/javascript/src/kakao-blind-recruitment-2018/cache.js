// @ts-check

/**
 * @param {number} cacheSize
 * @param {string[]} cities
 * @returns {number}
 */
function solution(cacheSize, cities) {
  const cache = []
  return cacheSize === 0
    ? 5 * cities.length
    : cities.reduce((time, city) => {
        const lowerCity = city.toLowerCase()
        const index = cache.indexOf(lowerCity)
        let hit = true
        if (index === -1) {
          hit = false
          if (cache.length >= cacheSize) {
            cache.splice(0, 1)
          }
        } else {
          cache.splice(index, 1)
        }

        cache.push(lowerCity)
        return hit ? time + 1 : time + 5
      }, 0)
}

const cacheSize = 3
const cities = [
  'Jeju',
  'Pangyo',
  'Seoul',
  'NewYork',
  'LA',
  'Jeju',
  'Pangyo',
  'Seoul',
  'NewYork',
  'LA',
]

console.log(solution(cacheSize, cities))
