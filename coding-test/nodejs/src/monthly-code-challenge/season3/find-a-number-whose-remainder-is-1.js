// @ts-check

/**
 * @param {number} n
 * @returns
 */
function solution(n) {
  for (let i = 1; i < n; i += 1) {
    if (n % i === 1) {
      return i
    }
  }
}

const n = 12
console.log(solution(n))
