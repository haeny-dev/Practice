// @ts-check
function solution(n) {
  let answer = 0
  let n_2 = 0
  let n_1 = 1
  for (let i = 0; i < n - 1; i += 1) {
    answer = (n_1 + n_2) % 1234567
    n_2 = n_1
    n_1 = answer
  }

  return answer
}

const n = 5
console.log(solution(n))
