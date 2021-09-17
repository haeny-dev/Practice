// @ts-check

/**
 * @param {number[]} nums
 * @returns
 */
function solution(nums) {
  const pokemons = new Set(nums)
  return pokemons.size > nums.length / 2 ? nums.length / 2 : pokemons.size
}

const nums = [3, 3, 3, 2, 2, 4]
console.log(solution(nums))
