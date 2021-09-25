// @ts-check

/**
 * @param {number[]} arr
 * @returns {number}
 */
function solution(arr) {
  let answer = 0

  const max = Math.max(...arr)
  let multiple = 1

  while (answer === 0) {
    let i
    for (i = 0; i < arr.length; i += 1) {
      if ((max * multiple) % arr[i] !== 0) {
        break
      }
    }

    if (i === arr.length) {
      answer = max * multiple
    }

    multiple += 1
  }

  return answer
}

function gcd(a, b) {
  return a % b ? gcd(b, a % b) : b
}

function nlcm(arr) {
  return arr.reduce((a, b) => (a * b) / gcd(a, b))
}

function diffSolution(arr) {
  return nlcm(arr)
}

const arr = [2, 6, 8, 14]
console.log(solution(arr))
console.log(diffSolution(arr))
