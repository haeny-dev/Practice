// @ts-check

/**
 *
 * @param {string[]} files
 * @returns {string[]}
 */
function solution(files) {
  return files.sort((a, b) => {
    const A = a.match(/(\D*)(\d*)/i)
    const B = b.match(/(\D*)(\d*)/i)

    const headCompare = A[1].toLowerCase().localeCompare(B[1].toLowerCase())
    if (headCompare !== 0) {
      return headCompare
    }

    return parseInt(A[2], 10) - parseInt(B[2], 10)
  })
}

const files = [
  'F-5 Freedom Fighter',
  'B-50 Superfortress',
  'A-10 Thunderbolt II',
  'F-14 Tomcat',
]
console.log(solution(files))
