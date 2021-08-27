// @ts-check

/**
 *
 * @param {number[]} numbers
 * @returns {number[]}
 */
function solution(numbers) {
  const set = new Set()

  for (let i = 0; i < numbers.length - 1; i += 1) {
    for (let j = i + 1; j < numbers.length; j += 1) {
      set.add(numbers[i] + numbers[j])
    }
  }

  return Array.from(set).sort((a, b) => a - b)
}

const numbers = [2, 1, 3, 4, 1]
console.log(solution(numbers))
