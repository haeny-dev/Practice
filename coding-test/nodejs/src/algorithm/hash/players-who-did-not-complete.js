// @ts-check

/**
 * @param {string[]} participant
 * @param {string[]} completion
 * @returns {string}
 */
function solution(participant, completion) {
  return participant.find(
    (p) => !completion[p]--,
    completion.map((x) => (completion[x] = (completion[x] | 0) + 1))
  )
}

const participant = ['marina', 'josipa', 'nikola', 'vinko', 'filipa']
const completion = ['josipa', 'filipa', 'marina', 'nikola']

console.log(solution(participant, completion))
