// @ts-check

/**
 *
 * @param {string[]} seoul
 * @returns {string}
 */
function solution(seoul) {
  return `김서방은 ${seoul.findIndex((x) => x === 'Kim')}에 있다`
}

const seoul = ['Jane', 'Kim']
console.log(solution(seoul))
