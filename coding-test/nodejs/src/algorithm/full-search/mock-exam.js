// @ts-check

/**
 * @param {number[]} answers
 * @returns {number[]}
 */
function solution(answers) {
  const answer = []

  const students = [
    [1, 2, 3, 4, 5],
    [2, 1, 2, 3, 2, 4, 2, 5],
    [3, 3, 1, 1, 2, 2, 4, 4, 5, 5],
  ]

  const scores = [0, 0, 0].map(
    (v, i) =>
      answers.filter((x, j) => x === students[i][j % students[i].length]).length
  )

  const max = Math.max(...scores)

  scores.forEach((v, i) => {
    if (max === v) {
      answer.push(i + 1)
    }
  })

  return answer
}

const answers = [1, 3, 2, 4, 2]
console.log(solution(answers))
