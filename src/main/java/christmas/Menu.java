package christmas;

import static christmas.MenuType.*;

public enum Menu {

    // 에피타이저
    MUSHROOM_SOUP("양송이 스프", 6_000, APPETIZER),
    TAPAS("타파스", 5_500, APPETIZER),
    CAESAR_SALAD("시저 샐러드", 8_000, APPETIZER),

    // 메인
    T_BONE_STEAK("티본스테이크", 55_000, MAIN),
    BBQ_RIBS("바비큐립", 54_000, MAIN),
    SEAFOOD_PASTA("해산물파스타", 35_000, MAIN),
    CHRISTMAS_PASTA("크리스마스파스타", 25_000, MAIN),

    // 디저트
    CHOCOLATE_CAKE("초코케이크", 15_000, DESSERT),
    ICE_CREAM("아이스크림", 5_000, DESSERT),

    // 음료
    ZERO_COKE("제로콜라", 3_000, DRINK),
    RED_WINE("레드와인", 60_000, DRINK),
    CHAMPAGNE("샴페인", 25_000, DRINK);

    private final String name;
    private final int price;
    private final MenuType type;

    Menu(String name, int price, MenuType type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public MenuType getType() {
        return type;
    }
}
