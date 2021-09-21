// @ts-check

/**
 *
 * @param {string} s
 * @returns {number}
 */
function solution(s) {
  return +s
    .replace(/zero/g, '0')
    .replace(/one/g, '1')
    .replace(/two/g, '2')
    .replace(/three/g, '3')
    .replace(/four/g, '4')
    .replace(/five/g, '5')
    .replace(/six/g, '6')
    .replace(/seven/g, '7')
    .replace(/eight/g, '8')
    .replace(/nine/g, '9')
}

function diffSolution(s) {
  const numbers = [
    'zero',
    'one',
    'two',
    'three',
    'four',
    'five',
    'six',
    'seven',
    'eight',
    'nine',
  ]
  return +numbers.reduce((pre, num, i) => (pre = pre.split(num).join(i)), s)
}

const s = 'one4seveneight'
console.log(solution(s))
console.log(diffSolution)
