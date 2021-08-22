// @ts-check

/**
 * @param {number[]} arr
 * @returns {number[]}
 */
function solution(arr) {
  if (arr.length === 1) return [-1]
  arr.splice(Math.min(...arr), 1)
  return arr
}

const arr = [4, 3, 2, 1]
const arr2 = [10]

console.log(solution(arr))
console.log(solution(arr2))
