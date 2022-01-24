# 📌 The Basics

- JavaScript의 모든 값은 저마다 다양한 동작을 내장하고 있으며 이는 다양한 연산(Operation)을 실행하여 확인할 수 있다.

    - 간단한 예시로 `message` 라는 이름의 변수로 연산들을 살펴보자

        ```javascript
        // 'message'의 프로퍼티 'toLowerCase'에 접근한 뒤 호출
        message.toLowerCase()

        // 'message'를 호추루
        message()
        ```

        - 첫 번째 실행 코드 줄에서는 `toLowerCase` 라는 프로퍼티에 접근한 뒤 호출
        - 두 번째 줄에서는 `message` 를 직접 호출
        - 하지만, `message` 의 값이 무엇인지 모른다면 위 코드의 실행 결과가 무엇인지 확실히 말할 수 없다.
            - `message` 가 호출 가능한가?
            - `toLowerCase` 라는 프로퍼티를 가지는가?
            - 만약 가진다면, `toLowerCase` 또한 호출 가능한가?
            - 만약 두 값이 모두 호출 가능하다면, 각각이 무엇을 반환하는가?

    - `message` 가 아래와 같이 정의되었다고 하자.

        ```javascript
        const message = 'Hello World!'
        ```

        - `message.toLowerCase()` 를 실행하면, 해당 문자열이 소문자로만 이루어져 있는 값을 얻을 것이다.
        - `message()` 는 예외와 함께 실행되지 않을 것이다.
            - `TypeError: message is not a function`

> JavaScript 런타임은 코드가 **실행될 때** 자신이 무엇을 해야 할지 결정하기 위하여 값의 타입,   
> 즉 해당 값이 어떤 동작과 능력을 가지고 있는지를 확인한다.
u
- 일부 값들, 이를 테면 `string` 과 `number` 같은 원시 타입의 값의 경우 `typeof` 연산자를 사용하면 각 값들의 타입을 실행 시점에 알 수 있다.
- 하지만 그 밖의 값들, 이를 테면 함수값의 경우, 앞서 언급된 방식과 같이 타입을 알 수 있는 매커니즘이 존재하지 않는다.

    ```javascript
    function fn(x){
        return x.flip()
    }
    ```
    - 위 코드를 보면, 인자로 전달된 객체가 호출 가능한 프로퍼티인 `flip` 을 가져야만 위 함수가 잘 작동할 것이다.
    
    - 하지만, JavaScript는 우리가 알고 있는 이러한 정보를 코드가 실행되는 동안 알지 못한다.
    - 이와 같은 코드는 실행 전에 예측을 어렵게 만든다. 다시 말해 코드가 어떤 동작 결과를 보일지 코드를 작성하는 동안에는 알기 어렵다.
    - 이런 측면에서 볼 때, 타입(Type) 이란 어떤 값이 `fn` 으로 전달될 수 있고, 어떤 값은 실행에 실패할 것임을 설명하는 개념이다.

- JavaScript는 오직 동적 타입만을 제공하며, 코들를 실행해야만 어떤 일이 벌어지는지 비로소 확인할 수 있다.
- **이에 대한 대안은 정적 타입 시스템을 사용하여 코드가 실행되기 전에 코드에 대하여 예측하는 것이다.**

## ➕ 정적 타입 검사

- 대부분의 사람들은 코드를 실행했을 때 오류를 보고 싶지 않고, 새로운 코드를 작성할 때 새로운 버그를 만들어내지 않도록 최선을 다한다.
    - 여기서 만약 약간의 코드를 추가하고 파일을 저장한 뒤, 코드를 다시 실행했을 때 바로 오류가 확인된다면, 문제를 신속하게 격리시킬 수 있을 것이다.

    - 하지만, 기능을 충분히 테스트하지 않아서, 잠재적인 오류를 미처 발견하지 못할 수 도 있다. 또는 운 좋게 오류를 발견했더라도, 결국 상당한 규모의 리팩토링을 거치고 새 코드를 추가하면서 의도치 않게 코드를 깊게 파헤치게 될 수도 있다.


