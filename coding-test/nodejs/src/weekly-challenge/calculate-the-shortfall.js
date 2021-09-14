// @ts-check

/**
 * @param {number} price
 * @param {number} money
 * @param {number} count
 * @returns
 */
function solution(price, money, count) {
  const answer = (price * count * (count + 1)) / 2
  return answer > money ? answer - money : 0
}

console.log(solution(3, 10, 4))
