# 키오스크 프로젝트 README<br><br>
# 목차
## 1. Main 클래스

## 2. MenuItem 클래스

## 3. Menu 클래스

## 4. Bucket 클래스

## 5. User 클래스

## 6. Kiosk 클래스

<br>
<br>

Main 클래스<br>
===
: 프로그램 실행 시 시작점인 메인함수가 있는 클래스이다.
- 메뉴 리스트 선언
    - 추후에 설명할 MenuItem 객체 즉 상품을 담는 리스트를 종류에 따라 햄버거, 음료, 사이드 메뉴 세 가지를 선언했다.
    - 하위에 들어갈 객체들도 직접 작성하여 각 리스트에 삽입했다. 
    - 추후 키오스크 기능을 활용할 때 사용할 데이터를 준비하는 작업을 한 것이다.
- 카테고리 리스트 선언
    - 각 하위 메뉴들을 저장하는 상위 리스트로써 카테고리 리스트를 선언하고 각 메뉴 리스트를 삽입했다.
- Kiosk 객체, Bucket 객체 생성
    - 추후 각 클래스 설명에서 자세하게 다루겠으나 키오스크 프로그램 흐름을 담당하는 함수를 사용하고 활용에 필요한 데이터 및 함수를 사용하기 위해 필요한 객체들을 생성했다.
- kiosk.start() 호출
    - 프로그램 흐름을 담당하는 start 메서드를 호출했다.
<br>
<br>

MenuItem 클래스<br>
===
: 특정한 항목의 속성과 기능이 정의된 클래스이다.
- 속성
  - 이름
  - 가격
  - 설명
- __메서드__
  - 항목 속성 전체 출력: 메뉴에서 보여주기 위해 한번에 속성을 출력하는 함수이다.
  - 항목의 이름 반환: private으로 선언된 이름 속성을 반환한다.
  - 항목의 가격 반환: private으로 선언된 가격 속성을 반환한다.
  - 항목의 설명 반환: private으로 선언된 설명 속성을 반환한다.
<br>
<br>

Menu 클래스<br>
===
: MenuItem 클래스를 관리하는 카테고리를 담당하는 클래스이다.
- categoryName 배열: 각 메뉴의 카테고리의 이름을 배열로 만들어 저장했다.
  - Burgers
  - Beverage
  - Side
- 메뉴들을 저장해놓은 리스트들을 저장하는 카테고리 리스트를 선언해두었다.
- __메서드__
  - private으로 선언된 categoryName과 category를 사용하기 위해 각각 반환 함수를 public으로 만들었다.
<br>
<br>

Bucket 클래스<br>
===
: 장바구니를 관리하는 클래스이다.
- private Map<String, Map<Double, Integer>> bucketList;
  - String: 장바구니에 담은 메뉴 이름을 저장하는 변수의 타입
  - Double: 장바구니에 담은 메뉴 가격을 저장하는 변수의 타입
  - Integer: 장바구니에 담은 메뉴의 개수를 저장하는 변수의 타입
- __메서드__
  - getBucketList메서드: private으로 선언된 bucketList를 반환하는 함수이다.
  - getSelectedMenuList메서드: 장바구니에 담긴 메뉴들을 출력하는 함수이다.
  - getCount메서드: 장바구니 내 특정 메뉴의 개수를 반환하는 함수이다.
  - addCount메서드: 장바구니에 메뉴를 추가할 시 개수가 1개 증가하도록 하는 함수이다.
  - getTotalPrice메서드: 총 금액을 반환하는 함수이다.
  - deleteBucketList메서드: 장바구니의 모든 내역을 지우는 함수이다.
  - removeOneBucketMenu메서드: 장바구니에 담은 메뉴 중 한 메뉴를 선택하여 삭제해버리는 함수이다.
<br>
<br>

User 클래스<br>
===
: 사용자를 국가유공자, 군인, 학생, 일반인 4가지로 분류하여 상수로 해두고 사용자 분류에 따른 할인율을 속성으로 두었다.
- __메서드__해시법
: 일정한 규칙으로 늘어서 있는 데이터 모임에서 효율적으로 검색한다.

- 사용: 정렬되어 있는 데이터 모임에서 검색한다.

- 체인법

