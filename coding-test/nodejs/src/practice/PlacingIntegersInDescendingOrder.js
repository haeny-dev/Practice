// @ts-check

/**
 * @param {number} n
 * @returns {number}
 */
function solution(n) {
  return +n
    .toString()
    .split('')
    .sort((a, b) => b - a)
    .join('')
}

console.log(solution(118372))
