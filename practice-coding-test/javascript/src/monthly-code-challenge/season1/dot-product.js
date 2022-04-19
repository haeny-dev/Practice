// @ts-check

/**
 *
 * @param {number[]} a
 * @param {number[]} b
 * @returns
 */
function solution(a, b) {
  return a.reduce((pre, cur, i) => pre + cur * b[i], 0)
}

const a = [1, 2, 3, 4]
const b = [-3, -1, 0, 2]

console.log(solution(a, b))
