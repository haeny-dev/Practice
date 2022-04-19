// @ts-check

/**
 * @param {number[]} arr
 * @param {number} divisor
 * @returns {number[]}
 */
function solution(arr, divisor) {
  arr = arr.filter((x) => x % divisor === 0).sort((a, b) => +a - +b)
  return arr.length ? arr : [-1]
}

const arr = [5, 9, 7, 10]
// const arr = [2, 36, 1, 3]
const divisor = 5

console.log(solution(arr, divisor))
