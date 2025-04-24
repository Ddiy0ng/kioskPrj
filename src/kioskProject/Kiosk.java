package kioskProject;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    //관리자용 클래스

    List<MenuItem> menuItems;

    Kiosk(List<MenuItem> menuItems){
        this.menuItems = menuItems;
    }



    public void start(){
        Scanner sc = new Scanner(System.in);

        int option;

        while(true){
            System.out.println("[ SHAKESHACK MENU ]");
            for(int i = 0; i < menuItems.size(); i++){
                System.out.print((i + 1) + ". ");
                menuItems.get(i).getMenu();
            }
            System.out.println("0. 종료           | 종료");
            while(true){
                System.out.print("-> ");
                try{
                    option = sc.nextInt();
                    sc.nextLine(); //버퍼 비우기
                    break;
                }catch(InputMismatchException e){
                    sc.nextLine(); //버퍼 비우기
                    System.out.println("잘못된 형식의 입력입니다. 다시 입력하세요.");
                }
            }
            switch(option){
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                case 1:
                    System.out.println(menuItems.get(0).getName() + "를 선택하셨습니다.");
                    System.out.println("가격: " + menuItems.get(0).getPrice());
                    System.out.println("설명: " + menuItems.get(0).getExplain());
                    System.out.println();
                    break;
                case 2:
                    System.out.println(menuItems.get(1).getName() + "를 선택하셨습니다.");
                    System.out.println("가격: " + menuItems.get(1).getPrice());
                    System.out.println("설명: " + menuItems.get(1).getExplain());
                    System.out.println();
                    break;
                case 3:
                    System.out.println(menuItems.get(2).getName() + "를 선택하셨습니다.");
                    System.out.println("가격: " + menuItems.get(2).getPrice());
                    System.out.println("설명: " + menuItems.get(2).getExplain());
                    System.out.println();
                    break;
                case 4:
                    System.out.println(menuItems.get(3).getName() + "를 선택하셨습니다.");
                    System.out.println("가격: " + menuItems.get(3).getPrice());
                    System.out.println("설명: " + menuItems.get(3).getExplain());
                    System.out.println();
                    break;
                default:
                    System.out.println("지원하지 않는 옵션입니다. 메인메뉴로 돌아갑니다.\n");
                    break;
            }
        }
    }
}