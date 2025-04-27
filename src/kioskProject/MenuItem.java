package kioskProject;

public class MenuItem {

    private String name;
    private double price;
    private String explain;



    MenuItem(String name, double price, String explain){
        this.name = name;
        this.price = price;
        this.explain = explain;
    }


    //전체 메뉴 출력용 함수
    public void getMenu(){
        System.out.printf("%s   | W %f | %s%n", name, price, explain);
    }


    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }

    public String getExplain(){
        return this.explain;
    }
}
