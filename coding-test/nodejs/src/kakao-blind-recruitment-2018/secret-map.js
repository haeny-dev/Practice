// @ts-check

/**
 *
 * @param {number} n
 * @param {number[]} arr1
 * @param {number[]} arr2
 * @returns
 */
function solution(n, arr1, arr2) {
  return arr1.map((v, i) =>
    (v | arr2[i])
      .toString(2)
      .padStart(n, '0')
      .replace(/0/g, ' ')
      .replace(/1/g, '#')
  )
}

const n = 5
const arr1 = [9, 20, 28, 18, 11]
const arr2 = [30, 1, 21, 17, 28]

console.log(solution(n, arr1, arr2))
