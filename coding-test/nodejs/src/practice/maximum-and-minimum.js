// @ts-check

/**
 * @param {string} s
 * @returns {string}
 */
function solution(s) {
  const arr = s.split(' ').map((x) => parseInt(x, 10))
  return `${Math.min(...arr)} ${Math.max(...arr)}`
}

const s = '1 2 3 4'
console.log(solution(s))
