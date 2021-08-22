// @ts-check

/**
 *
 * @param {number} n
 * @returns {number[]}
 */
function solution(n) {
  return n
    .toString()
    .split('')
    .reverse()
    .map((x) => +x)
}

function diffSolution(n) {
  const arr = []
  do {
    arr.push(n % 10)
    n = Math.floor(n / 10)
  } while (n > 0)

  return arr
}

console.log(solution(12345))
console.log(diffSolution(12345))
