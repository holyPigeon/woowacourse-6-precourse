package christmas.domain.order.menu;

import java.util.Arrays;
import java.util.Map;

public enum Menu {

    // 기타
    NONE("없음", 0, MenuType.NONE),

    // 에피타이저
    MUSHROOM_SOUP("양송이 스프", 6_000, MenuType.APPETIZER),
    TAPAS("타파스", 5_500, MenuType.APPETIZER),
    CAESAR_SALAD("시저 샐러드", 8_000, MenuType.APPETIZER),

    // 메인
    T_BONE_STEAK("티본스테이크", 55_000, MenuType.MAIN),
    BBQ_RIBS("바비큐립", 54_000, MenuType.MAIN),
    SEAFOOD_PASTA("해산물파스타", 35_000, MenuType.MAIN),
    CHRISTMAS_PASTA("크리스마스파스타", 25_000, MenuType.MAIN),

    // 디저트
    CHOCOLATE_CAKE("초코케이크", 15_000, MenuType.DESSERT),
    ICE_CREAM("아이스크림", 5_000, MenuType.DESSERT),

    // 음료
    ZERO_COKE("제로콜라", 3_000, MenuType.DRINK),
    RED_WINE("레드와인", 60_000, MenuType.DRINK),
    CHAMPAGNE("샴페인", 25_000, MenuType.DRINK);

    private final String name;
    private final int price;
    private final MenuType type;

    Menu(String name, int price, MenuType type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public static Menu findByName(String name) {
        return Arrays.stream(values())
                .filter(menu -> menu.name.equals(name))
                .findAny()
                .orElse(Menu.NONE);
    }

    public static boolean isGiftMenu(Menu menu) {
        return getGiftMenus()
                .keySet()
                .stream()
                .anyMatch(giftMenu -> giftMenu.equals(menu));
    }

    public static Map<Menu, Quantity> getGiftMenus() {
        return Map.of(Menu.CHAMPAGNE, Quantity.create(1));
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
