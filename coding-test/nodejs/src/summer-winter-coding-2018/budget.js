// @ts-check

/**
 * @param {number[]} d
 * @param {number} budget
 * @returns
 */
function solution(d, budget) {
  let answer = 0
  d = d.sort((a, b) => a - b)
  for (let i = 0; i < d.length; i += 1) {
    if (budget >= d[i]) {
      answer += 1
      budget -= d[i]
    }
  }

  return answer
}

const d = [1, 3, 2, 5, 4]
const budget = 9
console.log(solution(d, budget))
