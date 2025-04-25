package kioskProject;

import java.util.*;

public class Kiosk {
    //관리자용 클래스
    private String name;    // 선택 메뉴 이름
    private Double price;   // 선택 메뉴 가격
    private String explain; // 선택 메뉴 설명

    //프로그램 흐름 함수
    public void start(Menu menu, Bucket bucket) {
        Scanner sc = new Scanner(System.in);

        int option;
        int menuOption;


        //시스템
        while (true) {
            // 메인 메뉴
            printCategory(menu,bucket);

            //큰 카테고리: 입력 형식 유효성 검사
            /*while(true) {
                System.out.print("-> ");
                try {
                    option = sc.nextInt();
                    sc.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    sc.nextLine();
                    System.out.println("\n잘못된 형식의 입력입니다. 다시 입력하세요.");
                }
            }
            */
            option = validCheck(sc);

            //option에 따라 다른 카테고리 출력
            switch(option){
                case 0:
                    System.out.println("\n프로그램을 종료합니다.");
                    return;
                case 1:
                    System.out.println("\n[ BURGER MENU ]");
                    printMenu(menu,option);

                    //카테고리 내 메뉴: 입력 형식 유효성 검사
                    menuOption =  validCheck(sc, menu, option);

                    if(menuOption == 0){
                        System.out.println("\n뒤로 돌아갑니다.");
                        continue;
                    }

                    // 고른 메뉴 출력
                    printSelectedMenu(menu, option, menuOption);

                    // 장바구니 추가하든가 안 하든가
                    addBucket(menu, option, menuOption, sc, bucket);

                    break;
                case 2:
                    System.out.println("\n[ BEVERAGE MENU ]");
                    printMenu(menu, option);

                    //카테고리 내 메뉴: 입력 형식 유효성 검사
                    menuOption =  validCheck(sc, menu, option);

                    if(menuOption == 0){
                        System.out.println("\n뒤로 돌아갑니다.");
                        continue;
                    }

                    // 고른 메뉴 출력
                    printSelectedMenu(menu, option, menuOption);

                    // 장바구니 추가하든가 안 하든가
                    addBucket(menu, option, menuOption, sc, bucket);

                    break;
                case 3:
                    System.out.println("\n[ SIDE MENU ]");
                    printMenu(menu, option);

                    //카테고리 내 메뉴: 입력 형식 유효성 검사
                    menuOption =  validCheck(sc, menu, option);

                    if(menuOption == 0){
                        System.out.println("\n뒤로 돌아갑니다.");
                        continue;
                    }

                    // 고른 메뉴 출력
                    printSelectedMenu(menu, option, menuOption);

                    // 장바구니 추가하든가 안 하든가
                    addBucket(menu, option, menuOption, sc, bucket);

                    break;
                case 4:
                    System.out.println("아래와 같이 주문하시겠습니까?\n");
                    bucket.getSelectedMenu(menu);
                    System.out.println("\n[ TOTAL ]");
                    System.out.print("W ");
                    System.out.println(bucket.getTotalPrice());
                    System.out.println();
                    break;
                case 5:
                    System.out.println("아직 구현 안 함");
                    break;
                default:
                    System.out.println("지원하지 않는 옵션번호 입니다.");
            }
        }
    }

    //메인메뉴 출력 함수
    public void printCategory(Menu menu, Bucket bucket){
        System.out.println("[ MAIN MENU ]");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + ". ");
            System.out.println(menu.getCategoryName()[i]);
        }
        System.out.println("0. 종료           | 종료");

        if(!bucket.getBucketList().isEmpty()){
            System.out.println("[ ORDER MENU ]");
            System.out.println("4. Orders      | 장바구니를 확인 후 주문합니다.");
            System.out.println("5. Cancel      |진행중인 주문을 취소합니다.");

        }
    }

    //카테고리 내 메뉴 출력 함수
    public void printMenu(Menu menu, int option){
        for (int i = 0; i < menu.getList().get(option-1).size(); i++) {
            System.out.print((i + 1) + ". ");
            menu.getList().get(option-1).get(i).getMenu();
        }
        System.out.println("0. 뒤로가기");
    }

    //고른 메뉴 출력 함수
    public void printSelectedMenu(Menu menu, int option, int menuOption) {
        name = menu.getList().get(option-1).get(menuOption-1).getName();
        price = menu.getList().get(option-1).get(menuOption-1).getPrice();
        explain = menu.getList().get(option-1).get(menuOption-1).getExplain();

        System.out.println( name+ "를 선택하셨습니다.");
        System.out.println("가격: " + price);
        System.out.println("설명: " + explain);
        System.out.println();


    }

    //장바구니 추가하든가 안 하든가
    public void addBucket(Menu menu, int option, int menuOption, Scanner sc, Bucket bucket){
        int addCheck;

        menu.getList().get(option-1).get(menuOption - 1).getMenu();

        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인           2. 취소");

        while(true){
            addCheck = validCheck(sc);
            if(addCheck == 1) {

                //해당 메뉴가 장바구니에 없으면
                if (!bucket.getBucketList().containsKey(name)) {
                    Map<Double, Integer> value = new HashMap<>();
                    value.put(price, 1);// 선택한 메뉴의 값과 개수를 1로 해서 HashMap 추가
                    bucket.getBucketList().put(name, value);
                }
                else{
                    //개수 1개 추가
                    bucket.addCount(name, price);
                }
                System.out.printf("%s 이 장바구니에 추가되었습니다.%n", name);
                break;
            }
            else if(addCheck == 2){
                System.out.println("취소를 선택했습니다.");
                break;
            }
            else{
                System.out.println("지원하지 않는 번호 옵션입니다. 다시 입력하세요.");
            }
        }
    }

    //유효성 검사
    public int validCheck(Scanner sc){
        while(true) {
            int input;
            System.out.print("-> ");
            try {
                input = sc.nextInt();
                sc.nextLine();
                return input;
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("\n잘못된 형식의 입력입니다. 다시 입력하세요.");
            }
        }
    }

    //IndexOutOfBound 포함 유효성 검사 함수
    public int validCheck(Scanner sc, Menu menu, int option){

        int menuOption;
        while(true){
            System.out.print("-> ");
            try {
                menuOption = sc.nextInt();
                sc.nextLine();
                // IndexOutOfBound 방지
                if(menuOption > menu.getList().get(option-1).size()) {
                    System.out.println("\nIndexOutOfBound. 다시 입력하세요.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("\n잘못된 형식의 입력입니다. 다시 입력하세요.");

            }
        }
        return menuOption;

    }

}