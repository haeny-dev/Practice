// @ts-check

/**
 * @param {string} phone_number
 */
function solution(phone_number) {
  return phone_number.slice(-4).padStart(phone_number.length, '*')
}

function diffSolution(phone_number) {
  return phone_number.replace(/\d(?=\d{4})/g, '*')
}

console.log(solution('01033334444'))
console.log(diffSolution('01033334444'))
