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

## ➕ 타입 단언
- 때로는 TypeScript보다 개발자가 어떤 값의 타입에 대한 정보를 더 잘 아는 경우도 존재한다.
    - 예를 들어 코드상에서 `document.getElementById` 가 사용되는 경우,
        - TypeScript는 이때 `HTMLElement` 중에 무언가가 반환된다는 것만을 알 수 있는 반면에, 
        - 개발자는 페이지 상에서 사용되는 ID로는 언제나 `HTMLCanvasElement` 가 반환된다는 사실을 이미 알고 있을 수도 있다.
        - 이런 경우, 타입 단언을 사용하면 타입을 좀 더 구체적으로 명시할 수 있다.
            
            ```typescript
            const myCanvas = document.getElementById('main_canvas') as HTMLCanvasElement;
            ```

        - 타입 표기와 마찬가지로, 타입 단언은 컴파일러에 의하여 제거되며 코드의 런타임 동작에는 영향을 주지 않는다.
        - <> 를 사용하는 것 또한(코드가 `.tsx` 파일이 아닌 경우) 가능하며, 이는 동일한 의미를 가진다.
            
            ```typescript
            const myCanvas = <HTMLCanvasElement>document.getElementById('main_canvas')
            ```

        - 타입 단언은 컴파일 시간에 제거되므로, 타입 단언에 관련된 검사는 런타임 중에 이루어지지 않는다.
            - 타입 단언이 틀렸더라도 예외가 발생하거나 null이 생성되지 않을 것이다.

- TypeScript에서는 보다 구체적인 또는 덜 구체적인 버전의 타입으로 변환하는 타입 단언만이 허용된다.
    - 이러한 규칙은 불가능한 강제 변환을 방지한다.
        
        ```typescript
        const x = 'hello' as number
        // Conversion of type 'string' to type 'number' may be a mistake because neither type sufficiently overlaps with the other. If this was intentional, convert the expression to 'unknown' first.
        ```

- 규칙이 때로는 지나치게 보수적으로 작용하여, 복잡하기는 하지만 유효할 수 있는 강제 변환이 허용되지 않기도 한다.
    - 이런 경우, 두 번의 단언을 사용할 수 있다.
    - `any` 로 우선 변환한 뒤, 그다음 원하는 타입으로 변환하면 된다.

        ```typescript
        declare const expr: any
        type T = { a: 1, b: 2, c: 3}
        //...
        const a = (expr as any) as T;
        ```


## ➕ 리터럴 타입
- `string` 과 `number` 와 같은 일반적인 타입 이외에도, 구체적인 문자열과 숫자 값을 타입 위치에서 지정할 수 있다.
    - `var` 와 `let` 모두 변수에 저장 가능한 값의 종류를 변경할 수 있으며, `const` 는 이것이 불가능하다.
    - 이러한 특징들은 TypeScript가 리터럴 값을 위한 타입을 생성하는 방식에 그대로 반영된다.

        ```typescript
        let changingString = 'Hello World'
        changingString = 'Olá Mundo'
        // 변수 changingString 은 어떤 문자열이든 모두 나타낼 수 있으며,
        // 이는 TypeScript의 타입 시스템에서 문자열 타입 변수를 다루는 방식과 동일하다.
        changingString // let changingString: string

        const constantString = 'Hello World'
        // 변수 constantString 은 오직 단 한 종류의 문자열만 나타낼 수 있으며,
        // 이는 리터럴 타입의 표현 방식이다.
        constantString // const constantString: 'Hello World'
        ```

    - 리터럴 타입은 그 자체만으로는 그다지 유의미하지 않다.

        ```typescript
        let x: 'hello' = 'hello'
        x = 'hello' // OK
        x = 'howdy' // Type '"howdy"' is not assignable to type '"hello"'
        ```
        - 단 하나의 값만을 가질 수 있는 변수는 쓸모가 없다.

    - 리터럴을 유니언과 함께 사용하면, 보다 유용한 개념들을 표현할 수 있게 된다.
        - 예를 들어, 특정 종류의 값들만을 인자로 받을 수 있는 함수를 정의하는 경우

            ```typescript
            function printText(s: string, alignment: 'left'|'right'|'center'){
                //...
            }
            printText('Hello, world', 'left') // OK
            printText('Gday, mate', 'centre')
            // Argument of type '"centre"' is not assignable to 
            // parameter of type ''left'|'right'|'center''.
            ```

    - 숫자 리터럴 타입 또한 같은 방식으로 사용할 수 있다.

        ```typescript
        function compare(a: string, b: string): -1 | 0 | 1 {
            return a === b ? 0 : a > b ? 1 : -1
        }
        ```

    - 리터럴이 아닌 타입과도 함께 사용할 수 있다.

        ```typescript
        interface Options {
            width: number
        }
        function configure(x: Options | 'auto'){
            //...
        }
        configure({width: 100}) // OK
        configure('auto') // OK
        configure('automatic')
        // Argument of type '"automatic"' is not assignable to 
        // parameter of type 'Options | "auto"'.
        ```

    - 불 리터럴 타입
        - 불 리터럴에는 오직 두개의 타입만이 존재하며, `true` 와 `false` 이다.
        - `boolean` 타입 자체는 사실 단지 `true | false` 유니언 타입의 별칭이다.

