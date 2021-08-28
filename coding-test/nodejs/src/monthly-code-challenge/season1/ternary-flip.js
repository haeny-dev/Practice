// @ts-check

/**
 * @param {number} n
 * @returns {number}
 */
function solution(n) {
  return Number.parseInt(n.toString(3).split('').reverse().join(''), 3)
}

const n = 45
console.log(solution(n))
