// @ts-check

/**
 * @param {string} numbers
 * @returns {number}
 */
function solution(numbers) {
  const set = []
  const numbersArr = numbers.split('')
  const isVisited = Array(numbers.length).fill(false)
  dfs(numbersArr, isVisited, '', set)
  return findPrimeNumbers(Array.from(new Set(set)))
}

/**
 * @param {string[]} nArr
 * @param {boolean[]} isVisited
 * @param {string} nStr
 * @param {number[]} set
 */
function dfs(nArr, isVisited, nStr, set) {
  if (nStr !== '') {
    set.push(parseInt(nStr, 10))
  }

  for (let i = 0; i < nArr.length; i += 1) {
    if (!isVisited[i]) {
      isVisited[i] = true
      const newStr = nStr + nArr[i]
      dfs(nArr, isVisited, newStr, set)
      isVisited[i] = false
    }
  }
}

/**
 * @param {number[]} numbers
 * @returns {number}
 */
function findPrimeNumbers(numbers) {
  let count = 0
  for (let i = 0; i < numbers.length; i += 1) {
    if (numbers[i] < 2 || (numbers[i] !== 2 && numbers[i] % 2 === 0)) {
      continue
    }

    count += 1
    for (let j = 2; j <= Math.sqrt(numbers[i]); j += 1) {
      if (numbers[i] % j === 0) {
        count -= 1
        break
      }
    }
  }

  return count
}

const numbers = '17'
console.log(solution(numbers))
