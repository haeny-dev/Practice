// @ts-check

/**
 * @param {number[][]} sizes
 * @returns
 */
function solution(sizes) {
  let maxLength = 0
  let minLength = 0

  for (let i = 0; i < sizes.length; i += 1) {
    const max = Math.max(...sizes[i])
    const min = Math.min(...sizes[i])

    if (max > maxLength) {
      maxLength = max
    }

    if (min > minLength) {
      minLength = min
    }
  }

  return maxLength * minLength
}

function diffSolution(sizes) {
  const [hor, ver] = sizes.reduce(
    ([h, v], [a, b]) => [
      Math.max(h, Math.max(a, b)),
      Math.max(v, Math.min(a, b)),
    ],
    [0, 0]
  )
  return hor * ver
}

const sizes = [
  [60, 50],
  [30, 70],
  [60, 30],
  [80, 40],
]
console.log(solution(sizes))
console.log(diffSolution(sizes))
