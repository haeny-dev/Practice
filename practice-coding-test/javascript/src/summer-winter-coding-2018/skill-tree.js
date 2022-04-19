// @ts-check

/**
 * @param {string} skill
 * @param {string[]} skill_trees
 * @returns {number}
 */
function solution(skill, skill_trees) {
  return skill_trees
    .map((x) => x.replace(new RegExp(`[^${skill}]`, 'g'), ''))
    .filter((x) => skill.startsWith(x)).length
}

const skill = 'CBD'
const skill_trees = ['BACDE', 'CBADF', 'AECB', 'BDA']
console.log(solution(skill, skill_trees))
