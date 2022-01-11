// @ts-check

/**
 * @param {number} bridge_length
 * @param {number} weight
 * @param {number[]} truck_weights
 * @returns
 */
function solution(bridge_length, weight, truck_weights) {
  let answer = 0
  let bridgeWeight = 0
  let index = 0
  const bridge = Array(bridge_length).fill(0)

  while (bridge.length > 0) {
    answer += 1

    bridgeWeight -= bridge.splice(0, 1)[0]

    if (index < truck_weights.length) {
      if (weight - bridgeWeight >= truck_weights[index]) {
        bridge.push(truck_weights[index])
        bridgeWeight += truck_weights[index++]
      } else {
        bridge.push(0)
      }
    }
  }

  return answer
}

const bridge_length = 100
const weight = 100
const truck_weights = [10, 10, 10, 10, 10, 10, 10, 10, 10, 10]

console.log(solution(bridge_length, weight, truck_weights))
