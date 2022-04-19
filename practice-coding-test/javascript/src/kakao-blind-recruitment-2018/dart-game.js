// @ts-check

/**
 * @param {string} dartResult
 * @returns
 */
function solution(dartResult) {
  const bonus = { S: 1, D: 2, T: 3 }
  const options = { '*': 2, '#': -1, undefined: 1 }

  /**
   * \d : 숫자 문자에 대응 [0-9] 와 동일
   *  . : 개행 문자를 제외한 모든 단일 문자와 대응
   *  ? : 앞의 표현식이 0 또는 1회 등장하는 부분과 대응
   * \D : 숫자 문자가 아닌 문자에 대응 [^0-9]
   */
  let darts = dartResult.match(/\d.?\D/g)

  for (let i = 0; i < darts.length; i += 1) {
    let split = darts[i].match(/(^\d{1,})(S|D|T)(\*|#)?/)
    let score = Math.pow(split[1], bonus[split[2]]) * options[split[3]]

    if (split[3] === '*' && darts[i - 1]) {
      darts[i - 1] *= options['*']
    }

    darts[i] = score
  }

  return darts.reduce((a, b) => a + b)
}

const dartResult = '1D2S#10S'

console.log(solution(dartResult))