- 리터럴 추론
    - 객체를 사용하여 변수를 초기화하면, TypeScript는 해당 객체의 프로퍼티는 이후에 그 값이 변화할 수 있다고 가정한다.
        
        ```typescript
        declare const someCondition: boolean
        // ...
        const obj = { counter: 0 }
        if (someCondition){
            obj.counter = 1
        }
        ```
        - 기존에 값이 0 이었던 필드에 1 을 대입하였을 때 TypeScript는 이를 오류로 간주하지 않는다.
        - 이를 달리 말하면 `obj.counter` 는 반드시 `number` 타입을 가져야 하며, `0` 리터럴 타입을 가질 수 없다는 의미이다.
        - 왜냐하면 타입은 읽기 및 쓰기 두 동작을 결장하는 데에 사용되기 때문이다.

    - 이와 같은 사항은 문자열에도 적용된다.

        ```typescript
        const req = { url: 'https://example.com', method: 'GET' }
        handleRequest(req.url, req.method)
        // Argument of type 'string' is not assignable to parameter of type '"GET"|"POST"'.
        ```
        - 위 예시에서 `req.method` 는 `string` 으로 추론되지, `"GET"` 으로 추론되지 않는다.
        - `req` 의 생성 시점과 `handleRequest` 의 호출 시점 사이에도 `req.method` 에 `"GUESS"` 와 같은 새로운 문자열이 대입될 수 있으므로, TypeScript는 오류가 있다고 판단한다.
        - 이러한 경우를 해결하는 방법
            1. 둘 중에 한 위치에 타입 단언을 추가하여 추론 방식을 변경

                ```typescript
                // #1
                const req = { url: 'https://example.com', method: 'GET' as 'GET' }
                // #2
                handleRequest(req.url, req.method as 'GET')
                ```
                - #1 은 `req.method` 가 항상 리터럴 타입 `GET` 이기를 의도하며, 이에 따라 해당 필드에 `GUESS` 와 같은 값이 대입되는 경우를 미연에 방지하겠다는 의미이다.
                - #2 는 `req.method` 가 `GET` 을 값으로 가진다는 사실을 알고 있다는 것을 의미한다.

            2. `as const` 를 사용하여 객체 전체를 리터럴 타입으로 변환할 수 있다.

                ```typescript
                declare function handleRequest(url: string, method: 'GET'|'POST'): void;
                // ...
                const req = { url: 'https://example.com', method: 'GET'} as const
                handleRequest(req.url, req.method)
                ```
                - `as const` 접미사는 일반적인 `const` 와 유사하게 작동하는데, 해당 객체의 모든 프로퍼티에 `string` 또는 `number` 와 같은 보다 일반적인 타입이 아닌 리터럴 타입의 값이 대입되도록 보장한다.

