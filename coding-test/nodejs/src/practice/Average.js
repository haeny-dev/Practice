// @ts-check

/**
 * @param { number[] } arr
 */
function solution(arr) {
  return arr.reduce((a, b) => a + b) / arr.length
}

const arr = [1, 2, 3, 4]
console.log(solution(arr))
