package kioskProject;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Kiosk {
    //관리자용 클래스

    //프로그램 흐름 함수
    public void start(Menu menu) {
        Scanner sc = new Scanner(System.in);

        int option;
        int menuOption;

        //시스템
        while (true) {
            // 메인 메뉴
            printCategory(menu);

            //큰 카테고리: 입력 형식 유효성 검사
            while(true) {
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

                    break;
            }
        }
    }

    //메인메뉴 출력 함수
    public void printCategory(Menu menu){
        System.out.println("[ MAIN MENU ]");
        for (int i = 0; i < menu.getCategoryName().length; i++) {
            System.out.print((i + 1) + ". ");
            System.out.println(menu.getCategoryName()[i]);
        }
        System.out.println("0. 종료           | 종료");
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
        System.out.println(menu.getList().get(option-1).get(menuOption-1).getName() + "를 선택하셨습니다.");
        System.out.println("가격: " + menu.getList().get(option-1).get(menuOption-1).getPrice());
        System.out.println("설명: " + menu.getList().get(option-1).get(menuOption-1).getExplain());
        System.out.println();
    }

    //유효성 검사 함수
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