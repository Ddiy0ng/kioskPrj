package kioskProject;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Bucket {
    //장바구니 클래스, 항목에 대한 결정, 결제 등을 관리


    private Map<String, Map<Double, Integer>> bucketList;
    //String은 고른 메뉴 이름을
    //Double은 고른 메뉴 가격을
    //Integer는 고른 메뉴 개수를 저장함

    Bucket(Map<String, Map<Double, Integer>> bucketList){
        this.bucketList = bucketList;
    }


    public Map<String, Map<Double, Integer>> getBucketList(){
        return bucketList;
    }


    //고른 메뉴들 전체 출력
    public void getSelectedMenu(Menu menu){
        for(String key:bucketList.keySet()){
            for(int i = 0; i < menu.getList().size(); i++){
                for(int j = 0; j < menu.getList().get(i).size(); j++){
                    if(key.equals(menu.getList().get(i).get(j).getName()))
                        menu.getList().get(i).get(j).getMenu();
                }
            }
        }
    }


    public int getCount(String name, Double price){
        //장바구니의 특정 메뉴의 개수
        return bucketList.get(name).get(price);
    }

    public void addCount(String name, Double price){
        Map<Double, Integer> value;
        value = bucketList.get(name);//선택한 메뉴의 값과 개수
        value.replace(price, getCount(name, price) + 1);// 개수 + 1
        bucketList.replace(name, value);
    }

    //장바구니에 담긴 메뉴의 종류 수
    public int getBucketListSize(){
        return bucketList.size();
    }

    //total price
    public double getTotalPrice(){
        double totalPrice = 0;
        for(String key1:bucketList.keySet()){
            Map<Double, Integer> value1 = bucketList.get(key1);
            for(Double key2 : value1.keySet()){
                int count = value1.get(key2);
                totalPrice += key2 * count;
            }
        }
        return totalPrice;
    }


    // 전체 항목 삭제
    public void removeBucketList(){
        bucketList.clear();
    }


    // 항목 조회
        // 장바구니에 물건이 들어있으면 쓸 수 있는 기능

    // 주문
        //담은 모든 항목 출력
        // 총 금액 출력, 주문하기 클릭 시 장바구니 초기화
}
