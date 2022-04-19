// @ts-check

/**
 * @param {number[]} people
 * @param {number} limit
 * @returns {number}
 */
function solution(people, limit) {
  people = people.sort((a, b) => b - a)
  let start = 0,
    end = people.length - 1
  for (; start < end; start += 1) {
    if (people[start] + people[end] <= 100) end -= 1
  }
  return start
}

const people = [70, 50, 80, 50]
const limit = 100
console.log(solution(people, limit))
