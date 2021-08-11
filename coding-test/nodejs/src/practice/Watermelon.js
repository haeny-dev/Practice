// @ts-check

/**
 * @param {number} n
 * @returns {string}
 */
function solution(n) {
  return '수박'.repeat(Math.round(n / 2)).slice(0, n)
}

console.log(solution(3))
