// @ts-check

/**
 * @param {number[]} priorities
 * @param {number} location
 * @returns {number}
 */
function solution(priorities, location) {
  const documents = Array(priorities.length).fill('A')
  documents[location] = 'T'
  return printNum(priorities, documents, 1)
}

/**
 * @param {number[]} priorities
 * @param {string[]} documents
 * @param {number} num
 * @returns {number}
 */
function printNum(priorities, documents, num) {
  const max = Math.max(...priorities)
  const priority = priorities.splice(0, 1)[0]
  const document = documents.splice(0, 1)[0]

  if (priority === max) {
    if (document === 'T') {
      return num
    }

    num += 1
  } else {
    priorities.push(priority)
    documents.push(document)
  }

  return printNum(priorities, documents, num)
}

const priorities = [2, 1, 3, 2]
const location = 2

console.log(solution(priorities, location))
