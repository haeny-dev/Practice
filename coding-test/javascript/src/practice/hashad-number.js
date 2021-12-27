// @ts-check

/**
 * @param {number} x
 * @returns {boolean}
 */
function solution(x) {
  let mok = Math.floor(x / 10)
  let nmg = x % 10

  while (mok > 0) {
    nmg += mok % 10
    mok = Math.floor(mok / 10)
  }

  return x % nmg === 0
}

function diffSolution(x) {
  return !(
    x %
    x
      .toString()
      .split('')
      .reduce((a, b) => +b + +a)
  )
}

console.log(solution(12))
console.log(diffSolution(12))
