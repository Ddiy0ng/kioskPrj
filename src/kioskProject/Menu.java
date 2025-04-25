package kioskProject;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    //MenuItem 클래스 관리하는 카테고리

    private String[] categoryName = {"Burgers", "Drinks", "Side"};

    // 여러 카테고리의 메뉴를 저장하는 리스트
    private List<List<MenuItem>> category;

    Menu(List<List<MenuItem>> category) {
        this.category = category;
    }

    public String[] getCategoryName(){
        return categoryName;
    }

    // 리스트 리턴 함수
    public List<List<MenuItem>> getList(){
        return category;
    }





}
