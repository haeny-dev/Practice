// @ts-check

/**
 *
 * @param {number} n
 * @param {number[]} lost
 * @param {number[]} reserve
 * @returns {number}
 */
function solution(n, lost, reserve) {
  let answer = 0

  const students = new Array(n)
  students.fill(1)

  for (let i = 0; i < lost.length; i += 1) {
    students[lost[i] - 1] -= 1
  }

  for (let i = 0; i < reserve.length; i += 1) {
    students[reserve[i] - 1] += 1
  }

  for (let i = 0; i < students.length; i += 1) {
    if (students[i] < 1) {
      if (i > 0 && students[i - 1] > 1) {
        students[i - 1] -= 1
        students[i] += 1
        answer += 1
        continue
      }

      if (i < students.length - 1 && students[i + 1] > 1) {
        students[i + 1] -= 1
        students[i] += 1
        answer += 1
        continue
      }
    } else {
      answer += 1
    }
  }

  return answer
}

const n = 5
const lost = [2, 4]
const reserve = [3]

console.log(solution(n, lost, reserve))
