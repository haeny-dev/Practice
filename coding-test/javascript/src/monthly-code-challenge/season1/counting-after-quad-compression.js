// @ts-check

/**
 * @param {number[][]} arr
 * @param {number[]} answer
 * @param {number} x
 * @param {number} y
 * @param {number} length
 */
function countingAfterQuadCompression(arr, answer, x, y, length) {
  if (length === 1) {
    answer[arr[x][y]] += 1
    return
  }

  let sum = 0
  for (let i = x; i < x + length; i += 1) {
    for (let j = y; j < y + length; j += 1) {
      sum += arr[i][j]
    }
  }

  if (sum === 0) {
    answer[0] += 1
  } else if (sum === length * length) {
    answer[1] += 1
  } else {
    const newLength = Math.floor(length / 2)
    countingAfterQuadCompression(arr, answer, x, y, newLength)
    countingAfterQuadCompression(arr, answer, x + newLength, y, newLength)
    countingAfterQuadCompression(arr, answer, x, y + newLength, newLength)
    countingAfterQuadCompression(
      arr,
      answer,
      x + newLength,
      y + newLength,
      newLength
    )
  }
}

/**
 * @param {number[][]} arr
 * @returns {number[]}
 */
function solution(arr) {
  const answer = [0, 0]
  countingAfterQuadCompression(arr, answer, 0, 0, arr.length)
  return answer
}

/**
 * @param {number[][]} arr
 * @returns {number[]}
 */
function diffSolution(arr) {
  const quadZip = (row, col, n) => {
    if (n < 2) {
      return arr[row][col] ? [0, 1] : [1, 0]
    }
    let cnt0 = 0
    let cnt1 = 0
    n >>= 1

    for (let [i, j] of [
      [0, 0],
      [0, 1],
      [1, 0],
      [1, 1],
    ]) {
      let [zero, one] = quadZip(row + i * n, col + j * n, n)
      cnt0 += zero
      cnt1 += one
    }

    if (cnt0 === 0) return [0, 1]
    if (cnt1 === 0) return [1, 0]
    return [cnt0, cnt1]
  }
  return quadZip(0, 0, arr.length)
}

const arr = [
  [1, 1, 1, 1, 1, 1, 1, 1],
  [0, 1, 1, 1, 1, 1, 1, 1],
  [0, 0, 0, 0, 1, 1, 1, 1],
  [0, 1, 0, 0, 1, 1, 1, 1],
  [0, 0, 0, 0, 0, 0, 1, 1],
  [0, 0, 0, 0, 0, 0, 0, 1],
  [0, 0, 0, 0, 1, 0, 0, 1],
  [0, 0, 0, 0, 1, 1, 1, 1],
]

console.log(solution(arr))
console.log(diffSolution(arr))