- *이상적으로는, 코드를 실행하기 전에 이러한 버그를 미리 발견할 수 있는 도구가 있다면 좋을 것이다.*
- **TypeScript와 같은 정적 타입 검사기의 역할이 바로 그것이다.**
    - 정적 타입 시스템은 우리가 작성한 프로그램에서 사용된 값들의 형태와 동작을 설명한다. 
    - TypeScript와 같은 타입 검사기는 이 정보를 활용하여 프로그램이 제대로 작동하지 않을 때 우리에게 알려준다.

        ```javascript
        const message = 'hello'
        message()   
        // This expression is not callable.
        // Type 'String' has no call signatures
        ```

## ➕ 예외가 아닌 실행 실패
- 지금까지 런타임 오류에 대해서 다루었다. 이는 JavaScript 런타임이 무언가 이상하다고 우리에게 직접 말해주는 경우에 해당한다.
    - 이러한 오류는 예기치 못한 문제가 발생했을 때 JavaScript가 어떻게 대응해야 하는지 ECMAScript명세에서 명지적인 절자를 제공하기 때문에 발생하는 것이다.
        - 예를들어, 명세에 따르면 호출 가능하지 않은 것에 대하여 호출을 시도할 경우 오류가 발생한다.
        - 이는 당연한 동작처럼 들릴 수 있으나, 누군가는 객체에 존재하지 않는 프로퍼티에 접근을 시도했을 때에도 역시 오류를 던져야 한다고 생각할 수 있다.
        - 하지만, 그 대신 JavaScript는 전혀 다르게 반응하며 `undefined` 를 반환한다.

            ```javascript
            const user = { name: 'Daniel', age: 26 }
            user.location   // undefined
            ```

- 궁극적으로, 정적 타입 시스템은 어떤 코드가 오류를 발생시키지 않는 *유효한* JavaScript 코드일지라도, 정적 타입 시스템 내에서 오류로 간주되는 경우라면 이를 알려준다.

    ```javascript
    const user = { name: 'Daniel', age: 26 }
    user.location
    // Property 'location' does not exist on type '{ name: string; age: number; }'
    ```

- 비록 때로는 이로 인하여 표현의 유연성을 희생해야 하지만, 이렇게 함으로서 명시적인 버그는 아니지만 버그로 타당히 간주되는 경우를 잡아내는 데 그 목적이 있다.
- 그리고, TypeScript는 이러한 겉으로 드러나지 않는 버그를 꽤 많이 잡아낸다.

    ```javascript
    /* 오타 */
    const announcement = 'Hello World!'
    
    announcement.toLocaleLowercase()    // 오타
    announcement.toLocalLowerCase()     // 오타
    
    announcement.toLocaleLowerCase()    // 맞는 표현

    /* 호출되지 않은 함수 */
    function flipCoin(){
        return Math.random < 0.5 // Operator '<' cannot be applied to types '() => number' and 'number'
    }
    

    /* 기본적인 논리 오류 */
    const value = Math.random() < 0.5 ? 'a' : 'b'
    if(value !== 'a'){
        //...
    } else if (value === 'b'){
        // This condition will always return 'false' since the types 'a' and 'b' have no overlap
    }
    ```

## ➕ 프로그래밍 도구로서의 타입

- TypeScript는 우리가 코드 상에서 실수를 저질렀을 때 버그를 잡아준다.
- TypeScript는 여기서 더 나아가 우리가 실수를 저지르는 바로 그 순간 이를 막아준다.
    - 타입 검사기는 우리가 변수 또는 다른 프로퍼티 상의 올바른 프로퍼티에 접근하고 있는지 여부를 검사할 수 있도록 관련 정보들을 가지고 있다.
    - 이 정보를 활용하면 타입 검사기는 우리가 사용할 수 있는 프로퍼티를 **제안** 할 수 있게된다.
    
