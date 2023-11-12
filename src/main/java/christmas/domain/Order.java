package christmas.domain;

import christmas.Menu;
import christmas.MenuType;

import java.util.EnumMap;
import java.util.Map;

public class Order {

    Map<Menu, Quantity> customerMenus = new EnumMap<>(Menu.class);

    public Order(Map<Menu, Quantity> customerMenus) {
        validate(customerMenus);
        this.customerMenus = customerMenus;
    }

    private void validate(Map<Menu, Quantity> customerMenus) {
        validateHasDuplicateMenu(customerMenus);
        validateHasOnlyDrink(customerMenus);
    }

    private void validateHasDuplicateMenu(Map<Menu, Quantity> customerMenus) {
        if (hasDuplicateMenu(customerMenus)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private boolean hasDuplicateMenu(Map<Menu, Quantity> customerMenus) {
        return customerMenus.keySet()
                .stream()
                .distinct()
                .count() != customerMenus.size();
    }

    private void validateHasOnlyDrink(Map<Menu, Quantity> customerMenus) {
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
}
