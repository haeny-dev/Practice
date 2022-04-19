// @ts-check

/**
 *
 * @param {string} s
 * @returns {boolean}
 */
function solution(s) {
  if (!(s.length === 4 || s.length === 6)) {
    return false
  }

  return s.replace(/\d/g, '').length === 0
}

function diffSolution(s) {
  return /^\d{6}$|^\d{4}$/.test(s)
}

console.log(solution('a234'))
console.log(solution('1234'))
console.log(diffSolution('a234'))
console.log(diffSolution('1234'))
