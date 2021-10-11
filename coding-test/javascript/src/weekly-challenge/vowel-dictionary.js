// @ts-check

/**
 * @param {string} word
 * @returns {number}
 */
function solution(word) {
  let answer = 0
  let cnt = 3905
  for (let i = 0; i < word.length; i += 1) {
    answer += 'AEIOU'.indexOf(word.charAt(i)) * Math.floor((cnt /= 5)) + 1
  }

  return answer
}

/**
 * @param {string} word
 * @returns {number}
 */
function diffSolution(word) {
  return word
    .split('')
    .reduce(
      (cnt, c, i) =>
        cnt + 'AEIOU'.indexOf(c) * Math.floor(3905 / Math.pow(5, i + 1)) + 1,
      0
    )
}

const word = 'AAAAE'
console.log(solution(word))
console.log(diffSolution(word))