- 즉, TypeScript는 코드 수정에 활용될 수 있고, 우리가 코드를 입력할 때 오류 메시지를 제공하거나 코드 완성 기능을 제공할 수 있다.
    - TypeScript는 프로그래밍 도구를 중요하게 생각하며, 여기에는 코드 완성 및 오류 메시지 기능 이외에도 다양한 것이 포함된다.
        - TypeScript를 지원하는 코드 편집기는 오류를 자동으로 고쳐주는 "Quick Fixes",
        - 코드를 간편하게 재조직하는 리팩토링,
        - 변수의 정의로 빠르게 이동하는 유용한 네비게이션,
        - 주어진 변수에 대한 모든 참조 검색 등의 기능들을 제공한다.
    - 이 모든 기능들은 타입 검사기를 기반으로 하며 완전히 크로스 플랫폼으로 동작한다.

## ➕ `tsc`, TypeScript 컴파일러
- 타입스크립트 설치

    ```
    npm install typescript
    ```
    
- 타입스크립트 코드작성
    ```javascript
    console.log('Hello world!')
    ```

- `tsc` 명령어 실행
    ```
    tsc src/hello.ts
    ``` 
    - 실행 결과 아무 일도 일어나지 않는다. 타입 오류가 없었으니, 아무것도 보고될 것이 없고 아무런 출력이 나타나지 않았다.
    - 하지만, 파일 출력을 얻을 수 있다. `hello.ts` 파일 옆에 `hello.js` 파일이 생성된 것을 확인할 수 있다.
    - 이것이 `tsc` 가 우리의 `hello.ts` 파일을 JavaScript 파일로 컴파일 또는 변형한 결과물이다.
        - 컴파일러는 사람이 작성한 듯이 깔끔하고 읽을 수 있는 코드를 만들어내고자 시도한다.
        - TypeScript는 일관성 있게 들여 쓰기를 수행하고, 여러 줄에 걸쳐 코드가 작성되는 것을 감안하고, 코드 주변에 작성된 주석도 잘 배치해둔다.

- 타입 검사 오류

    ```javascript
    function greet(person, date){
        console.log(`Hello ${person}, today is ${date}!`)
    }

    greet('Brendan')
    ```
    - `tsc` 명령 실행 시

        ```shell
        error TS2554: Expected 2 arguments, but got 1.

        5 greet('Brendan')
        ~~~~~~~~~~~~~~~~

        src/hello.ts:1:24
            1 function greet(person, date){
                                    ~~~~
            An argument for 'date' was not provided.


        Found 1 error.
        ```
        - TypeScript는 `greet` 함수에 인자를 전달하는 것을 깜빡했다고 말해주고 있다.

    - 새로 생성 된 `hello.js`

        ```javascript
        function greet(person, date) {
            console.log("Hello ".concat(person, ", today is ").concat(date, "!"));
        }
        greet('Brendan');
        ```
        - 실질적으로 `hello.ts` 와 동일하다는 것을 알 수 있다. 이것은 TypeScript의 핵심 가치 중 하나에 기반한 동작이다.
        - 코드에 대한 타입 검사는 프로그램이 실행할 수 있는 동작을 제한한다. 따라서, 타입 검사가 허용 또는 제한하는 동작의 범위에는 어느 정도 절충과 타협이 존재한다.
        - 대부분의 경우 문제가 발생하지 않지만, 타입 검사가 방해가 되는 시나리오 또한 존재한다.

            - 예를 들어, JavaScript로 작성된 코드를 TypeScript로 마이그레이션하는 과정에서 타입 검사 오류가 발생하는 경우
            - 결국에는 타입 검사를 통과하도록 코드를 수정해나가겠지만, 사실 원본 JavaScript 코드는 이미 제대로 작동하고 있는 상태였다.
            - TypeScript로 변환하는 작업 때문에 코드 실행이 중단되어야 할 필요가 없는 것이다.
            - 그래서 TypeScript는 방해하지 않는다.

        - TypeScript가 보다 엄격하게 동작하기를 원할 수도 있다.
            - 이 경우 `--noEmitOnError` 컴파일러 옵션을 사용하면 된다.
            
