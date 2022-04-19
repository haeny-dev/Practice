// @ts-check

/**
 * @param {number} left
 * @param {number} right
 * @returns {number}
 */
function solution(left, right) {
  let answer = 0

  for (let i = left; i <= right; i += 1) {
    let cnt = 0

    for (let j = 1; j <= i; j += 1) {
      if (i % j === 0) {
        cnt += 1
      }
    }

    if (cnt % 2 === 0) {
      answer += i
    } else {
      answer -= i
    }
  }

  return answer
}

function diffSolution(left, right) {
  let answer = 0
  for (let i = left; i <= right; i += 1) {
    if (Number.isInteger(Math.sqrt(i))) {
      answer -= i
    } else {
      answer += i
    }
  }

  return answer
}

const left = 13
const right = 17

console.log(solution(left, right))
console.log(diffSolution(left, right))
