# 🟦 TypeScript

## 📌 TypeScript for the New Programmer

### ➕ What is JavaScript? A Brief History

- JavaScript는 처음에 브라우저를 위한 스크립팅 언어로 만들어졌다.  
JavaScript가 처음 나왔을 때, 수십 줄 이상의 코드를 작성하는 것은 다소 이례적인 일이었다.  
그러나, 시간이 흘러 JS가 점점 유명해지면서, 웹 개발자들은 JS를 이용해 상호작용을 하는 경험을 한다.

- 웹 브라우저 개발자들은 늘어나는 JS 사용량에 대해 실행 엔진을 최적화시키고 최적화 된 것을 이용해 할 수 있는 일을 확장하여 웹 개발자가 더 많이 JS를 사용할 수 있게 했다.

- 이외에도, JS는 node.js 를 사용하여 JS 서버들을 구현하는 것처럼, 브라우저 맥락에서 벗어나는 일에 사용하기 충분할 정더로 유명해 졌다.

- 모든 언어는 각자의 별난 점, 이상한 점, 놀랄만한 점이 있으며 JavaScript 또한 여러 문제를 만들었다.  
예를 들어,
    - JavaScript의 동일 연산자(`==`)는 인수를 강제로 변환하여, 예기치 않은 동작을 유발한다.
        ```javascript
        if('' == 0){
            // 참 입니다! 근데 왜죠..??
        }

        if(1 < x < 3){
            // 어떤 x 값이던 참입니다.
        }
        ```
    - JavaScript는 또한 존재하지 않는 프로퍼티의 접근을 허용한다.
        ```javascript
        const obj = {width: 10, height: 15}
        const area = obj.width * obj.heigth // NaN
        ```
- 대부분의 프로그래밍 언어는 이런 종류의 상황이 발생하면 오류를 표출해주고, 일부는 코드가 실행되기 전인 컴파일 중에 오류를 표출해준다.  
작은 프로그램을 작성할 경우에는 관리가 가능하지만, 규모가 커질수록 심각한 문제를 발생시킬 수 있다.

### ➕ TypeScript: A Static Type Checker

