// @ts-check

function firstValue(n, N) {
  return ((2 * n) / N - N + 1) / 2
}

/**
 * @param {number} n
 * @returns {number}
 */
function solution(n) {
  let N = 1
  let answer = 0
  let value = firstValue(n, N)
  while (value > 0) {
    if (value === Math.floor(value)) {
      answer += 1
    }
    value = firstValue(n, (N += 1))
  }

  return answer
}

const n = 15
console.log(solution(n))
