// @ts-check

/**
 * @param {string} new_id
 * @returns {string}
 */
function solution(new_id) {
  return new_id
    .toLowerCase()
    .replace(/[^A-Za-z0-9._-]/g, '')
    .replace(/\.{2,}/g, '.')
    .replace(/^\.|\.$/g, '')
    .replace(/^$/, 'a')
    .slice(0, 15)
    .replace(/\.$/, '')
    .padEnd(3, new_id.charAt(new_id.length - 1))
}

const new_id = '...!@BaT#*..y.abcdefghijklm'
const result = 'bat.y.abcdefghi'

console.log(result === solution(new_id))
