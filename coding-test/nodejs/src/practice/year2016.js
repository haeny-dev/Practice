// @ts-check

/**
 *
 * @param {number} a
 * @param {number} b
 * @returns {string}
 */
function solution(a, b) {
  const days = ['SUN', 'MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT']
  return days[new Date(2016, a - 1, b).getDay()]
}

const a = 5
const b = 24

console.log(solution(a, b))
