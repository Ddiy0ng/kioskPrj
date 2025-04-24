package kioskProject;

public class MenuItem {
    //햄버거 이름, 가격
    private String hamburgerName;
    private double hamburgerPrice;
    private String explain;

    MenuItem(String hamburgerName, double hamburgerPrice, String explain){
        this.hamburgerName = hamburgerName;
        this.hamburgerPrice = hamburgerPrice;
        this.explain = explain;
    }

    //전체 메뉴 출력용 함수
    public void getMenu(){
        System.out.printf("%s   | W %f | %s%n", hamburgerName, hamburgerPrice, explain);
    }

    public String getName(){
        return this.hamburgerName;
    }

    public double getPrice(){
        return this.hamburgerPrice;
    }

    public String getExplain(){
        return this.explain;
    }
}
