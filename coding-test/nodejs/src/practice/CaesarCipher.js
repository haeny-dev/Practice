// @ts-check

/**
 *
 * @param {string} s
 * @param {number} n
 * @returns {string}
 */
function solution(s, n) {
  let answer = ''

  for (let i = 0; i < s.length; i += 1) {
    const charCode = s.charCodeAt(i)
    let shiftCharCode = charCode + n

    if (charCode >= 65 && charCode < 91) {
      shiftCharCode = ((shiftCharCode - 65) % 26) + 65
      answer += String.fromCharCode(shiftCharCode)
    } else if (charCode >= 97 && charCode < 123) {
      shiftCharCode = ((shiftCharCode - 97) % 26) + 97
      answer += String.fromCharCode(shiftCharCode)
    } else {
      answer += s.charAt(i)
    }
  }

  return answer
}

const s = 'AB'
const n = 1
console.log(solution(s, n))