## ➕ 명시적 타입
- 코드 수정
    ```javascript
    function greet(person: string, date: Date){
        console.log(`Hello ${person}, today is ${date.toDateString()}!`)
    }
    ```
    - TypeScript가 `person` 이 `string` 이고 `date` 가 `Date` 객체이어야 한다는 것을 알려주도록 한다.
    - 해당 시그니처는 "greet는 string 타입의 person과 Date 타입의 date을 가진다" 고 해석할 수 있다.
    - 이것이 있다면, TypeScript는 우리가 해당 함수를 올바르게 못하게 사용할 경우 알려준다.

        ```javascript
        function greet(person: string, date: Date){
            console.log(`Hello ${person}, today is ${date.toDateString()}!`)
        }

        greet('Maddison', Date())
        // Argument of type 'string' is not assignable to parameter of type 'Date'.
        ```
        - JavaScript에서 `Date()`를 호출하면 `string`을 반환한다. 
        - `new Date()` 를 사용하여 `Date` 타입을 생성해야 비로소 처음 기대했던 결과를 얻을 수 있다.
    
            ```javascript
            function greet(person: string, date: Date){
                console.log(`Hello ${person}, today is ${date.toDateString()}!`)
            }

            greet('Maddison', new Date())
            ```

- 명시적인 타입 표기를 항상 작성할 필요는 없다. 많은 경우, TypeScript는 생략된 타입 정보를 추론할 수 있다.

    ```javascript
    let msg = 'hello there!'
    ```
    - `msg` 가 `string` 타입을 가진다는 사실을 TypeScript에게 알려주지 않았더라도 TypeScript는 이를 알아낼 수 있다.
    - 기본 기능이며, 타입 시스템이 알아서 올바른 타입을 어떻게든 잘 알아낼 수 있다면 타입 표기를 굳이 적지 않는 것이 가장 좋다.

## ➕ 지워진 타입
- `hello.ts` 를 `tsc`로 컴파일 한 JavaScript 출력

    ```javascript
    function greet(person, date) {
        console.log("Hello ".concat(person, ", today is ").concat(date.toDateString(), "!"));
    }
    greet('Maddison', new Date());
    ```
    - `person` 과 `date` 인자는 더 이상 타입 표기를 가지지 않는다.
    - 타입 표기는 JavaScript(또는 엄밀히 말하여 ECMAScript)의 일부가 아니므로, TypeScript를 수정 없이 그대로 실행할 수 있는 브라우저나 런타임은 현재 존재하지 않는다.
    - 이것이 TypeScript를 사용하고자 할 때 다른 무엇보다도 컴파일러가 필요한 이유이다.
    - TypeScript 전용 코드를 제거하거나 변환하여 실행할 수 있도록 만들 방법이 필요하다.

## ➕ 다운레벨링
- `hello.ts` 를 `tsc`로 컴파일 한 JavaScript 출력

    ```javascript
    function greet(person, date) {
        console.log("Hello ".concat(person, ", today is ").concat(date.toDateString(), "!"));
    }
    greet('Maddison', new Date());
    ```

    - 템플릿 문자열은 ECMAScript 2015(a.k.a ECMAScript 6, ES2015, ES6 등)라고 불리는 버전의 ECMAScript에서 등장한 기능이다.

    - TypeScript는 새 버전의 ECMAScript의 코드를 ECMAScript3 또는 ECMAScript 5와 같은 보다 예전 버전의 것들로 다시 작성해준다.
    - 새로운 또는 '상위' 버전의 ECMAScript를 예전의 또는 '하위' 버전의 것으로 바꾸는 과정을 **다운레벨링**이라 부르기도 한다.

