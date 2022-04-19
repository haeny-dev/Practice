// @ts-check

/**
 * @param {string} s
 * @returns {number}
 */
function solution(s) {
  let answer = 0
  let stack

  for (let i = 0; i < s.length; i += 1) {
    stack = []

    for (let j = 0; j < s.length; j += 1) {
      const peek = stack[stack.length - 1]

      if (
        (peek === '(' && s.charAt(j) === ')') ||
        (peek === '[' && s.charAt(j) === ']') ||
        (peek === '{' && s.charAt(j) === '}')
      ) {
        stack.pop()
      } else {
        stack.push(s.charAt(j))
      }
    }

    if (stack.length === 0) {
      answer += 1
    }

    s = s.slice(1) + s.charAt(0)
  }

  return answer
}

const s = '[](){}'
console.log(solution(s))
