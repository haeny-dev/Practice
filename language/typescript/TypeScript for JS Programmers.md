# 📌 TypeScript for JavaScript Programmers

## ➕ 타입 추론, Types by Inference
- TypeScript는 JavaScript 언어를 알고 있으며 대부분의 경우 타입을 생성해줄 것이다.
- JavaScript가 동작하는 방식을 이해함으로써 TypeScript는 JavaScript 코드를 받아들이면서 타입을 가지는 타입 시스템을 구축할 수 있다.  
이는 코드에서 타입을 명시하기 위해 추가로 문자를 사용할 필요가 없는 타입 시스템을 제공한다.

    ```javascript
    let helloWorld = 'Hello World'
    ```
    - 변수를 생성하면서 동시에 특정 값에 할당하는 경우, TypeScript는 그 값을 해당 변수의 타입으로 사용할 것이다.
    - TypeScript가 `helloWorld`가 `string` 임을 알게 되는 방식이다.

## ➕ 타입 정의하기, Defining Types
- JavaScript는 다양한 디자인 패턴을 가능하게 하는 동적 언어이다.
- 몇몇 디자인 패턴은 동적 프로그래밍을 하고 있어 자동으로 타입을 제공하기 힘들 수 있는데,  
이러한 경우에 TypeScript는 TypeScript에게 타입이 무엇이 되어야 하는지 명시 가능한 JavaScript 언어의 확장을 지원한다.

- 예를 들어,
    - `name: string` 과 `id: number` 을 포함하는 추론 타입을 가진 객체 생성 시

        ```javascript
        const user = {
            name: 'Hayes',
            id: 0,
        }
        ```

    - 이 객체의 형태를 명시적으로 나타내기 위해 interface로 선언
        ```javascript
        interface User{
            name: string
            id: number
        }
        ```

    - 변수 선언 뒤에 `: TypeName` 구문을 사용해 JavaScript 객체가 새로운 interface의 형태를 따르고 있음을 선언할 수 있다.
        ```javascript
        const user: User = {
            name: 'Hayes',
            id: 0
        }
        ```

    - 해당 인터페이스에 맞지 않는 객체를 생성하면 TypeScript는 경고를 준다.
        ```javascript
        const user: User = {
            username: 'Hayes',
            id: 0
        }   // @errors: 2322
        ```

    - JavaScript는 클래스와 객체지향프로그래밍을 지원하기 때문에, TypeScript 또한 동일하여 인터페이스는 클래스로도 선언할 수 있다.
        ```javascript
        class UserAccount {
            name: string
            id: number

            constructor(name: string, id: number){
                this.name = name
                this.id = id
            }
        }
        
        const user: User = new UserAccount('Mulphy', 1)
        ```
    
    - 인터페이스는 함수에서 매개변수와 리턴 값을 명시하는데 사용되기도 한다.
        ```javascript
        function getAdminUser(): User {
            //...
        }

        function deleteUser(user: User){
            //...
        }
        ```

- JavaScript에서 사용할 수 있는 적은 종류의 원시 타입이 이미 존재한다.
    - `boolean`, `bigint`, `null`, `number`, `string`, `symbol`, `object`, `undefined` 

<br>

- TypeScript는 몇 가지를 추가하였다.
    - `any`: 무엇이든 허용합니다.
    - `unknown`: 이 타입을 사용하는 사람이 타입이 무엇인지 선언했는가를 확인하십시오.
    - `never`: 이 타입은 발생될 수 없습니다.
    - `void`: `undefined` 를 리턴하거나 리턴 값이 없는 함수

