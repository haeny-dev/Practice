// @ts-check
/**
 * @param {number} n
 * @param {number} m
 * @returns {number[]}
 */
function solution(n, m) {
  return Array.from([lcm(n, m), (n * m) / lcm(n, m)])
}

/**
 * @param {number} n
 * @param {number} m
 * @returns {number}
 */
function lcm(n, m) {
  return n % m === 0 ? m : lcm(m, n % m)
}

console.log(solution(3, 12))
