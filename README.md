# kotlin-racingcar

## STEP1 (1단계 - 코틀린 기초)
### 실습 환경 구축
[자동차 경주 저장소](https://github.com/next-step/kotlin-racingcar)를 기반으로 미션을 진행한다. [온라인 코드 리뷰 요청 1단계 문서](https://github.com/next-step/nextstep-docs/blob/master/codereview/review-step1.md)를 참고해 실습 환경을 구축한다.
1. 미션 시작 버튼을 눌러 미션을 시작한다.
2. 저장소에 자신의 GitHub 아이디로 된 브랜치가 생성되었는지 확인한다.
3. 저장소를 [자신의 계정](https://github.com/wjdtlr0920/kotlin-racingcar)으로 Fork 한다.
4. 요구 사항에 대한 구현을 완료한 후, 작업이 다 되었으면 Push를 한다.
5. kotlin-racingcar에서 Pull Request를 작성한다.
6. 리뷰 받은 내용을 토대로 코드를 리팩터링하고 다시 Push를 한다.
7. 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.
   
   
+ 코드리뷰 요청 1단계 [[동영상]](https://www.youtube.com/watch?v=YkgBUt7zG5k) [[문서]](https://github.com/next-step/nextstep-docs/blob/master/codereview/review-step1.md)
+ 코드리뷰 요청 2단계 [[동영상]](https://www.youtube.com/watch?v=HnTdFJd0PtU) [[문서]](https://github.com/next-step/nextstep-docs/blob/master/codereview/review-step2.md)
+ 코드리뷰 요청 3단계 [[동영상]](https://www.youtube.com/watch?v=fzrT3eoecUw) [[문서]](https://github.com/next-step/nextstep-docs/blob/master/codereview/review-step3.md)

### 자바-코틀린 변환기
새로운 언어를 배워 써먹을 만큼 숙련도를 높이려면 많이 노력해야 한다. 코틀린을 처음 배웠는데 정확한 코틀린 문법이 기억나지 않는 경우 유용하게 써먹을 수 있다.

+ 작성하고픈 코드를 자바로 작성해 복사한 후 코틀린 파일에 그 코드를 붙여 넣는다.
+ Code > Convert Java File to Kotlin File(⌥⇧⌘K, Ctrl+Shift+Alt+K)을 선택한다.



## STEP2 (2단계 - 문자열 계산기)
### 기능 요구 사항
+ 사용자가 입력한 문자열 값에 따라 사칙 연산을 수행할 수 있는 계산기를 구현해야 한다.
+ 문자열 계산기는 사칙 연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
+ 예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.

### 프로그래밍 요구 사항
+ 메서드가 너무 많은 일을 하지 않도록 분리하기 위해 노력해 본다.

### 힌트
테스트할 수 있는 단위로 나누어 구현 목록을 만든다.

+ 덧셈, 뺄셈, 곱셈, 나눗셈
+ 입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
+ 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
+ 사칙 연산을 모두 포함하는 기능 구현
+ 공백 문자열을 빈 공백 문자로 분리하려면 String 클래스의 split(" ") 메소드를 활용한다. 반복적인 패턴을 찾아 반복문으로 구현한다.

### 추가 기능요구사항
+ 클래스, 함수, 변수명은 이름만으로 의도가 전달되도록 작성
+ 불필요한 주석 제거 및 public한 클래스나 함수를 KDoc기반 주석으로 작성(수학적인 공식, 외부에 의한 요인, 특정상황의 성능차이등 협업시 필요한 정보 제외)
+ 자주 접근해 사용해야 하는 기능이 있는 경우에는 instance 생성보다 object class로 가는게 좋음
+ require(IllegalArgumentException), check(IllegalStateException)로 유효성 검증 가능
+ 사칙연산 뿐만 아니라 연산자 부호 추가 등 확장을 고려한 설계 필요
+ 하드코딩보단 상수 값을 따로 분리해서 사용하는게 가독성이 더 좋음
+ mutable보단 immutable로 컬렉션 사용하는게 좋음
+ depth는 최대한 적게 가져가려고 노력해야하며 함수 분리를 잘하면 좋음
+ 다양한 테스트 조건 추가
+ README 작성시 개발항목 산출과 정리가 좀 더 용이해지고 프로젝트의 대한 가독성도 높아지는 효과가 있음