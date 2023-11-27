package christmas.validator;

import christmas.config.PromotionConfig;
import christmas.domain.order.menu.Menu;
import christmas.domain.order.menu.MenuType;
import christmas.domain.order.menu.Quantity;
import christmas.exception.ErrorMessage;

import java.util.Map;

public class OrderValidator {

    /*
    Menu 검증
     */
    public static void validateHasOnlyDrink(Map<Menu, Quantity> order) {
        if (hasOnlyDrink(order)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
        }
    }

    private static boolean hasOnlyDrink(Map<Menu, Quantity> order) {
        return order.keySet()
                .stream()
                .allMatch(menu -> menu.getType().equals(MenuType.DRINK));
    }

    public static void validateIsTotalQuantityValid(Map<Menu, Quantity> order) {
        if (PromotionConfig.isTotalQuantityGreaterThanCondition(calculateTotalQuantity(order))) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
        }
    }

    private static int calculateTotalQuantity(Map<Menu, Quantity> order) {
        return order.values()
                .stream()
                .mapToInt(Quantity::getPrimitiveQuantity)
                .sum();
    }

    /*
    Quantity 검증
     */
    public static void validateIsEachQuantityGreaterThanCondition(Integer quantity) {
        if (PromotionConfig.isEachQuantityValid(quantity)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
        }
    }

    /*
    Day 검증
     */
    public static void validateIsDateInRange(Integer day) {
        if (!isDayInRange(day)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DATE.getMessage());
        }
    }

    private static boolean isDayInRange(Integer day) {
        return PromotionConfig.isDayInRange(day);
    }
}
