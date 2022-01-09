// @ts-check

/**
 * @param {string} number
 * @param {number} k
 * @returns {string}
 */
function solution(number, k) {
  let answer = ''
  let index = 0
  let max = 0
  for (let i = 0; i < number.length - k; i += 1) {
    max = 0
    for (let j = index; j < k + 1 + i; j += 1) {
      if (+number.charAt(j) > max) {
        max = +number.charAt(j)
        index = j + 1
      }
    }
    answer += max
  }

  return answer
}

function diffSolution(number, k) {
  const answer = []
  let head = 0
  let del = k

  answer.push(number[head++])
  while (head < number.length) {
    if (del && answer[answer.length - 1] < number[head]) {
      answer.pop()
      del--
      continue
    }
    answer.push(number[head++])
  }

  return answer.slice(0, number.length - k).join('')
}

const number = '4177252841'
const k = 4

console.log(solution(number, k))
console.log(diffSolution(number, k))

/**
 * number : 4177252841
 * k : 4
 *
 * answer length: number.length - k
 *
 * 1. 첫번째 자리
 *    - [41772][52841]
 *    - [41772] 중 가장 큰 숫자 : 7
 *    - [41] 제거
 *    - k -= 2
 * 2. 두번째 자리
 *    - [7][725][2841]
 *    - [725] 중 가장 큰 숫자 : 7
 *    - 제거 X
 * 3. 세번째 자리
 *    - [77][252][841]
 *    - [252] 중 가장 큰 숫자 : 5
 *    - [2] 제거
 *    - k -= 1
 * 4. 네번째 자리
 *    - [775][28][41]
 *    - [28] 중 가장 큰 숫자 : 8
 *    - [2] 제거
 *    - k -= 1
 * 5. k === 0
 *    - [775841]
 */
