// @ts-check

/**
 *
 * @param {string} s
 * @returns {string}
 */
function solution(s) {
  let answer = ''
  let idx = 1
  for (let i = 0; i < s.length; i += 1) {
    const charat = s.charAt(i)
    if (charat === ' ') {
      answer += charat
      idx = 1
    } else {
      answer += idx % 2 === 0 ? charat.toLowerCase() : charat.toUpperCase()
      idx += 1
    }
  }

  return answer
}

const s = 'try hello world'
console.log(solution(s))
