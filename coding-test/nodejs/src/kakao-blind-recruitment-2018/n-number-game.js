// @ts-check

/**
 * @param {number} n
 * @param {number} t
 * @param {number} m
 * @param {number} p
 * @returns {string}
 */
function solution(n, t, m, p) {
  let answer = ''
  let str = ''
  let number = 0
  for (let i = p - 1; i < m * t; i += m) {
    while (str.length <= i) {
      str += number.toString(n).toUpperCase()
      number += 1
    }

    answer += str.charAt(i)
  }

  return answer
}

const n = 16,
  t = 16,
  m = 2,
  p = 1

console.log(solution(n, t, m, p))
