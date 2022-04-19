// @ts-check

/**
 * @param {string[]} strings
 * @param {number} n
 * @returns {string[]}
 */
function solution(strings, n) {
  return strings.sort().sort((a, b) => a.charCodeAt(n) - b.charCodeAt(n))
}

const strings = ['abce', 'abcd', 'cdx']
const n = 2

console.log(solution(strings, n))
