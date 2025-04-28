package kioskProject;

import java.util.*;

public class Main {
    public static void main(String[] args){



        //햄버거 메뉴
        List<MenuItem> hamburger = new ArrayList<>();
        hamburger.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        hamburger.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        hamburger.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        hamburger.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        //음료 메뉴
        List<MenuItem> beverage = new ArrayList<>();
        beverage.add(new MenuItem("Coke", 2.0, "코카콜라"));
        beverage.add(new MenuItem("Sprite", 2.0, "스프라이트"));
        beverage.add(new MenuItem("Water", 1.0, "물"));

        //사이드 메뉴
        List<MenuItem> side = new ArrayList<>();
        side.add(new MenuItem("French fry", 2.0, "따끈따끈하고 바삭한 감자 튀김"));
        side.add(new MenuItem("Cheese stick", 2.0, "길게 늘어나는 치즈 스틱"));
        side.add(new MenuItem("Onion ring", 2.5, "바삭한 어니언링"));
        side.add(new MenuItem("Salad", 2.5, "신선하고 다양한 야채로 구성된 샐러드"));
        side.add(new MenuItem("Chocolate icecream", 1.8, "초콜릿 맛의 아이스크림"));
        side.add(new MenuItem("Chicken", 1.8, "치킨 다리 한 개"));

        List<List<MenuItem>> category = new ArrayList<>();
        category.add(hamburger);
        category.add(beverage);
        category.add(side);

        //메뉴 객체
        Menu menu = new Menu(category);

        //Kiosk 객체 생성
        Kiosk kiosk = new Kiosk();

        //장바구니 객체
        Map<String, Map<Double, Integer>> bucketList = new LinkedHashMap<>();
        Bucket bucket = new Bucket(bucketList);

        //Kiosk 내 시작 함수 호출
        kiosk.start(menu, bucket);
    }
}
