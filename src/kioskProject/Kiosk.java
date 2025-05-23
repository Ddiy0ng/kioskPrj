package kioskProject;

import java.util.*;

public class Kiosk {
    //관리자용 클래스
    private String selectedName;    // 선택 메뉴 이름
    private Double selectedPrice;   // 선택 메뉴 가격
    private String selectedExplain; // 선택 메뉴 설명

    //프로그램 흐름 함수
    public void start(Menu menu, Bucket bucket) {
        Scanner sc = new Scanner(System.in);

        int option; // 카테고리 선택
        int menuOption; // 세부 메뉴 선택


        //시스템
        while (true) {

            // 메인 메뉴 출력, 장바구니에 담은 물품 있으면 주문 메뉴 출력 추가
            printCategory(menu,bucket);

            //큰 카테고리: 입력 형식 유효성 검사_int 타입 아닐 시 예외처리
            option = validCheck(sc);
            if(bucket.getBucketList().isEmpty()&&((option == 4)||(option == 5))) {
                System.out.println("\n지원하지 않는 옵션번호 입니다.\n");
                continue;
            }

            //선택한 카테고리에 따른 출력
            switch(option) {
                case 0:
                    System.out.println("\n프로그램을 종료합니다.");
                    return;
                case 1:
                    System.out.println("\n[ BURGER MENU ]");
                    //1~존재하는 메뉴, 0번 메뉴까지 출력
                    printMenu(menu,option);

                    //카테고리 내 메뉴: 입력 형식 유효성 검사_int 타입 아닐 시 예외처리, 배열 크기 초과 입력 처리 포함
                    //선택 메뉴 출력 포함
                    menuOption =  menuSelect(sc, menu, option);

                    //0 입력 시
                    if(menuOption == 0) {
                        continue;
                    }

                    // 장바구니 추가하든가 안 하든가
                    addBucket(menu, option, menuOption, sc, bucket);

                    break;
                case 2:
                    System.out.println("\n[ BEVERAGE MENU ]");
                    printMenu(menu, option);

                    //카테고리 내 메뉴: 입력 형식 유효성 검사_int 타입 아닐 시 예외처리, 배열 크기 초과 입력 처리 포함
                    //선택 메뉴 출력 포함
                    menuOption =  menuSelect(sc, menu, option);

                    //0 입력 시
                    if(menuOption == 0) {
                        continue;
                    }

                    // 장바구니 추가하든가 안 하든가
                    addBucket(menu, option, menuOption, sc, bucket);

                    break;
                case 3:
                    System.out.println("\n[ SIDE MENU ]");
                    printMenu(menu, option);

                    //카테고리 내 메뉴: 입력 형식 유효성 검사_int 타입 아닐 시 예외처리, 배열 크기 초과 입력 처리 포함
                    //선택 메뉴 출력 포함
                    menuOption =  menuSelect(sc, menu, option);

                    //0 입력 시
                    if(menuOption == 0) {
                        continue;
                    }

                    // 장바구니 추가하든가 안 하든가
                    addBucket(menu, option, menuOption, sc, bucket);

                    break;
                case 4://주문하기
                    order(menu, bucket, sc);
                    break;
                case 5:
                    BucketMenu(menu, bucket, sc);
                    break;
                default:
                    System.out.println("\n지원하지 않는 옵션번호 입니다.\n");
            }
        }
    }