## ➕ `null` 과 `undefined` 
- JavaScript에는 빈 값 또는 초기화되지 않은 값을 가리키는 두 가지 원시값이 존재한다. 바로 `null` 과 `undefined` 이다.
- TypeScript에는 각 값에 대응하는 동일한 이름의 두 가지 타입이 존재한다. 

- 각 타입의 동작 방식은 `strictNullChecks` 옵션의 설정 여부에 따라 달라진다.
    - `strictNullChecks` 가 설정되지 않았을 때
        - 어떤 값이 `null` 또는 `undefined` 일 수 있더라도 해당 값에 평소와 같이 접근할 수 있으며, `null` 과 `undefined` 는 모든 타입의 변수에 대입될 수 있다.
        - 이는 Null 검사를 하지 않는 언어의 동작 방식과 유사하다.

    - `strictNullChecks` 설정되었을 때
        - 어떤 값이 `null` 또는 `undefined` 일 때, 해당 값과 함께 메서드 또는 프로퍼티를 사용하기에 앞서 해당 값을 테스트해야 한다.
        - 옵셔널 프로퍼티를 사용하기에 앞서 `undefined` 여부를 검사하는 것과 마찬가지로, 좁히기를 통하여 `null` 일 수 있는 값에 대한 검사를 수행할 수 있다.
        
            ```typescript
            function doSomething(x: string | undefined){
                if(x === undefined){
                    // Nothing
                } else {
                    console.log('Hello, ' + x.toUpperCase())
                }
            }
            ```

- Null 아님 단언 연산자(접미사 `!`)
    - TypeScript에서는 명시적인 검사를 하지 않고도 타입에서 `null` 과 `undefined` 를 제거할 수 있는 특별한 구문을 제공한다.
    - 표현식 뒤에 `!` 를 작성하면 해당 값이 `null` 또는 `undefined` 가 아니라고 타입 단언하는 것이다.

        ```typescript
        function liveDangerously(x?: number | undefined){
            console.log(x!.toFixed())   // OK
        }
        ```
    - 다른 타입 단언과 마찬가지로 이 구문은 코드의 런타임 동작을 변화시키지 않으므로, `!` 연산자는 반드시 해당 값이 `null` 또는 `undefined` 가 아닌 경우에만 사용해야 한다.

## ➕ 그 외
- 열거형
    - 열거형은 TypeScript가 JavaScript에 추가하는 기능으로, 어떤 값이 이름이 있는 상수 집합에 속한 값 중 하나일 수 있도록 제한하는 기능이다.
    - 이 기능은 JavaScript에 타입 수준이 아닌, 언어와 런타임 수준에 추가되는 기능이다.

- 자주 사용되지 않는 원시형 타입
    - `bigint`
        - ES2020 이후, 아주 큰 정수를 다루기 위한 원시 타입이 JavaScript에 추가되었고, `bigint` 이다.
            ```typescript
            // #1. BigInt 함수를 통하여 bigint 값 생성
            const oneHundred: bigint = BigInt(100)

            // #2. 리터럴 구문을 통하여 bigint 값 생성
            const anotherHundred: bigint = 100n
            ```

    - `symbol`
        - `symbol` 은 전역적으로 고유한 참조값을 생성하는 데에 사용할 수 있는 원시 타입이며, `Symbol()` 함수를 통하여 생성할 수 있다.
            ```typescript
            const firstName = Symbol('name')
            const secondName = Symbol('name')

            if(firstName === secondName){
                // This condition will always return 'false' 
                // since the types 'typeof firstName' and 'typeof secondName' have no overlap.
            }
            ```