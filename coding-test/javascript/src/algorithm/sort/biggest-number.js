// @ts-check

/**
 * @param {number[]} numbers
 * @returns {string}
 */
function solution(numbers) {
  const answer = numbers.sort((a, b) => {
    const n1 = +(a.toString() + b.toString())
    const n2 = +(b.toString() + a.toString())
    return n2 - n1
  })

  return answer[0] === 0 ? '0' : answer.join('')
}

const numbers = [6, 10, 2]

console.log(solution(numbers))