    /*start()에서 사용할 함수*/
    //메인메뉴 출력 함수
    public void printCategory(Menu menu, Bucket bucket) {
        System.out.println("[ MAIN MENU ]");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + ". ");
            System.out.println(menu.getCategoryName()[i]);
        }
        System.out.println("0. 종료           | 종료");

        //장바구니에 담은 물품 있으면 주문 메뉴 출력 추가
        if(!bucket.getBucketList().isEmpty()) {
            System.out.println("\n[ ORDER MENU ]");
            System.out.println("4. Orders      | 장바구니를 확인 후 주문합니다.");
            System.out.println("5. Bucket      | 장바구니 내 품목을 조회, 삭제합니다.");

        }
    }

    //카테고리 내 메뉴 출력 함수
    public void printMenu(Menu menu, int option) {

        // 해당 카테고리의 크기만큼 반복해서 메노 모두 출력
        for (int i = 0; i < menu.getList().get(option-1).size(); i++) {
            System.out.print((i + 1) + ". ");
            menu.getList().get(option-1).get(i).getMenu();
        }
        System.out.println("0. 뒤로가기");
    }

    //고른 메뉴 출력 함수
    public void printSelectedMenu(Menu menu, int option, int menuOption) {
        //리스트의. 특정 카테고리. 특정 메뉴. 이름, 가격, 설명
        selectedName = menu.getList().get(option-1).get(menuOption-1).getName();
        selectedPrice = menu.getList().get(option-1).get(menuOption-1).getPrice();
        selectedExplain = menu.getList().get(option-1).get(menuOption-1).getExplain();

        System.out.println();
        System.out.println( selectedName+ "를 선택하셨습니다.");
        System.out.println("가격: " + selectedPrice);
        System.out.println("설명: " + selectedExplain);
        System.out.println();
    }

    //IndexOutOfBound 포함 유효성 검사 함수
    public int menuSelect(Scanner sc, Menu menu, int option) {

        int menuOption;
        while(true) {
            System.out.print("-> ");
            try {
                menuOption = sc.nextInt();

                if(menuOption == 0) {
                    System.out.println("\n뒤로 돌아갑니다.\n");
                    return 0;
                }
                // 고른 메뉴 출력
                printSelectedMenu(menu, option, menuOption);

                break;
            } catch (InputMismatchException | IndexOutOfBoundsException e) {
                sc.nextLine();
                System.out.println("\n잘못된 형식의 입력입니다. 다시 입력하세요.");

            }
        }
        return menuOption;

    }

    //장바구니 추가하기 추가 안 하기
    public void addBucket(Menu menu, int option, int menuOption, Scanner sc, Bucket bucket) {
        int addCheck;

        menu.getList().get(option-1).get(menuOption - 1).getMenu();

        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인           2. 취소");

        while(true){
            addCheck = validCheck(sc);
            if(addCheck == 1) {

                //해당 메뉴가 장바구니에 없으면
                if (!bucket.getBucketList().containsKey(selectedName)) {
                    Map<Double, Integer> value = new LinkedHashMap<>();
                    value.put(selectedPrice, 1);// 선택한 메뉴의 값과 개수를 1로 해서 Map 추가
                    bucket.getBucketList().put(selectedName, value);
                }
                else {
                    //개수 1개 추가
                    bucket.addCount(selectedName, selectedPrice);
                }
                System.out.printf("%n%s | 상품이 장바구니에 추가되었습니다.%n%n", selectedName);
                break;
            }
            else if(addCheck == 2) {
                System.out.println("\n취소를 선택했습니다.\n");
                break;
            }
            else {
                System.out.println("\n지원하지 않는 번호 옵션입니다. 다시 입력하세요.");
            }
        }
    }

    //주문하기
    public void order(Menu menu, Bucket bucket, Scanner sc) {
        int orderOrNot;
        double totalPrice = bucket.getTotalPrice();

        System.out.println("\n아래와 같이 주문하시겠습니까?\n");

        //장바구니 자동 조회(출력)
        bucket.getSelectedMenuList(menu);

        //총 금액
        System.out.println("\n[ TOTAL ]");
        System.out.print("W ");
        System.out.printf("%.2f%n", totalPrice);
        System.out.println();
        System.out.println("1. 주문           2. 메뉴판");

        while(true) {
            orderOrNot = validCheck(sc);
            if(orderOrNot == 1) {
                //할인 리스트 보여주기
                System.out.println();//UI 정리용
                User.printDiscountList();
                double discountPercent = discount(sc);

                System.out.println("\n할인률: " + discountPercent + "%");
                System.out.printf("할인: %.2f%n", totalPrice*(discountPercent/100));
                System.out.printf("결제 금액: %.2f", totalPrice*((100-discountPercent)/100));

                //적용된 할인률과 원가, 할인가 출력
                System.out.printf("%n주문이 완료되었습니다. 결제 금액은 W %.2f 입니다.%n%n", totalPrice*((100-discountPercent)/100));

                // 주문 완료 후 장바구니 비우기
                bucket.deleteBucketList();

                System.out.println("처음으로 돌아갑니다.");
                System.out.println();
                break;
            }
            else if(orderOrNot == 2) {
                // 주문을 취소하고 변경, 추가 등을 위해 메뉴판으로 돌아가기
                System.out.println("\n메뉴판으로 돌아갑니다.\n");
                break;
            }
            else {
                System.out.println("\n지원하지 않는 번호 옵션입니다. 다시 입력하세요.\n");
            }
        }
    }

    //할인 적용
    public int discount(Scanner sc) {
        int input;
        System.out.println("해당하는 사용자 옵션을 선택해주세요.");
        while(true) {
            input = validCheck(sc);
            for(User user : User.values()) {
                int num = user.ordinal();
                if(num == input-1)
                    return user.getDiscount();
            }
            System.out.println("\n잘못된 입력입니다. 다시 입력하세요.");
        }
    }

    //장바구니 품목 삭제
    public void BucketMenu(Menu menu, Bucket bucket, Scanner sc) {

        int input;

        System.out.println("\n장바구니 확인");
        System.out.println("1. 조회");
        System.out.println("2. 품목 삭제");
        System.out.println("3. 전체 삭제");

        while(true) {
            input = validCheck(sc);

            if(input == 1){
                System.out.println();
                bucket.getSelectedMenuList(menu);
                System.out.println();
                break;
            }
            else if(input == 2) {
                System.out.println();
                bucket.getSelectedMenuList(menu);
                System.out.println("삭제할 품목의 번호를 입력해주세요.");
                System.out.println("뒤로 돌아가려면 0을 입력해주세요.");
                while(true) {
                    int deleteOneBucketMenu = validCheck(sc);

                    if(deleteOneBucketMenu == 0) {
                        System.out.println("\n뒤로 돌아갑니다.\n");
                        break;
                    }

                    int removeCheck = bucket.removeOneBucketMenu(deleteOneBucketMenu);
                    if(removeCheck == 1)
                        break;
                    else {
                        System.out.println("\n잘못된 입력입니다. 다시 입력해주세요");
                    }
                }
                break;
            }
            else if(input == 3) {
                //장바구니 완전 비우기
                int resetCheck;

                System.out.println();
                bucket.getSelectedMenuList(menu);

                //여부 체크
                System.out.println("\n정말 장바구니를 비우시겠습니까?");
                System.out.println("1. 네           2. 아니요");
                while(true) {
                    resetCheck = validCheck(sc);
                    if(resetCheck == 1) {
                        System.out.println("\n장바구니의 품목을 모두 지웠습니다.\n");
                        bucket.deleteBucketList();
                        break;
                    }
                    else if(resetCheck == 2) {
                        System.out.println("\n뒤로 돌아갑니다.\n");
                        break;
                    }
                    else {
                        System.out.println("\n잘못된 입력입니다. 다시 입력해주세요");
                    }
                }
                break;
            }
            else {
                System.out.println("\n잘못된 입력입니다. 다시 입력하세요.");
            }
        }
    }

    //유효성 검사
    public int validCheck(Scanner sc) {
        while(true) {
            int input;
            System.out.print("-> ");
            try {
                input = sc.nextInt();
                sc.nextLine();//버퍼 비우기
                return input;
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("\n잘못된 형식의 입력입니다. 다시 입력하세요.");
            }
        }
    }

}