// @ts-check

/**
 *
 * @param {number[][]} board
 * @param {number[]} moves
 */
function solution(board, moves) {
  let answer = 0

  const moved = []

  moves.forEach((move) => {
    for (let i = 0; i < board.length; i += 1) {
      const pick = board[i][move - 1]
      if (pick !== 0) {
        if (moved.length < 1) {
          moved.push(pick)
        } else {
          const top = moved.pop()

          if (top === pick) {
            answer += 2
          } else {
            moved.push(top, pick)
          }
        }

        board[i][move - 1] = 0
        break
      }
    }
  })

  return answer
}

const board = [
  [0, 0, 0, 0, 0],
  [0, 0, 1, 0, 3],
  [0, 2, 5, 0, 1],
  [4, 2, 4, 4, 2],
  [3, 5, 1, 3, 1],
]
const moves = [1, 5, 3, 5, 1, 2, 1, 4]
console.log(solution(board, moves))
