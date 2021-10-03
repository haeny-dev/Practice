// @ts-check

/**
 * @param {string} s
 * @returns {boolean}
 */
function solution(s) {
  let flag = 0
  for (let i = 0; i < s.length; i += 1) {
    if (s.charAt(i) === '(') {
      flag += 1
    } else if (s.charAt(i) === ')') {
      flag -= 1
    }

    if (flag < 0) {
      return false
    }
  }

  return flag === 0
}

const s = '(())()'
console.log(solution(s))
