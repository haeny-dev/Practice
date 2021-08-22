// @ts-check

/**
 * @param { number } num
 */
function solution(num) {
  return collatz(num, 0)
}

function collatz(num, count) {
  if (num === 1) return count
  if (count >= 500) return -1

  if (num % 2 === 0) {
    num /= 2
  } else {
    num *= 3
    num += 1
  }

  count++

  return collatz(num, count)
}

console.log(solution(6))
