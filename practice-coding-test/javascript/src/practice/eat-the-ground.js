// @ts-check

/**
 * @param {number[][]} land
 * @returns {number}
 */
function solution(land) {
  return Math.max(
    ...land.reduce(
      (a, c) => [
        c[0] + Math.max(a[1], a[2], a[3]),
        c[1] + Math.max(a[0], a[2], a[3]),
        c[2] + Math.max(a[0], a[1], a[3]),
        c[3] + Math.max(a[0], a[1], a[2]),
      ],
      [0, 0, 0, 0]
    )
  )
}

const land = [
  [1, 2, 3, 5],
  [5, 6, 7, 8],
  [4, 3, 2, 1],
]

console.log(solution(land))
