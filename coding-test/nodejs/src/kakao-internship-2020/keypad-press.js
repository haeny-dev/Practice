// @ts-check

/**
 * @param {number[]} numbers
 * @param {string} hand
 * @returns {string}
 */
function solution(numbers, hand) {
  let answer = ''

  const rows = [0, 3, 3, 3, 2, 2, 2, 1, 1, 1]
  const leftHand = [0, 0]
  const rightHand = [0, 2]

  for (let i = 0; i < numbers.length; i += 1) {
    const number = numbers[i]

    if (number === 1 || number === 4 || number === 7) {
      answer += 'L'
      leftHand[0] = rows[number]
      leftHand[1] = 0
    }

    if (number === 3 || number === 6 || number === 9) {
      answer += 'R'
      rightHand[0] = rows[number]
      rightHand[1] = 2
    }

    if (number === 0 || number === 2 || number === 5 || number === 8) {
      const left =
        Math.abs(leftHand[0] - rows[number]) + Math.abs(leftHand[1] - 1)
      const right =
        Math.abs(rightHand[0] - rows[number]) + Math.abs(rightHand[1] - 1)

      if (left < right || (left === right && hand === 'left')) {
        answer += 'L'
        leftHand[0] = rows[number]
        leftHand[1] = 1
      } else if (left > right || (left === right && hand === 'right')) {
        answer += 'R'
        rightHand[0] = rows[number]
        rightHand[1] = 1
      }
    }
  }

  return answer
}

function diffSolution(numbers, hand) {
  hand = hand[0] === 'r' ? 'R' : 'L'
  const position = [1, 4, 4, 4, 3, 3, 3, 2, 2, 2]
  const h = {
    L: [1, 1],
    R: [1, 1],
  }
  return numbers
    .map((x) => {
      if (/[147]/.test(x)) {
        h.L = [position[x], 1]
        return 'L'
      }

      if (/[369]/.test(x)) {
        h.R = [position[x], 1]
        return 'R'
      }

      const distL = Math.abs(position[x] - h.L[0]) + h.L[1]
      const distR = Math.abs(position[x] - h.R[0]) + h.R[1]
      if (distL === distR) {
        h[hand] = [position[x], 0]
        return hand
      }

      if (distL < distR) {
        h.L = [position[x], 0]
        return 'L'
      }

      h.R = [position[x], 0]
      return 'R'
    })
    .join('')
}

const numbers = [1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]
const hand = 'right'
const answer = 'LRLLLRLLRRL'

console.log(answer === solution(numbers, hand))
console.log(answer === diffSolution(numbers, hand))
