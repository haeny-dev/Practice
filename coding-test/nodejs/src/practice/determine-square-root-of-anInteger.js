// @ts-check

/**
 * @param {number} n
 * @returns {number}
 */
function solution(n) {
  const sqrtN = Math.sqrt(n)
  return Math.floor(sqrtN) === sqrtN ? Math.pow(sqrtN + 1, 2) : -1
}

const n = 121
console.log(solution(n))
