// @ts-check

/**
 * @param {number} n
 * @returns {number[]}
 */
function solution(n) {
  const matrix = Array.from(Array(n), () => new Array(n))

  let num = 1
  let x = -1
  let y = 0

  for (let i = 0; i < n; i += 1) {
    for (let j = i; j < n; j += 1) {
      if (i % 3 === 0) {
        x += 1
      } else if (i % 3 === 1) {
        y += 1
      } else if (i % 3 === 2) {
        x -= 1
        y -= 1
      }

      matrix[x][y] = num
      num += 1
    }
  }

  return matrix.flat().filter((x) => x !== 0)
}

/**
 * n = 4
 * 1
 * 2   9
 * 3  10  8
 * 4   5  6   7
 */

const n = 4
console.log(solution(n))
