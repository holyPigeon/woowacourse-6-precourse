package christmas.validator;

import christmas.domain.order.menu.Menu;
import christmas.domain.order.menu.MenuType;
import christmas.domain.order.menu.Quantity;

import java.util.Map;

public class OrderValidator {

    /*
    Menu 검증
     */
    public static void validateHasDuplicateMenu(Map<Menu, Quantity> customerMenus) {
        if (hasDuplicateMenu(customerMenus)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static boolean hasDuplicateMenu(Map<Menu, Quantity> customerMenus) {
        return customerMenus.keySet()
                .stream()
                .distinct()
                .count() != customerMenus.size();
    }

    public static void validateHasOnlyDrink(Map<Menu, Quantity> customerMenus) {
        if (hasOnlyDrink(customerMenus)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static boolean hasOnlyDrink(Map<Menu, Quantity> customerMenus) {
        return customerMenus.keySet()
                .stream()
                .filter(menu -> menu.getType().equals(MenuType.DRINK))
                .count() == customerMenus.size();
    }

    public static void validateIsTotalQuantityValid(Map<Menu, Quantity> customerMenus) {
        if (calculateTotalQuantity(customerMenus) > 20) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static int calculateTotalQuantity(Map<Menu, Quantity> customerMenus) {
        return customerMenus.values()
                .stream()
                .mapToInt(Quantity::getPrimitiveQuantity)
                .sum();
    }

    /*
    Quantity 검증
     */
    public static void validateIsGreaterThanCondition(Integer quantity) {
        if (quantity < 1) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    /*
    Day 검증
     */
    public static void validateIsDateInRange(Integer day) {
        if (isNumberInRange(day)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    private static boolean isNumberInRange(Integer number) {
        return number < 1  || number > 31;
    }
}
