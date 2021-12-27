// @ts-check

/**
 * @param {number[][]} arr1
 * @param {number[][]} arr2
 * @returns {number[][]}
 */
function solution(arr1, arr2) {
  const answer = []

  for (let i = 0; i < arr1.length; i += 1) {
    const row = []
    for (let j = 0; j < arr2[0].length; j += 1) {
      let sum = 0
      for (let k = 0; k < arr1[0].length; k += 1) {
        sum += arr1[i][k] * arr2[k][j]
      }
      row.push(sum)
    }
    answer.push(row)
  }

  return answer
}
/**
 * @param {number[][]} arr1
 * @param {number[][]} arr2
 * @returns {number[][]}
 */
function diffSolution(arr1, arr2) {
  return arr1.map((row) =>
    arr2[0].map((_, col) =>
      row.reduce((sum, v, i) => sum + v * arr2[i][col], 0)
    )
  )
}

// 3 X 2
const arr1 = [
  [1, 4],
  [3, 2],
  [4, 1],
]

// 2 X 2
const arr2 = [
  [3, 3],
  [3, 3],
]

console.log(solution(arr1, arr2))
console.log(diffSolution(arr1, arr2))
