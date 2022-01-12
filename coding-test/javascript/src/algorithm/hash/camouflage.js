// @ts-check

/**
 * @param {string[][]} clothes
 * @returns {number}
 */
function solution(clothes) {
  return (
    Object.values(
      clothes.reduce((obj, v) => {
        obj[v[1]] = obj[v[1]] ? obj[v[1]] + 1 : 1
        return obj
      }, {})
    ).reduce((r, v) => r * (1 + v), 1) - 1
  )
}

const clothes = [
  ['yellowhat', 'headgear'],
  ['bluesunglasses', 'eyewear'],
  ['green_turban', 'headgear'],
]

console.log(solution(clothes))
