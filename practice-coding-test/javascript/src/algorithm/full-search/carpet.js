// @ts-check

/**
 * @param {number} brown
 * @param {number} yellow
 * @returns {number[]}
 */
function solution(brown, yellow) {
  let height = 1
  let width = (brown + yellow) / height

  for (; height <= width; height += 1, width = (brown + yellow) / height) {
    if (Math.floor(width) !== width) {
      continue
    }

    const b = width * 2 + (height - 2) * 2
    if (b === brown) {
      return [width, height]
    }
  }
}

const brown = 10
const yellow = 2

console.log(solution(brown, yellow))
