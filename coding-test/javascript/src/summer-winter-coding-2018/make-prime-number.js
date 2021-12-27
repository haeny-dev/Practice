// @ts-check

/**
 * @param {number[]} nums
 * @returns
 */
function solution(nums) {
  let answer = 0

  for (let i = 0; i < nums.length - 2; i += 1) {
    for (let j = i + 1; j < nums.length - 1; j += 1) {
      for (let k = j + 1; k < nums.length; k += 1) {
        const sum = nums[i] + nums[j] + nums[k]
        let l
        for (l = 2; l < sum; l += 1) {
          if (sum % l === 0) {
            break
          }
        }

        if (l === sum) {
          answer += 1
        }
      }
    }
  }

  return answer
}

const nums = [1, 2, 7, 6, 4]
console.log(solution(nums))
