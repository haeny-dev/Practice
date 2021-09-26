// @ts-check

/**
 * @param {string} s
 * @returns {string}
 */
function solution(s) {
  return s
    .split(' ')
    .map((x) => x.slice(0, 1).toUpperCase() + x.slice(1).toLowerCase())
    .join(' ')
}

const ss = ['3people unFollowed me', 'for the last week']
ss.forEach((s) => {
  console.log(solution(s))
})
