// @ts-check

/**
 * @param {string} s
 * @returns {string}
 */
function solution(s) {
  return s
    .split('')
    .sort((a, b) => b.charCodeAt(0) - a.charCodeAt(0))
    .join('')
}

const s = 'Zbcdefg'
console.log(solution(s))