- 오픈 주소법
  - getDiscount메서드: 사용자에 따른 할인율 속성이 private으로 선언되었기 때문에 이를 반환하는 함수를 작성했다.
  - printDiscountList메서드: 사용자에 따른 할인율 차이를 보여주기 위해 사용자와 할인율을 출력하는 함수이다.
  <br>
  <br>

  Kiosk 클래스<br>
  ===
  : 관리자용 클래스로 프로그램의 전체적인 흐름을 담당하는 start 함수가 해당 클래스 내부에 있다.
- 선택한 메뉴의 이름, 가격, 설명을 private으로 하여 선언해뒀다.
- __메서드__
  - start메서드: 프로그램의 전체적인 흐름을 담당하는 함수로 0~5번까지 중 하나의 정수를 입력하면 그에 맞는 기능이 실행된다. 해당 기능은 다른 함수에서 구현해두었고 switch-case문 내에서 입력받은 숫자와 case의 숫자가 일치할 때 대응하는 함수가 호출된다.
    - while문을 통해서 특정한 값을 입력받지 않는 이상 키오스크 프로그램은 무한반복된다.
    - 4번과 5번 항목은 장바구니에 품목이 담겼을 때만 제공되는 기능이기 때문에 그 전에 4 또는 5를 입력받을 시 지원하지 않는 번호임을 출력하고 다시 입력을 받도록 구현했다.
  - printCategory메서드: 메인메뉴를 출력하는 함수이다.
    - 장바구니에 담은 품목이 없으면 0~1번까지 종료(0번), 햄버거 카테고리, 음료 카테고리, 사이드 카테고리가 출력된다.
    - 장바구니에 품목을 담은 경우 4번과 5번이 추가되는데 주문 옵션과, 장바구니 옵션이다.
  - printMenu메서드: 1~3번 중 하나의 옵션을 선택할 시 printMenu메서드에 의해 입력한 숫자에 대응하는 카테고리의 하위 메뉴들이 출력된다.
  - printSelectedMenu: 하위 메뉴들 중 선택한 메뉴의 이름, 가격, 설명을 출력하는 함수이다.
  - menuSelect메서드: 하위 메뉴를 선택할 때 리스트의 범위를 벗어나는 입력을 방지하는 조건을 작성해두었다.
    - 기대하는 입력과 다른 형식의 입력이 발생할 시를 우려해 예외처리를 해두었다.
  - addBucket 메서드: 장바구니에 메뉴를 담거나 담지않는 기능을 담당하는 함수이다.
    - 해당 메뉴가 장바구니에 처음 담기면 장바구니에 개수를 1로하여 새로 Map을 추가하고 이미 담겨있는 경우 개수를 1개 추가하도록 했다. 
    - 장바구니에 담는 결정을 번복할 가능성을 고려하여 취소 옵션도 구현해두었다.
  - order메서드: 주문을 하거나 메뉴판으로 돌아가는 기능을 담당하는 메서드이다.
    - 1을 입력: 장바구니 내 품목 전체를 출력하고 총 금액을 보여준 뒤 사용자에 따른 할인율을 보여준다. 해당하는 사용자를 선택하면 할인된 금액 정도와 할인이 적용된 후의 총 금액을 출력한 후 주문이 완료되며 장바구니 내역이 비워지고 처음 메뉴로 돌아가게 된다.
    - 2를 입력: 메뉴판으로 돌아가게 된다. 장바구니가 비워지는 기능 등은 실행되지 않는다.
  - discount메서드: 선택한 사용자에 따른 할인률을 반환하는 함수이다.
  - deleteBucketMenu메서드: 메뉴에서 5번 장바구니를 선택하면 조회, 특정 메뉴 삭제, 전체 삭제의 기능이 제공된다. 입력값에 따라서 대응하는 기능이 실행된다. 
    - 장바구니 비우기 선택: 번복 가능성을 고려해 정말 장바구니를 비울 것인지 여부를 체크하는 기능을 구현했고 동의하는 입력을 받으면 장바구니를 비우는 함수가 호출되고 거부하는 입력을 받으면 뒤로가는 기능이 실행된다. 
  - validCheck메서드: 매 입력을 받을 때마다 기대하는 형식이 아닌 다른 타입의 입력을 받을 때 InputMismatchException이 발생할 가능성이 존재한다. 이에 따라 유효성을 체크하는 함수를 따로 구현해두어 필요할 때마다 사용하도록 했다.
