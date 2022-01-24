ty# 📌 The Basics

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



    
    




    
