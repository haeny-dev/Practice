// @ts-check

/**
 * @param {number[]} numbers
 * @returns
 */
function solution(numbers) {
  return numbers.reduce((pre, cur) => pre - cur, 45)
}

const numbers = [1, 2, 3, 4, 6, 7, 8, 0]
console.log(solution(numbers))
