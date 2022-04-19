function solution(n) {
    let answer = ''
    const arr = ['1', '2', '4'];
    while (n !== 0) {
        answer = arr[(n - 1) % 3] + answer;
        n = Math.floor((n - 1) / 3)
    }

    return answer;
}

function diffSolution(n) {
    return n === 0 ? '' : diffSolution(Math.floor((n - 1) / 3)) + [1, 2, 4][(n - 1) % 3];
}

const n = 6

console.log(solution(n))
console.log(diffSolution(n))