// @ts-check

/**
 *
 * @param {number} n
 * @returns {number}
 */
function solution(n) {
  return n
    .toString()
    .split('')
    .map((x) => +x)
    .reduce((a, b) => a + b, 0)
}

console.log(solution(123))
