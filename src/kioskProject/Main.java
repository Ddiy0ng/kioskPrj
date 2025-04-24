package kioskProject;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String[] menu = {"종료", "ShackBurger", "SmokeShack", "Cheeseburger", "Hamburger"};
        int input;

        while(true){
            System.out.println("[ SHAKESHACK MENU ]");
            System.out.println("1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
            System.out.println("2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
            System.out.println("3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
            System.out.println("4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거");
            System.out.println("0. 종료           | 종료");
            System.out.print("-> ");
            input = sc.nextInt();

            switch(input){
                case 0:
                    System.out.println("선택: " + menu[input] + "\n");
                    return;
                case 1:
                    System.out.println("선택: " + menu[input] + "\n");
                    break;
                case 2:
                    System.out.println("선택: " + menu[input] + "\n");
                    break;
                case 3:
                    System.out.println("선택: " + menu[input] + "\n");
                    break;
                case 4:
                    System.out.println("선택: " + menu[input] + "\n");
                    break;
                default:
                    System.out.println("잘못된 입력입니다\n");
                    break;
                //InputMismatchException 예외처리 하지 않았습니다.

            }
        }



    }
}