## ➕ 타입 구성, Composing Types
- 객체들을 조합하여 더 크고 복잡한 객체를 만드는 방법과 유사하게 TypeScript에 타입으로 이를 수행하는 도구가 있다.
- 여러가지 타입을 이용하여 새 타입을 작성하기 위해 가장 많이 사용되는 코드로는 유니언(Union)과 제네릭(Generic)이 있다.

    **유니언(Unions)**

    - 유니언은 타입이 여러 타입 중 하나일 수 있음을 선언하는 방법이다.

        ```javascript
        type MyBool = true | false
        ```

    - 유니언 타입이 가장 많이 사용된 사례 중 하나는 값이 다음과 같이 허용되는 `string` 또는 `number`의 리터럴집합을 설명하는 것이다.
        ```javascript
        type WindowStates = 'open' | 'closed' | 'minimized'
        type LockStates = 'locked' | 'unlocked'
        type OddNumbersUnderTen = 1 | 3 | 5 | 7 | 9
        ```

    - 유니언은 다양한 타입을 처리하는 방법을 제공한다.
        ```javascript
        function getLength(obj: string | string[]){
            return obj.length
        }
        ```
    
        - 코드가 시간에 따라 변수가 변경되는 방식을 이해하여 검사를 통해 타입을 골라낼 수 있다.

            ```javascript
            function wrapInArray(obj: string | string[]){
                if(typeof obj === 'string'){
                    return [obj]
                }

                return obj
            }
            ```

    **제너릭(Generics)**
    - 제너릭은 타입에 변수를 제공하는 방법이다.
    - 일반적인 예시로 배열에 제너릭이 없다면 어떤 것이든 포함할 수 있고, 제너릭이 있는 배열이라면 배열 안의 값을 설명할 수 있다.

        ```javascript
        type StringArray = Array<string>
        type NumberArray = Array<number>
        type ObjectWithNameArray = Array<{name: string}>
        ```
    - 제너릭을 사용하는 고유 타입을 선언할 수 있다.
        ```javascript
        interface Backpack<Type> {
            add: (obj: Type) => void
            get: () => Type
        }

        // TypeScript에 'backpack' 이라는 상수가 있음을 알리는 지름길이다
        declare const backpack: Backpack<string>
        
        // 위에서 Backpack의 변수로 string을 선언해서, object는 string이다.
        const object = backpack.get()

        // backpack의 변수가 string이므로 add 함수에 number를 전달할 수 없다.
        backpack.add(23)    //  @errors: 2345 
        ```

## ➕ 구조적 타입 시스템, Structural Type System
- TypeScript의 핵심 원칙 중 하나는 타입 검사가 값이 있는 **형태**에 집중한다는 것이다. 이는 `덕 타이핑(duck typing)` 또는 `구조적 타이핑` 이라고 불린다.
- 구조적 타입 시스템에서 두 객체가 같은 형태를 가지면 같은 것으로 간주된다.

    ```javascript
    interface Point {
        x: number
        y: number
    }

    function printPoint(p: Point){
        console.log(`${p.x}, ${p.y}`)
    }

    const point = { x: 12, y: 26}
    printPoint(point)   // "12, 26" 를 출력한다.
    ```

    - `point` 변수는 `Point` 타입으로 선언된 적이 없지만, TypeScript는 타입 검사에서 `point`의 형태와 `Point`의 형태를 비교하는데,  
    둘 다 같은 형태이기 때문에, 통과한다.

<br>

- 형태 일치에는 일치시킬 객체의 필드의 하위 집합만 필요하다.

    ```javascript
    const point3 = {x: 12, y:26, z: 89}
    printPoint(point3)      // 12, 26

    const rect = {x: 33, y: 3, width: 30, height: 80}
    printPoint(rect)        // 33, 3
    
    const color = {hex: '#187ABF'}
    printPoint(color)       // @errors: 2345
    ```

- 구조적으로 클래스와 객체가 형태를 따라는 방법에도 차이가 없다.

    ```javascript
    class VirtualPoint{
        x: number
        y: number

        constructor(x: number, y: number){
            this.x = x
            this.y = y
        }
    }

    const newVPoint = new VirtualPoint(13, 56)
    printPoint(newVPoint)   // 13, 56
    ```