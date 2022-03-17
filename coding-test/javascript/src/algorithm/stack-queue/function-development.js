// @ts-check

/**
 * @param {number[]} progresses
 * @param {number[]} speeds
 * @returns {number[]}
 */
function solution(progresses, speeds) {
    const answer = []

    let pointer = 0;
    while (pointer < progresses.length) {
        let deployCnt = 0;
        const days = Math.ceil((100 - progresses[pointer])/speeds[pointer]);

        for (let i = pointer; i < progresses.length; i++) {
            progresses[i] += days * speeds[i];
        }

        while (pointer < progresses.length && progresses[pointer] >= 100) {
            deployCnt++;
            pointer++;
        }
        answer.push(deployCnt)
    }

    return answer;
}

const progresses = [95, 90, 99, 99, 80, 99]
const speeds = [1, 1, 1, 1, 1, 1]

console.log(solution(progresses, speeds))