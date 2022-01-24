# 📌 Everyday Types

## ➕ 원시 타입: `string`, `number` 그리고 `boolean`

- JavaScript에서 아주 흔하게 사용되는 세 가지의 [원시 타입](https://developer.mozilla.org/ko/docs/Glossary/Primitive)으로 `string`, `number`, `boolean`이 있다.
- 이 타입들은 TypeScript에서 각자 대응하는 타입이 존재한다.
    - 이 타입들은 JavaScript에서 각 타입별 값에 `typeof` 연산자를 사용하였을 때 얻을 수 있는 것과 동일한 이름을 가진다.
        - `string`
            - `Hello, world` 와 같은 문자열 값을 나타낸다.
        - `number`
            - `42` 와 같은 숫자를 나타낸다.
            - JavaScript는 정수를 위한 런타임 값을 별도로 가지지 않으므로, `int` 또는 `float` 과 같은 것은 존재하지 않는다.
            - 모든 수는 단순히 `number` 이다.
        - `boolean`
            - `true` 와 `false` 라는 두 가지 값만 가진다.
    - `String, Number, Boolean` 와 같은 대문자로 시작하는 타입은 유효한 타입이지만, 코드상에서 이러한 특수 내장 타입을 사용하는 경우는 극히 드물다. 항상 `string, number, boolean` 타입을 사용하자.

## ➕ 배열

- `[1, 2, 3]` 과 같은 배열의 타입을 지정할 때 `number[]` 구문을 사용할 수 있다.
    - `[number]` 는 전혀 다른 의미를 가진다.
- 이 구문은 모든 타입에서 사용할 수 있다. 예를 들어, `string[]` 은 문자열의 배열이다.
- 위 타입은 `Array<number>` 와 같은 형태로 적을 수 있으며, 동일한 의미를 가진다.

## ➕ `any`

- TypeScript는 또한 `any` 라고 불리는 특별한 타입을 가지고 있으며, 특정 값으로 인하여 타입 검사 오류가 발생하는 것을 원하지 않을 때 사용할 수 있다.
- 어떤 값의 타입이 `any` 이면, 해당 값에 대하여 임의의 속성에 접근할 수 있고, 함수인 것처럼 호출할 수 있고, 다른 임의 타입의 값에 할당하거나 받거나, 그 밖에도 구문적으로 유효한 것이라면 무엇이든 할 수 있다.

    ```typescript
    let obj: any = { x: 0}
    obj.foo()
    obj()
    obj.bar = 100
    obj = 'hello'
    const n: number = obj
    ```

- `any` 타입은 코드상의 특정 라인에 문제가 없다고 TypeScript를 안심시킨다는 목적 하나 때문에 긴 타입을 새로 정의하고 싶지 않을 때 유용하게 사용할 수 있다.
- 타입이 지정되지 않은 값에 대하여 TypeScript가 문맥으로부터 그 타입을 추론해낼 수 없다면, 컴파일러는 `any` 타입을 부여하는 것이 기본 동작이다.
- `any` 는 타입 검사가 이루어지지 않기 때문에 보통 선호되지 않는다.
    - 컴파일러 플래그 noImplicitAny 를 사용하면 암묵적으로 `any` 로 간주하는 모든 경우에 오류를 발생시킨다.

## ➕ 변수에 대한 타입 표기
- `const`, `var` 또는 `let` 등을 사용하여 변수를 선언할 때, 변수의 타입을 명시적으로 지정하기 위하여 타입 표기를 추가할 수 있으며, 선택 사항이다.
- 대부분의 경우, 타입 표기는 필요하지 않다. 가능하다면 TypeScript는 자동으로 코드 내의 있는 타입들을 *추론* 하고자 시도한다.

## ➕ 함수
- 함수는 JavaScript에서 데이터를 주고 받는 주요 수단이다. TypeScript에서는 함수의 입력 및 출력 타입을 지정할 수 있다.

- 매개변수 타입 표기
    - 함수를 선언할 때, 함수가 허용할 매개변수 타입을 선언하기 위하여 각 매개변수 뒤에 타입을 표기할 수 있다.

        ```typescript
        function greet(name: string){
            console.log('Hello, ' + name.toUpperCase() + '!!')
        }
        ```
        - 매개변수에 타입이 표기되었다면, 해당 함수에 대한 인자는 검사가 이루어진다.
        - 매개변수에 타입을 표기하지 않았더라도, TypeScript는 올바른 개수의 인자가 전달되었는지 여부를 검사한다.

- 반환 타입 표기
    - 반환 타입 또한 표기할 수 있다. 반환 타입은 매개변수 목록 뒤에 표기한다.

        ```typescript
        function getFavoriteNumber(): number {
            return 26
        }
        ```
        - 변수의 타입 표기와 마찬가지로, 반환 타입은 표기하지 않아도 되는 것이 일반적이다.
        - 왜냐하면 TypeScript가 해당 함수에 들어있는 `return` 문을 바탕으로 반환 타입을 추론할 것이기 때문이다.
        - 때에 따라 문서화를 목적으로, 또는 코드의 잘못된 수정을 미연에 방지하고자, 혹은 지극히 개인적인 선호에 의하여 명시적인 타입 표기를 수행한다.

- 익명 함수
    - 익명 함수는 함수 선언과는 조금 다르다.
    - 함수가 코드상에서 위치한 곳을 보고 해당 함수가 어떻게 호출될지 알아낼 수 있다면, TypeScript는 해당 함수의 매개 변수에 자동으로 타입을 부여한다.

        ```typescript
        const names = ['Alice', 'Bob', 'Eve']
        
        /* 함수에 대한 문맥적 타입 부여 */
        names.forEach(function (s) {
            console.log(s.toUppercase()) 
        })
        // Property 'toUppercase' does not exist on type 'string'. 
        // Did you mean 'toUpperCase'?
        
        /* 화살표 함수에도 문맥적 타입 부여는 적용된다. */
        names.forEach((s) => {
            console.log(s.toUppercase())
        })
        // Property 'toUppercase' does not exist on type 'string'. 
        // Did you mean 'toUpperCase'?
        ```
        - 매개 변수 `s` 에는 타입이 표기되지 않았음에도 불구하고, TypeScript는 `s` 의 타입을 알아내기 위하여 배열의 추론된 타입과 더불어 `forEach` 함수의 타입을 활용하였다.

        - 이 과정은 **문맥적 타입 부여** 라고 불리는데, 함수가 실행되는 문맥을 통하여 해당 함수가 가져야 하는 타입을 알 수 있기 때문이다.

## ➕ 객체 타입
- 원시 타입을 제외하고 가장 많이 마주치는 타입은 객체 타입이다.
    - 객체는 프로퍼티를 가지는 JavaScript 값을 말하는데, 대부분의 경우가 이에 해당한다.
    - 객체 타입을 정의하려면, 해당 객체의 프로퍼티들과 각 프로퍼티의 타입들을 나열하기만 하면 된다. 

        ```typescript
        function printCoord(pt: { x: number, y: number }){
            console.log("The coordinate's x value is " + pt.x)
            console.log("The coordinate's y value is " + pt.y)
        }
        printCoord({x: 3, y: 7})
        ```
        - 위에서 매개변수는 `x` 와 `y` 라는 두 개의 프로퍼티로 이루어진 타입으로 표기되고 있는데, 두 값은 모두 `number` 타입이다.
        - 각 프로퍼티를 구분할 때 `,` 또는 `;` 를 사용할 수 있고, 가장 마지막에 위치한 구분자의 표기는 선택 사항이다.
        - 각 프로퍼티의 타입 표기 또한 선택 사항이다. 만약 타입을 지정하지 않는다면, 해당 프로퍼티는 `any` 타입으로 간주한다.

- 옵셔널 프로퍼티
    - 객체 타입은 일부 또는 모든 프로퍼티의 타입을 선택적인 타입, 즉 옵셔널로 지정할 수 있다.
    - 프로퍼티 이름 뒤에 `?` 를 붙이면 된다.

        ```typescript
        function printName(obj: {first: string, last?: string}){
            //...
        }

        printName({ first: 'Bob' })
        printName({ first: 'Alice', last: 'Alisson' })
        ```

    - JavaScript에서는 존재하지 않는 프로퍼티에 접근하였을 때, 런타임 오류가 발생하지 않고 `undefined` 값을 얻게 된다.
    - 이 때문에 옵셔널 프로퍼티를 읽었을 때, 해당 값을 사용하기에 앞서 `undefined` 인지 여부를 확인해야 한다.
    
        ```typescript
        function printName(obj: {first: string, last?: string}){
            // #1. obj.last 의 값이 제공되지 않는다면 프로그램이 멈추게 된다.
            console.log(obj.last.toUpperCase()) 

            // #2. undefined 체크
            if(obj.lat !== undefined){
                console.log(obj.last.toUpperCase())
            }

            // #3. 최신 JavaScript 문법
            console.log(obj.last?.toUpperCase())
        }
        ```

## ➕ 유니언 타입
- TypeScript의 타입 시스템에서는 기존의 타입을 기반으로 다양한 연산자를 사용하여 새로운 타입을 만들 수 있다.

- 유니언 타입 정의하기
    - 유니언 타입은 서로 다른 두 개 이상의 타입들을 사용하여 만드는 것으로, 유니언 타입의 값은 타입 조합에 사용된 타입 중 무엇이든 하나를 타입으로 가질 수 있다.
    - 조합에 사용된 각 타입을 유니언 타입의 *멤버* 라고 부른다.

        ```typescript
        function printId(id: number | string){
            console.log('Your ID is: ' + id)
        }

        printId(101) // OK
        printId('202') // OK
        printId({myID: 22342}) // Error
        ```
        
- 유니언 타입 사용하기
    - 유니언 타입에 맞는 값을 제공하는 것은 간단하다. 유니언 타입의 멤버 중 하나에 해당하는 타입을 제공하면 된다.
    - TypeScript에서 유니언을 다룰 때는 해당 유니언 타입의 모든 멤버에 대하여 유효한 작업일 때만 허용된다.
        - 예를 들어 `string | number` 라는 유니언 타입의 경우, `string` 타입에만 유요한 메서드는 사용할 수 없다.

            ```typescript
            function printId(id: number | string){
                console.log(id.toUpperCase())
                // Property 'toUpperCase' does not exist on type 'string | number'.
                // Property 'toUpperCase' does not exist on type 'number'.
            }
            ```
    - 이를 해결하려면 코드상에서 유니언을 좁혀야 하는데, 이는 타입 표기가 없는 JavaScript에서 벌어지는 일과 동일하다.
        - 예를 들어, TypeScript는 오직 `string` 값만이 `typeof` 연산의 결과값으로 `string`을 가질 수 있다는 것을 알고 있다.

            ```typescript
            function printId(id: number | string){
                if(typeof id === 'string'){
                    // 이 분기에서 id는 'string' 타입을 가진다.
                    console.log(id.toUpperCase()) // OK
                } else {
                    // 여기에서 id는 'number' 타입을 가진다.
                    console.log(id)
                }
            }
            ```
        - 또 다른 예시는 `Array.isArray` 를 사용하는 것이다.

            ```typescript
            function welcomePeople(x: string[] | string){
                if(Array.isArray(x)){
                    // 여기에서 'x' 는 'string[]' 타입이다.
                    console.log('Hello, ' + x.join(' and '))
                } else {
                    // 여기에서 'x' 는 'string' 타입이다.
                    console.log('Welcome lone traveler ' + x)
                }
            }
            ```
    - 때로는 유니언의 모든 멤버가 공통점을 가질 수도 있다.
        - 예를 들어, 배열과 문자열은 둘다 `slice` 메서드를 내장하고 있다.

            ```typescript
            function getFirstThree(x: number[] | string){
                return x.slice(0, 3)
            }
            // 반환 타입은 'number[] | string' 으로 추론된다.
            ```
    
## ➕ 타입 별칭
- 객체 타입과 유니언 타입을 사용할 때 직접 해당 타입을 표기하였다. 이는 편리하지만, 똑같은 타입을 한 번 이상 재사용하거나 또 다른 이름으로 부르고 싶은 경우도 존재한다.

- **타입 별칭**은 바로 이런 경우를 위하여 존재하며, 타입을 위한 이름을 제공한다.

    ```typescript
    type Point = {
        x: number,
        y: number 
    }

    function printCoord(pt: Point){
        console.log("The coordinate's x value is " + pt.x)
        console.log("The coordinate's y value is " + pt.y)
    }

    printCoord({ x: 100, y: 100})
    ```

- 타입 별칭을 사용하면 단지 객체 타입뿐이 아닌 모든 타입에 대하여 새로운 이름을 부여할 수 있다.
    - 예를 들어, 유니언 타입에 대하여 타입 별칭을 부여할 수도 있다.

        ```typescript
        type ID = number | string
        ```

- 타입 별칭은 단지 별칭에 지나지 않는다는 점에 유의해야 한다. 즉, 타입 별칭을 사용하여도 동일 타입에 대하여 각기 구별되는 여러 버전을 만드는 것이 아니다.
- 별칭을 사용하는 것은, 별도로 이름 붙인 타입을 새로 작성하는 것이다.

    ```typescript
    declare function getInput(): string;
    declare function sanitize(str: string): string;
    //...
    type UserInputSanitizedString = string; 
    
    function sanitizeInput(str: string): UserInputSanitizedString {
        return sanitize(str)
    }

    let userInput = sanitizeInput(getInput())
    userInput = 'new input'
    ```
    - 해당 코드는 틀린 것처럼 보일 수 있지만, TypeScript에서는 이것이 정상인데 이유는 각각의 타입들이 동일 타입에 대한 별칭이기 때문이다.

## ➕ 인터페이스
- 인터페이스 선언은 객체 타입을 만드는 또 다른 방법이다.

    ```typescript
    interface Point = {
        x: number;
        y: number;
    }

    function printCoord(pt: Point){
        console.log("The coordinate's x value is " + pt.x)
        console.log("The coordinate's y value is " + pt.y)
    }

    printCoord({ x: 100, y: 100})
    ```

    - 타입 별칭을 사용한 경우와 마찬가지로, 위 코드는 마치 타입이 없는 임의의 익명 객체를 사용하는 것처럼 동작한다.
    - TypeScript는 오직 `printCoord` 에 전달된 값의 **구조**에만 관심을 가진다.
    - 즉, 예측된 프로퍼티를 가졌는지 여부만을 따진다.
    - 타입이 가지는 구조와 능력에만 관심을 가진다는 점은 TypeScript가 구조적 타입 시스템이라고 불리는 이유다.

- 타입 별칭과 인터페이스의 차이점
    - 타입 별칭과 인터페이스는 매우 유사하며, `interface` 가 가지는 대부분의 기능은 `type` 에서도 동일하게 사용 가능하다.
    - 이 둘의 가장 핵심적인 차이는, 타입은 새 프로퍼티를 추가하도록 개방될 수 없는 반면, 인터페이스의 경우 항상 확장될 수 있다는 점이다.

        - 인터페이스 확장하기

            ```typescript
            interface Animal {
                name: string
            }

            interface Bear extends Animal{
                honey: boolean
            }

            const bear = getBear()
            bear.name
            bean.honey
            ```
        
        - 교집합을 통하여 타입 확장하기

            ```typescript
            type Animal = {
                name: string
            }

            type Bear = Animal & {
                honey: Boolean
            }

            const bear = getBear()
            bear.name
            bear.honey
            ```

        - 기존 인터페이스에 새 필드를 추가하기

            ```typescript
            interface Window {
                title: string
            }

            interface Window {
                ts: TypeScriptAPI
            }

            const src = 'const a = "Hello World"'
            window.ts.transpileModule(src, {})
            ```

        - 타입은 생성된 뒤에는 달라질 수 없다.

            ```typescript
            type Window = {
                title: string
            }

            type Window = {
                ts: TypeScriptAPI
            }

            // Error: Duplicate identifier 'Window'.
            ```

        - TypeScript 4.2 이전 버전에서는, 타입 별칭 이름이 오류 메시지에 나타날 수 있고, 때로는 동등한 익명 타입을 대신하여 나타날 수 있다. 
        - 인터페이스는 항상 오류 메시지에 이름이 나타난다.
        - 타입 별칭은 선언 병합에 포함될 수 없지만, 인터페이스는 포함될 수 있다.
        
            ```typescript
            interface Mammal{
                genus: string
            }

            interface Mammal{
                breed?: string
            }

            const animal: Mammal = {
                genus: '1234',
                breed: 1    // Fails becuase breed has to be a string
            }
            ```

        - 인터페이스는 오직 객체의 모양을 선언하는 데에만 사용되며, 기존의 원시 타입에 별칭을 부여하는 데에는 사용할 수는 없다.

- 대부분의 경우 개인적 선호에 따라 인터페이스와 타입 중에서 선택할 수 있으며, 필요하다면 TypeScript가 다른 선택을 제안할 것이다.
- 우선 `interface` 를 사용하고 이후 문제가 발생하였을 때 `type` 을 사용하자.

