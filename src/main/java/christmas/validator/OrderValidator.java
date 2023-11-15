package christmas.validator;

import christmas.domain.order.menu.Menu;
import christmas.domain.order.menu.MenuType;
import christmas.domain.order.menu.Quantity;
import christmas.exception.ErrorMessage;

import java.util.Map;

public class OrderValidator {

    /*
    Menu 검증
     */
    public static void validateHasOnlyDrink(Map<Menu, Quantity> customerMenus) {
        if (hasOnlyDrink(customerMenus)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
        }
    }

    private static boolean hasOnlyDrink(Map<Menu, Quantity> customerMenus) {
        return customerMenus.keySet()
                .stream()
                .allMatch(menu -> menu.getType().equals(MenuType.DRINK));
    }

    public static void validateIsTotalQuantityValid(Map<Menu, Quantity> customerMenus) {
        if (calculateTotalQuantity(customerMenus) > 20) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
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
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
        }
    }

    /*
    Day 검증
     */
    public static void validateIsDateInRange(Integer day) {
        if (isNumberInRange(day)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
        }
    }

    private static boolean isNumberInRange(Integer number) {
        return number < 1  || number > 31;
    }
}
