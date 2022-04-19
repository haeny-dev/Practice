// @ts-check

/**
 * @param {number[][]} board
 * @returns {number}
 */
function solution(board) {
  let answer = 0

  if (board.length === 1 || board[0].length === 1) {
    return board.flatMap((x) => x).includes(1) ? 1 : 0
  }

  for (let i = 1; i < board.length; i += 1) {
    for (let j = 1; j < board[0].length; j += 1) {
      if (board[i][j] !== 0) {
        board[i][j] += Math.min(
          board[i - 1][j],
          board[i - 1][j - 1],
          board[i][j - 1]
        )

        answer = Math.max(answer, board[i][j])
      }
    }
  }

  return answer * answer
}

const board = [
  [0, 1, 1, 1],
  [1, 1, 1, 1],
  [1, 1, 1, 1],
  [0, 0, 1, 0],
]

console.log(solution(board))