- TypeScript는 ES3라는 아주 구버전의 ECMAScript를 타겟으로 동작하는 것이 기본동작이다.
- `--target` 플래그를 설정하면 보다 최근 버전을 타겟으로 변환을 수행할 수도 있다. 
    - `--target es2015` 를 실행하면 TypeScript가 ECMAScript2015를 타겟으로 동작할 수 있으며, 이는 ECMAScript 2015가 지원되는 런타임이기만 하면 해당 코드가 실행될 수 있도록 변환된다는 의미이다.
    - `tsc --target es2015 hello.ts` 실행 결과

        ```javascript
        function greet(person, date) {
            console.log(`Hello ${person}, today is ${date.toDateString()}!`);
        }
        greet('Maddison', new Date());
        ```

## ➕ 엄격도
- TypeScript의 타입 검사기를 사용하는 목적은 사용자마다 다양하다.
- 누군가는 프로그램 일부만 타입 검사를 수행하는 느슨한 수준을 유지하면서도, 유용한 프로그래밍 도구로서의 기능은 온전히 활용하고 싶을 수 있다.

    - 이는 TypeScript를 사용할 때 기본으로 제공한고자 하는 경험이다.

    - 타입 검사는 선택 사항이며, 타입 추론은 가장 관대한 기준으로 이루어지고, 잠재적인 `null/undefined` 값에 대한 검사는 이루어지지 않는다.

- 이와 반대로, 대다수의 사용자들은 TypeScript가 최대한으로 타입 검사를 수행해주기를 선호한다.

    - 이것이 TypeScript에서 엄격도 설정을 제공하는 이유이기도 하다.

    - 엄격도 설정을 활용하면 정적 타입 검사기를 마치 스위치 수준의 장치에서 마치 다이얼에 가까운 장치로 만들수 있다.

        - 다이얼을 멀리 돌릴수록, TypeScript는 더 많은 것을 검사해줄 것이다.
        - 그러면 할 일이 조금 더 생기겠지만, 길게 봤을 때 분명 그만한 가치가 있으며, 보다 철저한 검사와 정밀한 도구 기능을 사용할 수 있게 된다.
        - 가능하다면, 새로 작성하는 코드에서는 항상 엄격도를 활성화해야 한다.

- TypeScript에는 타입 검사 엄격도 플래그가 몇 가지 존재한다.
    - `strict`
        - CLI에서 `--strict` 플래그를 설정하거나 `tsconfig.json`에 `"strict": true` 를 추가하면 모든 플래그를 동시에 활성화하게 된다.

    - `noImplicitAny`
        - 몇몇 경우에서 TypeScript는 값의 타입을 추론하지 않고 가장 관대한 타입인 `any` 로 간주한다.
        - 프로그램에서 타입을 더 구체적으로 사용할수록, 더 많은 유효성 검사와 도구 기능을 사용할 수 있으며, 이는 곧 코드 상에서 보다 적은 버그를 발생시킨다는 의미다.
        - `noImplicitAny` 플래그를 활성화하면 타입이 `any` 로 암묵적으로 추론되는 변수에 대하여 오류를 발생시킨다.

    - `strictNullChecks`
        - `null` 과 `undefined` 와 같은 값은 다른 타입의 값에 할당할 수 있는 것이 기본동작이다.
        - 하지만, `null` 과 `undefined` 의 처리를 잊는 것은 세상의 샐 수 없는 많은 버그들의 원인이다.
        - `strictNullChecks` 플래그는 `null` 과 `undefined` 를 보다 명시적으로 처리하며, `null` 및 `undefined` 처리를 잊었는지 여부를 걱정하는데서 우리를 해방시켜 준다.
        







    
    




    
