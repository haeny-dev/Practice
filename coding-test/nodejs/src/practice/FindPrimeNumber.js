// @ts-check

/**
 * @param {number} n
 * @returns {number}
 */
function solution(n) {
  let answer = 0

  let isNotPrimes = []
  for (let i = 2; i <= n; i += 1) {
    isNotPrimes[i] = 0
  }

  for (let i = 2; i <= n; i += 1) {
    if (isNotPrimes[i]) {
      continue
    }

    answer += 1

    for (let j = i * 2; j <= n; j += i) {
      isNotPrimes[j] = 1
    }
  }

  return answer
}

console.log(solution(10))
