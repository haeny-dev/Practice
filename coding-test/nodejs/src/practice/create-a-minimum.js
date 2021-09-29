// @ts-check

/**
 * @param {number[]} A
 * @param {number[]} B
 * @returns {number}
 */
function solution(A, B) {
  A = A.sort((a, b) => a - b)
  B = B.sort((a, b) => b - a)

  return A.reduce((sum, a, i) => sum + a * B[i], 0)
}

const A = [1, 4, 2]
const B = [5, 4, 4]

console.log(solution(A, B))
