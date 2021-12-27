// @ts-check

/**
 *
 * @param {number[]} array
 * @param {number[][]} commands
 * @returns {number[]}
 */
function solution(array, commands) {
  return commands.map(
    (arr) => array.slice(arr[0] - 1, arr[1]).sort((a, b) => a - b)[arr[2] - 1]
  )
}

const array = [1, 5, 2, 6, 3, 7, 4]
const commands = [
  [2, 5, 3],
  [4, 4, 1],
  [1, 7, 3],
]

console.log(solution(array, commands))
