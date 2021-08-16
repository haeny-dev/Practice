// @ts-check

/**
 * @param {string} s
 * @returns {boolean}
 */
function solution(s) {
  let flag = 0
  s = s.toLowerCase()
  for (let i = 0; i < s.length; i += 1) {
    if (s.charAt(i) === 'p') {
      flag += 1
    } else if (s.charAt(i) === 'y') {
      flag -= 1
    }
  }

  return flag === 0
}

function diffSolution(s) {
  return s.toUpperCase().split('P').length === s.toUpperCase().split('Y').length
}

function diffSolution2(s) {
  return s.match(/p/gi).length === s.match(/y/gi).length
}

const s = 'pPoooyY'
console.log(solution(s))
console.log(diffSolution(s))
console.log(diffSolution2(s))
