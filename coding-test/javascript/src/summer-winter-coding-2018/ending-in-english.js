// @ts-check

/**
 * @param {number} n
 * @param {string[]} words
 * @returns {number[]}
 */
function solution(n, words) {
  const dupl = []
  for (let i = 0; i < words.length; i += 1) {
    if (
      dupl.includes(words[i]) ||
      (i > 0 &&
        words[i - 1].charAt(words[i - 1].length - 1) !== words[i].charAt(0))
    ) {
      return [(i % n) + 1, Math.floor(i / n) + 1]
    }

    dupl.push(words[i])
  }

  return [0, 0]
}

const n = 3
const words = [
  'tank',
  'kick',
  'know',
  'wheel',
  'land',
  'dream',
  'mother',
  'robot',
  'tank',
]

console.log(solution(n, words))
