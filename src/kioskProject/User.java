package kioskProject;

public enum User{
    Patriot(10),
    Soldier(5),
    Student(3),
    Civilian(0);

    private final int discount;

    User(int discount){
        this.discount = discount;
    }

    //주문 단계에서 사용
    public int getDiscount(){
        return discount;
    }

    public static void printDiscountList(){
        int i = 1;
        for(User user : values()){
            System.out.println(i + ". " +  user + ": " + user.discount + "%");
            i++;
        }
    }
}
