# Chapter08. 몽고디비

- 몽고디비의 특징 중 하나는 자바스크립트 문법을 사용한다는 것
- RDBMS가 아니라 NoSQL이라는 것

## 📌 8.1 NoSQL vs SQL

- SQL
  - 대표적인 예, MySQL
  - 규칙에 맞는 데이터 입력
  - 테이블 간 JOIN 지원
  - 안정성, 일관성
  - 테이블, 로우, 컬럼...
- NoSQL
  - 대표적인 예, 몽고디비
  - 자유로운 데이터 입력
  - 컬렉션 간 JOIN 미지원
  - 확장성, 가용성
  - 컬렉션, 다큐먼트, 필드...

## 📌 8.2 몽고디비 설치하기

- homebrew 로 설치

  ```
  $ brew tap mongodb/brew
  $ brew install mongodb-community
  ```

- 실행

  ```
  $ brew services start mongodb-community
  ```

- 계정추가

  ```
  $ mongo
  > use admin
  > db.createUser({ user: '이름', pwd: '비밀번호', roles: ['root']})
  ```

- 몽고디비가 인증을 사용하도록 설정

  ```
  $ brew services stop mongodb-community
  $ vim /usr/local/etc/mongod.conf
  ```

  - `/usr/local/etc/mongod.conf` 에 추가

    ```
    ...
    security:
      authorization: enabled
    ```

- 계정으로 실행

  ```
  $ brew services start mongodb-community
  $ mongo admin -u [이름] -p [비밀번호]
  ```

## 📌 8.4 데이터베이스 및 컬렉션 생성하기

- 데이터베이스 생성

  ```
  > use nodejs
  ```

- 데이터베이스 목록 확인

  ```
  > show dbs
  ```

- 현재 사용중인 데이터베이스 확인

  ```
  > db
  ```

- 컬렉션 생성

  ```
  > db.createCollection('users')
  ```

- 컬렉션 목록
  ```
  > show collections
  ```

## 📌 8.5 CRUD 작업하기

- Create(생성)

  ```javascript
  db.users.save({
    name: 'zero',
    age: 24,
    married: false,
    comment: '안녕하세요. 간단히 몽고디비 사용 방법에 대해 알아봅시다.',
    createAt: new Date(),
  })
  ```

- Read(조회)

  - 전체 조회

    ```javascript
    db.users.find({})
    ```

  - 조회할 필드 설정

    ```javascript
    db.users.find({}, { _id: 0, name: 1, married: 1 }) // 1 또는 true로 표시한 필드만 가져온다.
    ```

  - 조건 추가

    - `$gt(초과), $gte(이상), $lt(미만), $lte(이하), $ne(같지 않음), $or(또는), $in(배열 요소 중 하나)`

      ```javascript
      db.users.find(
        { age: { $gt: 30 }, married: true },
        { _id: 0, name: 1, age: 1 }
      )
      ```

    - `$or`

      ```javascript
      db.users.find(
        {
          $or: [{ age: { $gt: 30 } }, { married: false }],
        },
        {
          _id: 0,
          name: 1,
          age: 1,
        }
      )
      ```

    - `sort`

      ```javascript
      db.users
        .find(
          {},
          {
            _id: 0,
            name: 1,
            age: 1,
          }
        )
        .sort({ age: -1 })
      ```

      - -1 은 내림차순, 1 은 오름차순

    - `limit`

      ```javascript
      db.users
        .find(
          {},
          {
            _id: 0,
            name: 1,
            age: 1,
          }
        )
        .sort({ age: -1 })
        .limit(1)
      ```

    - `skip`
      ```javascript
      db.users
        .find(
          {},
          {
            _id: 0,
            name: 1,
            age: 1,
          }
        )
        .sort({ age: -1 })
        .limit(1)
        .skip(1)
      ```

- Update(수정)

  ```javascript
  db.users.update(
    {
      name: 'nero', // 조건
    },
    {
      $set: {
        comment: '안녕하세요. 이 필드를 바꿔보겠습니다!', // 변경사항
      },
    }
  )
  ```

- Delete(삭제)

  ```javascript
  db.users.remove({ name: 'nero' })
  ```

## 📌 8.6 몽구스 사용하기
