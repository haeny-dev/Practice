// @ts-check

/**
 * @param {number[]} absolutes
 * @param {boolean[]} signs
 */
function solution(absolutes, signs) {
  return absolutes.reduce((pre, cur, i) => pre + cur * (signs[i] ? 1 : -1), 0)
}

const absolutes = [4, 7, 12]
const signs = [true, false, true]

console.log(solution(absolutes, signs))
