// @ts-check

/**
 * @param {number[]} lottos
 * @param {number[]} win_nums
 * @returns {number[]}
 */
function solution(lottos, win_nums) {
  const answer = [0, 0]

  for (let i = 0; i < lottos.length; i += 1) {
    if (lottos[i] === 0) {
      answer[0] += 1
      continue
    }

    for (let j = 0; j < win_nums.length; j += 1) {
      if (lottos[i] === win_nums[j]) {
        answer[0] += 1
        answer[1] += 1
        break
      }
    }
  }

  answer[0] = answer[0] < 2 ? 6 : 7 - answer[0]
  answer[1] = answer[1] < 2 ? 6 : 7 - answer[1]

  return answer
}

function diffSolution(lottos, win_nums) {
  const rank = [6, 6, 5, 4, 3, 2, 1]

  const minCount = lottos.filter((x) => win_nums.includes(x)).length
  const zeroCount = lottos.filter((x) => !x).length
  return [rank[minCount + zeroCount], rank[minCount]]
}

const lottos = [44, 1, 0, 0, 31, 25]
const win_nums = [31, 10, 45, 1, 6, 19]

console.log(solution(lottos, win_nums))
console.log(diffSolution(lottos, win_nums))
