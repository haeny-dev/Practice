// @ts-check

/**
 * @param {number[]} arr
 * @returns {number[]}
 */
function solution(arr) {
  const answer = []
  let flag = -1
  for (let i = 0; i < arr.length; i += 1) {
    if (flag !== arr[i]) {
      answer.push(arr[i])
      flag = arr[i]
    }
  }

  return answer
}

const diffSolution = (arr) =>
  arr.filter((value, index) => value !== arr[--index])

const arr = [1, 1, 3, 3, 0, 1, 1]
console.log(solution(arr))
console.log(diffSolution(arr))
