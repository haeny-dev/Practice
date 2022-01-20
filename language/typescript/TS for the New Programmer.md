# 📌 TypeScript for the New Programmer

> TypeScript 는 컴파일 타임 타입 검사자가 있는 JavaScript의 런타임입니다.

## ➕ What is JavaScript? A Brief History

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

## ➕ TypeScript: A Static Type Checker
- 프로그램을 실행시키지 않으면서 코드의 오류를 검출하는 것을 `정적 검사` 라고 한다.  
어떤 것이 오류인지와 어떤 것이 연산 되는 값에 기인하지 않음을 정하는 것이 정적 타입 검사이다.

- 정적 타입 검사자인 TypeScript는 프로그램을 실행시키기 전에 값의 종류를 기반으로 프로그램의 오류를 찾는다.
    ```javascript
    // @errors: 2551
    const obj = {width: 10, height: 15}
    const area = obj.width * obj.heigth
    ```

- A Typed Superset of JavaScript
    - 구문, Syntax  
        - TypeScript는 JS의 구문이 허용되는, JavaScript의 상위 집합 언어이다.  
        - 잘 작동하는 JavaScript 코드를 TypeScript 파일에 넣어도 잘 작동한다.

    - 타입, Types  
        - TypeScript는 다른 종류의 값들을 사용할 수 있는 방법이 추가된, 타입이 있는 상위 집합이다.  
        - `obj.heigth` 에서 발생한 오류는 구문 오류가 아닌, 값의 종류(타입)를 잘못 사용해서 생긴 오류이다.

            ```javascript
            // JavaScript
            console.log(4 / [])     // NaN
            
            // TypeScript
            console.log(4 / [])     // @errors: 2363
            ```
        - 실제로 어떤 일이 일어나는지 보려는 의도로 나눌 수 있지만, 대부분은 프로그래밍 실수이다.  
        - TypeScript의 타입 검사자는 일반적인 오류를 최대한 많이 검출하면서 올바른 프로그램을 만들 수 있게 설계되었다.  

    - 런타임 특성, Runtime Behavior  
        - JavaScript의 런타임 특성을 가진 프로그래밍 언어이다.  
        - 논리적으로, TypeScript는 JavaScript 코드의 런타임 특성을 절대 변화시키지 않는다.  
        - 즉, TypeScript가 코드에 타입 오류가 있음을 검출해도, JavaScript 코드를 TypeScript로 이동시키는 것은 같은 방식으로 실행시키는 것을 보장한다.

    - 삭제된 타입, Erased Types
        - TypeScript의 컴파일러가 코드 검사를 마치면 타입을 삭제해서 결과적으로 컴파일된 코드를 만든다.
        - 즉, 코드가 한 번 컴파일되서 나온 일반 JS코드에는 타입 정보가 없다.
        - 타입 정보가 없는 것은 TypeScript가 추론한 타입에 따라 프로그램의 특성을 변화시키지 않는다는 의미이다.
        - 결론적으로 컴파일 도중에는 타입 오류가 표출될 수 있지만, 타입 시스템 자체는 프로그램이 실행될 때 작동하는 방식과 관련이 없다.
    
    
    
    