// @ts-check

/**
 * @param {number[]} citations
 * @returns {number}
 */
function solution(citations) {
  return citations
    .sort((a, b) => b - a)
    .reduce((h, v, i) => {
      return v >= i + 1 ? i + 1 : h
    }, 0)
}

const citations = [3, 0, 6, 1, 5]
console.log(solution(citations))
