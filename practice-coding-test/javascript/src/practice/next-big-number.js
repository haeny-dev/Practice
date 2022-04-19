// @ts-check

/**
 * @param {number} n
 * @returns {number}
 */
function solution(n) {
  const nOneCount = n.toString(2).match(/1/g).length
  while (true) {
    if ((++n).toString(2).match(/1/g).length === nOneCount) {
      return n
    }
  }
}

const n = 78

console.log(solution(n))
