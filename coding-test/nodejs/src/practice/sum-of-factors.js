// @ts-check

/**
 *
 * @param {number} n
 */
function solution(n) {
  let answer = 0

  for (let i = 1; i <= Math.floor(Math.sqrt(n)); i += 1) {
    if (n % i === 0) {
      if (i === Math.sqrt(n)) {
        answer += i
      } else {
        answer += i
        answer += n / i
      }
    }
  }

  return answer
}

console.log(solution(12))
