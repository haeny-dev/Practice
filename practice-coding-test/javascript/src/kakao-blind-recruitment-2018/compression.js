// @ts-check

/**
 * @param {string} msg
 * @returns {number[]}
 */
function solution(msg) {
  const answer = []
  const dic = Array(26)
    .fill(1)
    .map((v, i) => String.fromCharCode(65 + i))

  while (msg.length > 0) {
    for (let i = dic.length - 1; i >= 0; i -= 1) {
      if (msg.startsWith(dic[i])) {
        msg = msg.slice(dic[i].length)
        answer.push(i + 1)

        if (msg.length > 0) {
          dic.push(dic[i] + msg.charAt(0))
        }
        break
      }
    }
  }

  return answer
}

const msg = 'KAKAO'

console.log(solution(msg))
