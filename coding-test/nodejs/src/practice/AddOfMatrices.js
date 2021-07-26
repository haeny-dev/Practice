function solution(arr1, arr2) {
  const answer = [[]]

  for (let i = 0; i < arr1.length; i++) {
    answer[i] = []

    for (let j = 0; j < arr1[0].length; j++) {
      answer[i][j] = arr1[i][j] + arr2[i][j]
    }
  }

  return answer
}

function diffSolution(arr1, arr2) {
  return arr1.map((arr, i) => arr.map((x, j) => x + arr2[i][j]))
}

const arr1 = [
  [1, 2],
  [2, 3],
]
const arr2 = [
  [3, 4],
  [5, 6],
]
console.log(solution(arr1, arr2))
console.log(diffSolution(arr1, arr2))
