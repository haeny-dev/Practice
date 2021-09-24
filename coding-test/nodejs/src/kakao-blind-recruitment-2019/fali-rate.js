// @ts-check

/**
 * @param {number} N
 * @param {number[]} stages
 * @returns {number[]}
 */
function solution(N, stages) {
  const answer = new Array(N)
  for (let i = 0; i < answer.length; i += 1) {
    answer[i] = {
      num: i + 1,
      players: 0,
      clear: 0,
    }
  }

  stages.forEach((curStage) => {
    for (let i = 0; i < curStage - 1; i += 1) {
      answer[i].players += 1
      answer[i].clear += 1
    }

    if (curStage <= N) {
      answer[curStage - 1].players += 1
    }
  })

  return answer
    .map((stage) => ({
      ...stage,
      failrate: (stage.players - stage.clear) / stage.players,
    }))
    .sort((a, b) => {
      const f = b.failrate - a.failrate

      if (f === 0) {
        return a.num - b.num
      }

      return f
    })
    .map((x) => x.num)
}

const N = 4
const stages = [4, 4, 4, 4, 4]

console.log(solution(N, stages))
