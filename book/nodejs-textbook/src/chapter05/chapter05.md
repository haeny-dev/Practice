# Chapter05. 패키지 매니저

➕

## 📌 5.1 npm 알아보기

- npm은 Node Package Manager의 약어로, 이름 그대로 노드 패키지 매니저입니다.
- 대부분의 자바스크립트 프로그램은 패키지라는 이름으로 npm에 등록되어 있으므로 특정 기능을 하는 패키지가 필요하다면 npm에서 찾아 설치하면 됩니다.
- npm에 업로드된 노드 모듈을 패키지라고 부릅니다.
- 모듈이 다른 모듈을 사용할 수 있는 것처럼, 패키지가 다른 패키지를 사용할 수도 있습니다. 이런 관계를 의존 관계라고 부릅니다.

## 📌 5.2 package.json 으로 패키지 관리하기

- 설치한 패키지의 버전을 관리하는 파일이 package.json 입니다.
- npm init 명령어로 package.json 을 생성할 수 있습니다.

  ```Shell
  npm init
  This utility will walk you through creating a package.json file.
  It only covers the most common items, and tries to guess sensible defaults.

  See `npm help init` for definitive documentation on these fields
  and exactly what they do.

  Use `npm install <pkg>` afterwards to install a package and
  save it as a dependency in the package.json file.

  Press ^C at any time to quit.
  package name: (chapter05)
  version: (1.0.0)
  description:
  entry point: (index.js)
  test command:
  git repository:
  keywords:
  author:
  license: (ISC)
  About to write to /Users/haeny/dev/workspace/TIL/book/nodejs-textbook/src/chapter05/package.json:

  {
    "name": "chapter05",
    "version": "1.0.0",
    "description": "",
    "main": "index.js",
    "scripts": {
      "test": "echo \"Error: no test specified\" && exit 1"
    },
    "author": "",
    "license": "ISC"
  }

  Is this OK? (yes)
  ```

  - package name
    - 패키지의 이름입니다. package.json 의 name 속성에 저장됩니다.
  - version
    - 패키지의 버전입니다. npm의 버전은 다소 엄격하게 관리됩니다.
  - entry point
    - 자바스크립트 실행 파일 진입점입니다.
    - 보통 마지막으로 module.exports 를 하는 파일을 지정합니다.
    - package.json 의 main 속성에 저장됩니다.
  - test command
    - 코드를 테스트할 때 입력할 명령어를 의미합니다.
    - package.json scripts 속성 안의 test 속성에 저장됩니다.
  - git repository
    - 코드를 저장해둔 Git 저장소 주소를 의미합니다.
    - 나중에 소스에 문제가 생겼을 때 사용자들이 이 저장소에 방문해 문제를 제기할 수도 있고, 코드 수정본을 올릴 수도 있습니다.
    - package.json 의 repository 속성에 저장됩니다.
  - keywords
    - 키워드는 npm 공식 홈페이지에서 패키지를 쉽게 찾을 수 있도록 해줍니다.
    - package.json 의 keywords 속성에 저장됩니다.
  - license
    - 해당 패키지의 라이센스를 넣으면 됩니다.

- 라이센스

  - 오픈 소스라고 해서 모든 패키지를 아무런 제약 없이 사용할 수 있는 것은 아닙니다.
  - 라이센스별로 제한 사항이 있으므로 설치 전에 라이센스를 확인해야 합니다.

- `npm install [패키지명]` 으로 패키지를 설치할 수 있습니다.

  - package.json 의 dependencies 속성에 저장됩니다.
  - `--save` 명령어를 붙이는 경우도 있는데 npm@5 부터는 기본값으로 설정되어 있으므로 따로 붙이지 않아도 됩니다.
  - 여러개를 설치 시에는 `npm install [패키지1] [패키지2] ...` 와 같이 나열하면 됩니다.
  - npm install 명령어는 npm i 로 줄여 쓸 수 있습니다.

- 개발용 패키지를 설치할 수도 있습니다.

  - 실제 배포 시에는 사용되지 않고 개발 중에만 사용되는 패키지들입니다.
  - `npm install --save-dev [패키지명] ...` 로 설치합니다.
  - package.json 의 devDependencies 속성에 저장됩니다.
  - --save-dev 옵션은 -D 로 줄여 써도 됩니다.

- npm 에는 전역(global) 설치라는 옵션도 있습니다.
  - 패키지를 현재 폴더의 node_modules에 설치하는 것이 아니라 npm이 설치되어 있는 폴더에 설치합니다.
  - 이 폴더의 경로는 보통 시스템 환경 변수에 등록되어 있으므로 전역 설치한 패키지는 콘솔의 명령어로 사용할 수 있습니다.
  - --global 옵션은 -g 로 줄여 써도 됩니다.

## 📌 5.3 패키지 버전 이해하기

## 📌 5.4 기타 npm 명령어

## 📌 5.5 패키지 배포하기
