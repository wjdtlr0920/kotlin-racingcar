# 자동차 경주 (우승자)

## 기능 요구 사항
* 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
* 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
* 자동차 이름은 쉼표(,)를 기준으로 구분한다.
* 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
* 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
* 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
* UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
* indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
  * 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  * 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
* 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
* 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
* 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
* git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.

## 추가 구현 요구사항
* 핵심 비지니스 로직을 가지는 객체를 domain 패키지, UI 관련한 객체를 view 패키지에 구현한다.
* MVC 패턴 기반으로 리팩토링해 view 패키지의 객체가 domain 패키지 객체에 의존할 수 있지만, domain 패키지의 객체는 view 패키지 객체에 의존하지 않도록 구현한다.
* Random 값 생성 로직은 어떻게 작성할 것인가?

## 실행 결과 예제
```text
경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).
pobi,crong,honux
시도할 횟수는 몇 회인가요?
5

실행 결과
pobi : -
crong : -
honux : -

pobi : --
crong : -
honux : --

pobi : ---
crong : --
honux : ---

pobi : ----
crong : ---
honux : ----

pobi : -----
crong : ----
honux : -----

pobi, honux가 최종 우승했습니다.
```

## 구현 계획
* step4 에서 리뷰 받은 사항 정리
> * 테스트 코드 명을 기획자, 디자이너... 등 다양한 사람들이 이해할 수 있도록 함수명을 이해하기 쉽게 작성
> * `CarTest` 에서 //given 에 해당하는 경우에는 FakeConstructor 를 활용해본다
> * Controller 에서 함수를 잘게 쪼개보자
> * `toList()` 부분을 코틀린에서 사용하는 방법으로 setter를 커스텀하게 만든다면 재사용 로직을 조금 더 개선 할 수 있음
> * `OutputView::showRacingResultDashboard()` 함수 변수명을 수정하거나 || data 객체를 만들어보는 것도 방법이 될 수 있을 것 같음

* 랜덤 생성 함수를 작성
* 리팩터링
  * InputView, OutputView 에서는 도메인을 알아도 되는 것일까?? 등..