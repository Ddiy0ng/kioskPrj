package kioskProject;

import java.util.Map;

public class Bucket {
    //장바구니 클래스, 항목에 대한 결정, 결제 등을 관리


    private Map<String, Map<Double, Integer>> bucketList;
    //String은 고른 메뉴 이름을   => 키 값
    //Double은 고른 메뉴 가격을   => value 값이자 키 값
    //Integer는 고른 메뉴 개수를 저장함 => value 값

    Bucket(Map<String, Map<Double, Integer>> bucketList) {
        this.bucketList = bucketList;
    }


    // 장바구니 리스트(맵) 반환
    public Map<String, Map<Double, Integer>> getBucketList() {
        return bucketList;
    }

    // 장바구니 조회: 고른 메뉴들 전체 출력
    public void getSelectedMenuList(Menu menu) {

        //이름
        System.out.println("==장바구니==");
        int i = 1;
        for(String key1 : bucketList.keySet()){
            //가격
            for(double key2 : bucketList.get(key1).keySet()){
                //개수
                int count = bucketList.get(key1).get(key2);
                System.out.printf("%d. %s   | W %.2f | %d개%n", i++, key1, key2, count);
            }
        }
        System.out.println("========");
    }

    //장바구니의 특정 메뉴의 개수
    public int getCount(String name, Double price) {
        return bucketList.get(name).get(price);
    }

    // 추가 시 개수 1개 증가
    public void addCount(String name, Double price) {
        Map<Double, Integer> value;
        value = bucketList.get(name);//선택한 메뉴의 값과 개수
        value.replace(price, getCount(name, price) + 1);// 개수 + 1
        bucketList.replace(name, value);
    }

    //총 금액
    public double getTotalPrice() {
        double totalPrice = 0;
        for(String key1:bucketList.keySet()) {
            for(Double key2 : bucketList.get(key1).keySet()) {
                int count = bucketList.get(key1).get(key2);
                totalPrice += key2 * count;
            }
        }
        return totalPrice;
    }

    // 장바구니 비우기
    public void deleteBucketList() {
        bucketList.clear();
    }

    // 장바구니에서 특정 메뉴 제거
    public int removeOneBucketMenu(int input) {

        int i = 1;
        int removeCheck = 0;
            for(String key1 : bucketList.keySet()) {
                if (input == i) {
                    System.out.println();
                    System.out.println(key1 + "을(를) 삭제했습니다.\n");
                    bucketList.remove(key1);
                    removeCheck = 1;
                    break;
                }
                i++;
            }
            return removeCheck;

    }

}
