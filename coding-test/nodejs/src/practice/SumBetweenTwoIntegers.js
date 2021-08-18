// @ts-check

/**
 *
 * @param {number} a
 * @param {number} b
 * @returns {number}
 */
function solution(a, b) {
  if (a > b) {
    let temp = a
    a = b
    b = temp
  }

  let answer = 0
  for (let i = a; i <= b; i += 1) {
    answer += i
  }

  return answer
}

function diffSolution(a, b) {
  return ((a + b) * (Math.abs(b - a) + 1)) / 2
}

const a = 3
const b = 5

console.log(solution(a, b))
console.log(diffSolution(a, b))
