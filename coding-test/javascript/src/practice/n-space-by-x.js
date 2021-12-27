function solution(x, n){
    let answer = [];
    let num = x;
    
    for(let i = 0; i < n; i++){
        answer.push(num);
        num = num + x;
    }

    return answer;
}

function differentSolution(x, n){
    return Array(n).fill(x).map((v, i) => (i + 1) * v)
}

console.log(solution(2, 5))