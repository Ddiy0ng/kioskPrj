package kioskProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        List<MenuItem> hamburgerMenu = new ArrayList<>();
        //리스트에 햄버거 메뉴 추가
        hamburgerMenu.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        hamburgerMenu.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        hamburgerMenu.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        hamburgerMenu.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        Scanner sc = new Scanner(System.in);

        int option;


        while(true){
            System.out.println("[ SHAKESHACK MENU ]");
            for(int i = 0; i < hamburgerMenu.size(); i++){
                System.out.print((i + 1) + ". ");
                hamburgerMenu.get(i).getMenu();
            }
            System.out.println("0. 종료           | 종료");
            System.out.print("-> ");
            option = sc.nextInt();

            switch(option){
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                case 1:
                    System.out.println(hamburgerMenu.get(0).getName() + "를 선택하셨습니다.");
                    System.out.println("가격: " + hamburgerMenu.get(0).getPrice());
                    System.out.println("설명: " + hamburgerMenu.get(0).getExplain());
                    System.out.println();
                    break;
                case 2:
                    System.out.println(hamburgerMenu.get(1).getName() + "를 선택하셨습니다.");
                    System.out.println("가격: " + hamburgerMenu.get(1).getPrice());
                    System.out.println("설명: " + hamburgerMenu.get(1).getExplain());
                    System.out.println();
                    break;
                case 3:
                    System.out.println(hamburgerMenu.get(2).getName() + "를 선택하셨습니다.");
                    System.out.println("가격: " + hamburgerMenu.get(2).getPrice());
                    System.out.println("설명: " + hamburgerMenu.get(2).getExplain());
                    System.out.println();
                    break;
                case 4:
                    System.out.println(hamburgerMenu.get(3).getName() + "를 선택하셨습니다.");
                    System.out.println("가격: " + hamburgerMenu.get(3).getPrice());
                    System.out.println("설명: " + hamburgerMenu.get(3).getExplain());
                    System.out.println();
                    break;
                default:
                    System.out.println("잘못된 입력입니다\n");
                    break;
                //예외처리 안 함
            }
        }
    }
}
